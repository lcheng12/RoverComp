package net.hsa.rover.comp.cheng.asst2;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class JsonParser {

	public static ArrayList<User> parseUser(Context context, int jsonFile) {

		// return value
		ArrayList<User> users = new ArrayList<User>();

		// access json file in resources
		InputStream is = context.getResources().openRawResource(jsonFile);
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];

		try {
			// get json from raw resources
			Reader reader = new BufferedReader(new InputStreamReader(is,
					"UTF-16"));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}

			// concert json to string for parsing
			String jString = writer.toString();

			JSONObject jObject = new JSONObject(jString);

			JSONArray usersArray = jObject.getJSONArray("Users");

			users = new ArrayList<User>();

			for (int i = 0; i < usersArray.length(); i++) {
		
				String name = usersArray.getJSONObject(i).getString("name");
				String description = usersArray.getJSONObject(i).getString("description");
				String url = usersArray.getJSONObject(i).getString("url");

				Log.d("parser", name);
				
				users.add(new User(name,description,url));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return users;
	}
	
	
	public static ArrayList<Tweet> parseTweet(Context context, String url) {

		// return value
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		String urlString = null;
		try {
			urlString = readUrl(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(urlString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			      for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject jsonObject = jsonArray.getJSONObject(i);
			        Tweet tempTweet = new Tweet(jsonObject.getString("text"));
			        tweets.add(tempTweet);
			      }
			      } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tweets;
	}
	private static String readUrl(String urlString) throws Exception {
		URL twitter = new URL(urlString);
		BufferedReader in = new BufferedReader(
        new InputStreamReader(twitter.openStream()));
        String readIn = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {	
            readIn = readIn + inputLine;
        }    
        in.close();
        return readIn;


	}


}
