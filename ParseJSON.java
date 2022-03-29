package it3;

import java.io.InputStream;
import org.json.*;

public class ParseJSON {
	private static final String FICHIER = "plateau.json";
	
	public static void main(String[] args) {
        System.out.println(getTypeCase(0));
    }
	
	public static JSONObject getJSON() {
        String resourceName = FICHIER;
        InputStream is = ParseJSON.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        return object;
    }
	
	public static String getTypeCase(int nbCase) {
		JSONObject json = getJSON();
	    JSONObject c = json.getJSONObject("" + nbCase);
	    return c.getString("type");
	}
}
