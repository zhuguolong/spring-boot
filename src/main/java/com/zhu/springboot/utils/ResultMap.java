package com.zhu.springboot.utils;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 返回json
 */
public class ResultMap {

    public static Map<String, Object> ok(@NotNull String msg) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constss.RESP_CODE, CommonCode.SUCCESS);
        map.put(Constss.RESP_MESSAGE, msg);
        map.put(Constss.RESULT, null);
        return map;
    }

    public static Map<String, Object> ok(@NotNull Object result, @NotNull String msg) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constss.RESP_CODE, CommonCode.SUCCESS);
        map.put(Constss.RESP_MESSAGE, msg);
        map.put(Constss.RESULT, result);
        return map;
    }

    public static Map<String, Object> err(@NotNull String msg) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constss.RESP_CODE, CommonCode.ERROR_GLOBAL);
        map.put(Constss.RESP_MESSAGE, msg);
        map.put(Constss.RESULT, null);
        return map;
    }

    public static Map<String, Object> err(@NotNull String code, @NotNull String msg) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constss.RESP_CODE, code);
        map.put(Constss.RESP_MESSAGE, msg);
        map.put(Constss.RESULT, null);
        return map;
    }
}
