package serial;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class MetaDeserializer<T> implements JsonDeserializer<T> {

	public T deserialize(JsonElement je, java.lang.reflect.Type type,
			JsonDeserializationContext jdc) throws JsonParseException {
		JsonElement content = je.getAsJsonObject().get("response");
		return new Gson().fromJson(content, type);
	}
}
