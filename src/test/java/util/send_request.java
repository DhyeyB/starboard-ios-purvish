package util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import general.Login_Magic_link;
import io.qameta.allure.Allure;

public class send_request extends Login_Magic_link {
	String magic_link = "";

	public String sendRequest() {
		try {
			generate_header obj = new generate_header();
			String email_token = obj.run();
			@SuppressWarnings("deprecation")
			URL url = new URL(
					"https://starboard-api.dev.starboardcard.dexteraparte.com/api/v1/user/automation-login-link");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("x-automation-key", email_token);
			System.out.println(email_token);

			String payload = "{\n" + "    \"email\":\"" + obj.getEmail() + "\",\n" + "    \"user_agent\":\"Appium\"\n"
					+ "}";

			// System.out.println(payload);
			JSONObject cred = new JSONObject(payload);
			// System.out.println(cred);
			byte[] out = payload.getBytes(StandardCharsets.UTF_8);

			OutputStream stream = connection.getOutputStream();
			stream.write(out);

			if (connection.getResponseCode() == 200) {
				System.out.println(connection.getResponseMessage().toString());
				BufferedReader br = null;

				br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String strCurrentLine;
				StringBuilder res = new StringBuilder();

				while ((strCurrentLine = br.readLine()) != null) {
					res.append(strCurrentLine);

					System.out.println(strCurrentLine);
				}
				try {
					JSONObject data = new JSONObject(res.toString());

					Iterator<String> iteratorLooop = data.keys();
					while (iteratorLooop.hasNext()) {
						String key = iteratorLooop.next();
						System.out.println(key);

						if (key.equalsIgnoreCase("data")) {
							JSONObject innerObj = data.getJSONObject("data");
							System.out.println("Link -> " + innerObj);
							String jsonString = innerObj.toString();
							System.out.println("String -> " + jsonString);

							Iterator<String> iteratorInsideLoop = innerObj.keys();
							while (iteratorInsideLoop.hasNext()) {
								String keyInside = innerObj.getString("login_link");

								magic_link = keyInside;

								if (magic_link != "") {
									break;
								}
							}

							if (magic_link != "") {
								break;
							}
						}

					}

					System.out.println("Link -> " + magic_link);

					//System.out.println(" clicked on magic link");

				} catch (Exception e) {
					System.out.println("Error in getting link");
					String pageSource = driver.getPageSource();
					System.out.println(pageSource);
					Allure.addAttachment("AllureSelenide",
							new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

				}
			} else

			{
				System.out.println("********************" + "Failed API" + "********************");
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getResponseCode() / 100 == 2 ? connection.getInputStream() : connection.getErrorStream()));
				System.out.println(reader);
				System.out.println(reader.readLine());
				System.out.println(connection.getResponseCode() + " else " + connection.getResponseMessage());
			}

			connection.disconnect();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("********************" + "Failed successfully" + "********************");
		}
		return magic_link;
	}

}
