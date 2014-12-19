package serial;

import com.dandb.api.exceptions.DandBError;
import com.dandb.dto.MetaErrorWrapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class MetaDeserializer<T> implements JsonDeserializer<T> {

	public T deserialize(JsonElement je, java.lang.reflect.Type type,
			JsonDeserializationContext jdc) throws JsonParseException {
		JsonObject meta = je.getAsJsonObject().getAsJsonObject("meta");
		if(meta.get("code").getAsInt() == 403){
			JsonArray error = je.getAsJsonObject().get("error").getAsJsonArray();
			throw new DandBError(error.getAsString(), new Gson().fromJson(je, MetaErrorWrapper.class));
		}
		JsonElement content = je.getAsJsonObject().get("response");
		return new Gson().fromJson(content, type);
	}
	
}
