package serial;

import com.dandb.dto.verified.VerifiedBusiness;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class VerifiedDeserializer implements JsonDeserializer<VerifiedBusiness> {

	public VerifiedBusiness deserialize(JsonElement je, java.lang.reflect.Type type,
			JsonDeserializationContext jdc) throws JsonParseException {
		JsonElement content = je.getAsJsonObject().getAsJsonObject("response").get("results");
		return new Gson().fromJson(content, VerifiedBusiness.class);
	}
}
