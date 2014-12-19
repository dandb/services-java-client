package com.dandb.api.errors;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.RetrofitError.Kind;

import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.api.exceptions.DandBApiException;
import com.dandb.api.exceptions.DandBError;
import com.dandb.api.exceptions.UserAuthException;
import com.dandb.api.exceptions.VerificationException;
import com.dandb.dto.MetaErrorWrapper;

public class DandBErrorHandler implements ErrorHandler {
	
	public Throwable handleError(RetrofitError cause) {
		if(cause.getKind().equals(Kind.CONVERSION)){
			MetaErrorWrapper metaErrorWrapper = getMetaErrorWrapper(cause);
			if(metaErrorWrapper.getErrorCode().equals(UserErrors.USER_ROUTE_INCORRECT_CREDENTIALS)){
				return new UserAuthException(metaErrorWrapper.getErrors());
			} else if(metaErrorWrapper.getErrorCode().equals(AuthErrors.INVALID_CLIENT)){
				return new ClientAuthException(metaErrorWrapper.getErrors());
			} else if (metaErrorWrapper.getErrorCode().equals(VerifiedErrors.VERIFIED_PROFILE_PENDING)){
				return new VerificationException(metaErrorWrapper.getErrors());
			} else if (metaErrorWrapper.getErrorCode().equals(VerifiedErrors.VERIFIED_BUSINESS_NOT_FOUND)){
				return new VerificationException(metaErrorWrapper.getErrors());
			} else if (metaErrorWrapper.getErrorCode().equals(GeneralErrors.VALIDATION_ERROR)){
				return new DandBApiException(metaErrorWrapper.getErrors());
			} else {
				return new DandBApiException(metaErrorWrapper.getErrors());
			}
		}
		return cause;
	}

	private MetaErrorWrapper getMetaErrorWrapper(RetrofitError cause) {
		return ((DandBError)cause.getCause().getCause()).metaErrorWrapper;
	}
	
}
