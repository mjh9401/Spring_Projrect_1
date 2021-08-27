package com.mjh.exam.projoect1.vo;

public class Ut {
	
	public static String f(String format, Object...args) {
		
		return String.format(format, args);
	}
	
	public static String jsReplace(String msg, String uri) {
		if(msg == null) {
			msg = "";
		}
		
		if(uri == null) {
			uri = "";
		}
		
		String script = "<script>"
						+ "const msg = '%s'.trim();"
						+ "if(msg.length > 0){alert(msg);}"
						+ "location.replace('%s');"
						+ "</script>";
		
		return Ut.f(script, msg,uri);
	}

	public static String jsHistoryBack(String msg) {
		if(msg == null) {
			msg = "";
		}
		
		String script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "history.back();"
				+ "</script>";
		
		return Ut.f(script, msg);
	}

	

}
