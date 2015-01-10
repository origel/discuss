package org.rigelos.discuss.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResponseResult {
    public static String OK = "OK";
    public static String ERROR = "ERROR";
    
    public static Map<String, String>  messageMap = new ConcurrentHashMap<String, String>();
    static {
    	messageMap.put(OK, "成功");
    	messageMap.put(ERROR, "错误");
    };
}
