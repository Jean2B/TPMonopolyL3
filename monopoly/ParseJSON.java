package monopoly;

import java.io.InputStream;
import org.json.*;

public class ParseJSON {
	private static final String FICHIER = "plateau.json";
	private JSONObject json;
	
	public ParseJSON() {
		json = loadJSON();
	}
	
	public JSONObject loadJSON() {
        String resourceName = FICHIER;
        InputStream is = ParseJSON.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        return object;
    }
	
	public String getTypeCase(int nbCase) {
	    JSONObject c = json.getJSONObject("" + nbCase);
	    return c.getString("type");
	}
	
	public String getNomPropriete(int nbCase) {
		JSONObject propriete = json.getJSONObject("" + nbCase).getJSONObject("propriete");
		return propriete.getString("nom");
	}
	
	public int getPrixPropriete(int nbCase) {
		JSONObject propriete = json.getJSONObject("" + nbCase).getJSONObject("propriete");
		return propriete.getInt("prix");
	}
	
	public int getMontant(int nbCase) {
		JSONObject c = json.getJSONObject("" + nbCase);
	    return c.getInt("montant");
	}
}
