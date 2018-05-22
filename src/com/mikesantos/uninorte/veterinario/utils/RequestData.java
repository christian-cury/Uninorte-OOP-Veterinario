package com.mikesantos.uninorte.veterinario.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class RequestData {

	//private final String USER_AGENT = "Mozilla/5.0";
	private final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36";
	private WeakHashMap<String, String> PARAMS = new WeakHashMap<>();
	private WeakHashMap<String, String> PROPERTIES = new WeakHashMap<>();
	private String REQUEST_URL = null;
	private String USERNAME = null;
	private String PASSWORD = null;
	
	public RequestData(String url) {
		this.REQUEST_URL = url;
	}
	
	public RequestData() {
		super();
	}
	
	public RequestData setUrl(String url) {
		this.REQUEST_URL = url;
		return this;
	}
	
	public RequestData addParam(String key, String value) {
		PARAMS.put(key, value);
		return this;
	}
	
	public RequestData addProperty(String key, String value) {
		PROPERTIES.put(key, value);
		return this;
	}
	
	public RequestData setAuthentication(String username, String password) {
		this.USERNAME = username;
		this.PASSWORD = password;
		return this;
	}
	
	private String getParams() {
		StringBuilder builder = new StringBuilder("");
		for(Entry<String, String> entry : PARAMS.entrySet()) {
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(entry.getValue());
			builder.append("&");
		}
		String response = builder.toString();
		return (!response.isEmpty() ? response.substring(0, response.length() - 1) : response);
	}
	
	public String post() {
		try {
			URL url = new URL(this.REQUEST_URL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", this.USER_AGENT);
			for(Entry<String, String> entry : this.PROPERTIES.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
			
			if(null != this.USERNAME && null != this.PASSWORD) {
				String basicAuth = Base64.getEncoder().encodeToString((this.USERNAME+":"+this.PASSWORD).getBytes(StandardCharsets.UTF_8));
				conn.setRequestProperty("Authorization", basicAuth);
			}
			
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			os.write(getParams().getBytes());
			os.flush();
			os.close();
			
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer buffer = new StringBuffer();
				
				while((inputLine = in.readLine()) != null) {
					buffer.append(inputLine);
				}
				in.close();
				return buffer.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String get() {
		try {
			StringBuilder urlBuilder = new StringBuilder(this.REQUEST_URL);
			String params = getParams();
			if(!params.isEmpty()) {
				urlBuilder.append("?");
				urlBuilder.append(params);
			}
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", this.USER_AGENT);
			for(Entry<String, String> entry : this.PROPERTIES.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
			if(null != this.USERNAME && null != this.PASSWORD) {
				String basicAuth = Base64.getEncoder().encodeToString((this.USERNAME+":"+this.PASSWORD).getBytes(StandardCharsets.UTF_8));
				conn.setRequestProperty("Authorization", basicAuth);
			}
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer buffer = new StringBuffer();
				while((inputLine = in.readLine()) != null) {
					buffer.append(inputLine);
				}
				in.close();
				return buffer.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
