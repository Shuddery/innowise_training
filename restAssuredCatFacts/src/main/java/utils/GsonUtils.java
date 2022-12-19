package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    public static final Gson GSON = new GsonBuilder().create();

    public static <T> T fromJson(String json, Class<T> tClass) {
        return GSON.fromJson(json, tClass);
    }
}