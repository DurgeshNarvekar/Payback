package utils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {

	public String getJSONData(String KeyName) {
		String Value = "";
		String CurrentDir = System.getProperty("user.dir");
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(CurrentDir + "\\src\\main\\resources\\Config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			Value = jsonObject.get(KeyName).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Value;
	}
}
