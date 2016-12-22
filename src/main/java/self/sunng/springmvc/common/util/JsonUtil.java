package self.sunng.springmvc.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonUtil {
  private final static ObjectMapper objectMapper = new ObjectMapper();

  private JsonUtil() {
  }

  public static Map<String, ?> json2Map(String json) {
    return fromJson(json, Map.class);
  }

  public static List json2List(String json) {
    return fromJson(json, List.class);
  }

  public static <T> T fromJson(String json, Class<T> clazz) {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String obj2Json(Object obj) {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
