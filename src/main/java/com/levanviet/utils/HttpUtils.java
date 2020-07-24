package com.levanviet.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	private String value;

	public HttpUtils(String value) {
		this.value = value;
	}

	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return null;
	}
	public static HttpUtils of(BufferedReader bf) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = bf.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HttpUtils(sb.toString());
	}
}