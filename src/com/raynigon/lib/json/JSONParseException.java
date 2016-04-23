package com.raynigon.lib.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.json.JSONArray;
import org.json.JSONObject;

import com.raynigon.lib.annotations.Future;

@Future(Version="0.0.5")
public class JSONParseException extends RuntimeException {

	private static final long serialVersionUID = 8194053954178861484L;

	public JSONParseException(Field f, Exception e){}
	public JSONParseException(Method m, Exception e){}
	public JSONParseException(JSONObject jobj, Exception e){}
	public JSONParseException(JSONArray jarr, Exception e){}
	
	public JSONParseException(String msg,Exception e) {super(msg, e);}
	
}
