package org.rigelos.discuss.util;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtils {
    private static final Log LOGGER = LogFactory.getLog(JSONUtils.class);

    public static JSONObject json(Object obj) {
        return json(obj, new String[]{});
    }

    public static <T> JSONArray toJSONArray(List<T> objectList){
        return toJSONArray(objectList, new String[]{});
    }

    public static <T> JSONArray toJSONArray(List<T> objectList, String... removeKeys){
    	if(removeKeys==null||removeKeys.length==0){
    		return new JSONArray(objectList);
    	}
        JSONArray array = new JSONArray();
        for(Object obj:objectList){
        	array.put(json(obj));
        }
        return array;
    }

    public static <T> JSONObject json(T obj, String... removeKeys) {
        try {
            JSONObject result =  new JSONObject(obj);
            if(removeKeys!=null){
                for(String k:removeKeys){
                    result.remove(k);
                }
            }
            return result;
        } catch (Exception ex) {
            LOGGER.error("Convert TBase object to JSON fails: ",ex);
        }
        return new JSONObject();
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(JSONObject object, String key){
        try {
            return (T)object.get(key);
        } catch (Exception e) {
            LOGGER.warn("", e);
        }
        return null;
    }

    public static void put(JSONObject object, String key, String value){
    	try {
    		object.put(key, value);
    	} catch (Exception e) {
    		LOGGER.warn("", e);
    	}
    }

    public static void put(JSONObject object, String key, Object value){
        try {
            object.put(key, value);
        } catch (Exception e) {
            LOGGER.warn("", e);
        }
    }
}
