package com.skcc.stock.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.fasterxml.jackson.databind.JsonNode;
import com.skcc.stock.option.Stock;
import com.skcc.stock.option.Url;

public class ConnectionUtils {
	
	private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
	
	public static void ignoreSSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
		SSLContext.setDefault(ctx);
	}

	public static HttpsURLConnection openConnection(String stockNumber) throws IOException {
		URL url = new URL(Url.stockBaseUrl + stockNumber);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});
		return conn;
	}
	
	public static JsonNode getResponse(String stockNumber) throws IOException {
		HttpsURLConnection conn = ConnectionUtils.openConnection(stockNumber);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
        String inputLine ;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        conn.disconnect();
        
		return Stock.mapper.readValue(response.toString(), JsonNode.class).get("result").get("d").get(0);
	}
	
}