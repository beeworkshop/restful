package beeworkshop.curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InvokeCurl {

	private static String[] cmds = { "src/main/resources/curl/curl", "-H", "\"Content-Type:application/json\"", "-X",
			"POST", "-d", "{\"address\":\"192.168.12.1/24\"}", "http://www.baidu.com" };

	public static String execCurl() {
		ProcessBuilder process = new ProcessBuilder(cmds);
		Process p;
		try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			return builder.toString();

		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// Line-based text data: application/json
		System.out.println(execCurl());
	}

}
