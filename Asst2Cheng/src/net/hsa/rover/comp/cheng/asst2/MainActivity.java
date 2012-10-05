package net.hsa.rover.comp.cheng.asst2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import android.Manifest.permission;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.hsa.rover.comp.cheng.asst2.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	public static ArrayList<User> users;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get users
		
		users = JsonParser.parseUser(this, R.raw.a);

		// set up list view
		ListView listView = (ListView) findViewById(R.id.listView1);
		UserAdapter userAdapter = new UserAdapter(this, users);
		listView.setAdapter(userAdapter);
		AdapterView view = (AdapterView)findViewById(R.id.listView1);
		view.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d("test", Integer.toString(position));
				Intent inte = new Intent(MainActivity.this,
						SecondActivity.class);
				inte.putExtra("id",position);
				startActivity(inte);
			}
		});
	}


}