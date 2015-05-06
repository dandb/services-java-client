package serial;

import com.dandb.api.exceptions.DandBError;
import com.dandb.dto.Entitlement;
import com.dandb.dto.MetaErrorWrapper;
import com.dandb.dto.UserEntitlements;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class UserEntitlementsDeserializer implements JsonDeserializer<UserEntitlements> {

    public UserEntitlements deserialize(JsonElement je, java.lang.reflect.Type type,
            JsonDeserializationContext jdc) throws JsonParseException {
        
        JsonObject meta = je.getAsJsonObject().getAsJsonObject("meta");
        if(meta.get("code").getAsInt() == 403){
            JsonArray error = je.getAsJsonObject().get("error").getAsJsonArray();
            throw new DandBError(error.getAsString(), new Gson().fromJson(je, MetaErrorWrapper.class));
        }
        JsonArray content = je.getAsJsonObject().getAsJsonObject("response").getAsJsonArray("entitlements");
        UserEntitlements userEntitlements = new UserEntitlements();
        Gson gSon = new Gson();
        for (int i=0;i<content.size();i++) {
            userEntitlements.getEntitlements().add(gSon.fromJson(content.get(i), Entitlement.class));
        }
        return userEntitlements;
    }
}

