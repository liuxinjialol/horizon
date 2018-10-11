package com.chapter07;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {
	
	private static ObjectMapper objectMapper;
	
	static {
		objectMapper=new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	public static String json(Object obj) throws JsonProcessingException {
		return objectMapper.writeValueAsString(obj);
	}

}
