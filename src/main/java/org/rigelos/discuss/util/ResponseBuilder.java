package org.rigelos.discuss.util;

import org.json.JSONObject;

public class ResponseBuilder {

	public static JSONObject build(String code, JSONObject data){
		JSONObject result = new JSONObject();
		JSONUtils.put(result, "result", code);

		if(data!=null)
			JSONUtils.put(result, "data", data);
		return result;
	}
}
