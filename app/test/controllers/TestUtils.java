package test.controllers;

import scala.util.parsing.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */
public class TestUtils {


	public static String makeRequest(String myUrl,
	                                 String httpMethod, JSONObject parameters) throws IOException {
		URL url = null;
		url = new URL(myUrl);
		HttpURLConnection conn = null;
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		DataOutputStream dos = null;
		conn.setRequestMethod(httpMethod);

		if (Arrays.asList("POST", "PUT").contains(httpMethod)) {
			String params = parameters.toString();
			conn.setDoOutput(true);
			dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes(params);
			dos.flush();
			dos.close();
		}

		int respCode = conn.getResponseCode();
		if (respCode != 200 && respCode != 201) {
			String error = inputStreamToString(conn.getErrorStream());
			return error;
		}
		String inputString = inputStreamToString(conn.getInputStream());

		return inputString;
	}


	public static String inputStreamToString(InputStream is) {
//		BufferedReader br = null;
//		StringBuilder sb = new StringBuilder();
//
//		String line;
//		br = new BufferedReader(new InputStreamReader(is));
//		while ((line = br.readLine()) != null) {
//			sb.append(line);
//		}
//		br.close();
//		return sb.toString();
		return null;
	}

}
