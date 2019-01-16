package hnefatafl;
//Dit is nodig omdat we voor de players erving toepassen, uitleg staat op pagina 175 tot 177 in de cursus

import com.google.gson.*;

/**
 * @author Steve, Lowie, Mika
 *
 * The deserializer for the players
 */
public class PlayerDeSerializer implements JsonDeserializer<Player> {
    /**
     * Deserializes a json element representing a player class
     *
     * @param json The JsonElement to deserialize
     * @param type
     * @param jsonDeserializationContext
     * @return
     * @throws JsonParseException
     */
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
