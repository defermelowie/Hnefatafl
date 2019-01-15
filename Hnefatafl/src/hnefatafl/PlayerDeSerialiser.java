package hnefatafl;
//Dit is nodig omdat we voor de players erving toepassen, uitleg staat op pagina 175 tot 177 in de cursus

import com.google.gson.*;

public class PlayerDeSerialiser implements JsonDeserializer<Player> {
    @Override
    public Player deserialize(JsonElement json, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String color = jsonObject.get("color").getAsString();
        int playTime = jsonObject.get("playTimeMillis").getAsInt();
        Gson gson = new Gson();
        Player p;
        if (color.equals("WHITE")) {
            p = new WhitePlayer();
            p.setPlayTime(playTime);
        } else {
            p = new BlackPlayer();
            p.setPlayTime(playTime);
        }
        return p;
    }
}
