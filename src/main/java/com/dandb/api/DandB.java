package com.dandb.api;

import java.util.HashMap;
import java.util.Map;

import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.converter.GsonConverter;
import serial.BusinessDetailDeserializer;
import serial.MetaDeserializer;
import serial.VerifiedDeserializer;

import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.errors.DandBErrorHandler;
import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.api.exceptions.DandBApiException;
import com.dandb.api.exceptions.UserAuthException;
import com.dandb.api.http.AuthRequestIntercepter;
import com.dandb.api.http.TimeoutUrlConnectionClient;
import com.dandb.api.http.UserRequestIntercepter;
import com.dandb.api.test.AuthStub;
import com.dandb.api.test.BusinessServiceStub;
import com.dandb.api.test.UserServiceStub;
import com.dandb.api.test.VerifiedServiceStub;
import com.dandb.dto.BusinessDetail;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.OAuthRequest;
import com.dandb.dto.UserToken;
import com.dandb.dto.VerifiedBusinessSearchResults;
import com.dandb.dto.verified.VerifiedBusiness;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("rawtypes")
public class DandB {
	
	Gson gson = new GsonBuilder()
	    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
	    .registerTypeAdapter(VerifiedBusinessSearchResults.class, new MetaDeserializer<VerifiedBusinessSearchResults>())
	    .registerTypeAdapter(BusinessSearchResults.class, new MetaDeserializer<BusinessSearchResults>())
	    .registerTypeAdapter(VerifiedBusiness.class, new VerifiedDeserializer())
	    .registerTypeAdapter(UserToken.class, new MetaDeserializer<UserToken>())
	    .registerTypeAdapter(ResponseSuccess.class, new MetaDeserializer<ResponseSuccess>())
	    .registerTypeAdapter(BusinessDetail.class,  new BusinessDetailDeserializer())
	    .create();
	
	private static final Map<Class, Object> map;
    static {
        map = new HashMap<Class, Object>();
        map.put(UserService.class, new UserServiceStub());
        map.put(VerifiedService.class, new VerifiedServiceStub());
        map.put(BusinessService.class, new BusinessServiceStub());
        map.put(Auth.class, new AuthStub());
    }

	private String access_token;

	private DandBConfig config;

	private UserToken userToken;
	
	public DandB(DandBConfig config) throws ClientAuthException, DandBApiException {
		if(!config.ready()){
			throw new DandBApiException("You must supply a client id and client secret or an access token.");
		}
		this.config = config; 
		this.access_token = config.getAccessToken();
		
	}

	public VerifiedService verified(String email, String password) throws UserAuthException, ClientAuthException{
		return verified(userToken.user_token);
	}
	
	public VerifiedService verified(String userToken) throws ClientAuthException {
		return verifiedCommon(userToken);
	}
	
	public VerifiedService verified() throws ClientAuthException{
		RestAdapter build = restAdapterCommonClientAuth(new RestAdapter.Builder())
			.setConverter(new GsonConverter(gson))
			.build();
		return createService(build, VerifiedService.class);
	}
	
	public UserToken userLogin(String email, String password) throws UserAuthException, ClientAuthException{
		return getUserToken(email, password);
	}
	
	public UserService users(String userToken) throws ClientAuthException {
		return userInterceptedService(userToken, UserService.class);
	}
	
	public BusinessService business() throws ClientAuthException {
		RestAdapter build = restAdapterCommonClientAuth(new RestAdapter.Builder())
				.setConverter(new GsonConverter(gson))
				.build();
		return createService(build, BusinessService.class);
	}

	public BusinessService business(String userToken) throws ClientAuthException {
		return userInterceptedService(userToken, BusinessService.class);
	}

	public UserToken getUserToken(String email, String password) throws UserAuthException, ClientAuthException{
		if(userToken == null){
			RestAdapter build = restAdapterCommon(new RestAdapter.Builder()
			.setRequestInterceptor(new AuthRequestIntercepter(getAccessToken()))
			.setConverter(new GsonConverter(gson)))
				.build();
			userToken = createService(build, UserService.class).login(email, password);
		}
		return userToken;
	}

	@SuppressWarnings("unchecked")
	private <T> T createService(RestAdapter build, Class<T> clazz){
		return this.createService(build, clazz, (T) map.get(clazz));
	}
	
	private <T> T createService(RestAdapter build, Class<T> clazz, T t) {
		if(config.isTestMode()){
			MockRestAdapter mock = MockRestAdapter.from(build);
			mock.setDelay(0);
			mock.setErrorPercentage(0);
			return mock.create(clazz, t);
		} else {
			return build.create(clazz);
		}
	}

	private Builder restAdapterCommonClientAuth(RestAdapter.Builder builder) throws ClientAuthException {
		builder.setRequestInterceptor(new AuthRequestIntercepter(getAccessToken()));
		return restAdapterCommon(builder);
	}
	
	public String getAccessToken() throws ClientAuthException{
		if(access_token == null){ 
			Auth createService = this.createService(this.getRestAdapterForAuth(), Auth.class);
			access_token = createService
				.authenticate(new OAuthRequest(config.getClientId(), config.getClientSecret())).access_token;
		}
		return access_token;
	}
	
	private Builder restAdapterCommon(RestAdapter.Builder builder) {
		return builder
				.setEndpoint(config.getEndpoint())
				.setErrorHandler(new DandBErrorHandler())
				.setLogLevel(config.getLogLevel())
				.setClient(new TimeoutUrlConnectionClient(config.getTimeout()));
	}
	
	private RestAdapter getRestAdapterForAuth() {
		return restAdapterCommon(new RestAdapter.Builder()).build();
	}

	private VerifiedService verifiedCommon(String userToken) throws ClientAuthException {
		return userInterceptedService(userToken, VerifiedService.class);
	}

	private <T> T  userInterceptedService(String userToken, Class<T> clazz)
			throws ClientAuthException {
		RestAdapter build = restAdapterCommon(new RestAdapter.Builder()
				.setRequestInterceptor(new UserRequestIntercepter(getAccessToken(), userToken))
				.setConverter(new GsonConverter(gson)))
					.build();
		return this.createService(build, clazz);
	}
}
