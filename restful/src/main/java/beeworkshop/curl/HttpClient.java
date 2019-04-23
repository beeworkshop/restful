package beeworkshop.curl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	public static String sendPost(String url, String data) {
		String response = null;
		System.out.println("url: " + url);
		System.out.println("request: " + data);
		try {
			CloseableHttpClient httpclient = null;
			CloseableHttpResponse httpresponse = null;
			try {
				httpclient = HttpClients.createDefault();
				HttpPost httppost = new HttpPost(url);
				StringEntity stringentity = new StringEntity(data, ContentType.create("application/json", "UTF-8"));
				httppost.setEntity(stringentity);
				httpresponse = httpclient.execute(httppost);
				response = EntityUtils.toString(httpresponse.getEntity());
				System.out.println("response: " + response);
			} finally {
				if (httpclient != null) {
					httpclient.close();
				}
				if (httpresponse != null) {
					httpresponse.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public static void main(String[] args) {
		// JavaScript Object Notation: application/json
		// Object
		// Content-Type: application/json; charset=UTF-8\r\n
		System.out.println(sendPost("http://www.baidu.com", "{\"address\":\"192.168.12.1/24\"}"));

	}

}
