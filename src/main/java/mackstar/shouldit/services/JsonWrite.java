package mackstar.shouldit.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.jr.ob.JSON;
import com.fasterxml.jackson.jr.ob.JSON.Feature;

public class JsonWrite {
	static Map<String,Object> map = new HashMap<String,Object>();
	
	static String outputFile = "shouldit-report.json";
	
	@SuppressWarnings("unchecked")
	public static void add(String context, String it, String result) {
		
		Map<String,String> object = new HashMap<String,String>();

		object.put(it, result);
		HashMap<String, String> origObject = (HashMap<String, String>) map.get(context);
		if (origObject == null) {
			map.put(context, object);
			return;
		}
		origObject.put(it, result);
		map.put(context, origObject);
	}
	
	public static void setOutputFile(String fileName) {
		outputFile = fileName;
	}
	
	public static void write() {
		String json = null;
		try {
			json = JSON.std.with(Feature.PRETTY_PRINT_OUTPUT).asString(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
			writer.print(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
