package pokemon.api.tool;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static ObjectMapper getMapper() {
		return mapper;
	}
	
	public static String stringify(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static <T> T objectify(String value, Class<T> expectedType) {
        try {
            return mapper.readValue(value, expectedType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
