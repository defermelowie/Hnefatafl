package hnefatafl;
//Deze klasse is nodig omdat we voor de players erving toepassen, uitleg staat op pagina 175 tot 177 in de cursus

import com.google.gson.*;

/**
 * The deserializer for the players
 *
 * @author Steve, Lowie, Mika
 */
public class PlayerDeSerializer implements JsonDeserializer<Player> {
    /**
     * Deserializes a json element representing a player class
     *
     * @param json                       The JsonElement to deserialize
     * @param type                       Not relevant, Uitleg pagina 176 in de cursus
     * @param jsonDeserializationContext Uitleg pagina 176 in de cursus
     * @return An instance of the right player subclass
     */
    @Override
    public Player deserialize(JsonElement json, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String color = jsonObject.get("color").getAsString();
        int playTime = jsonObject.get("playTimeMillis").getAsInt();
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
