package net.hsa.rover.comp.cheng.asst2;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import net.hsa.rover.comp.cheng.asst2.R;
import net.hsa.rover.comp.cheng.asst2.SecondActivity;
import net.hsa.rover.comp.cheng.asst2.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity {

	private ArrayList<Tweet> tweets;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
	    final int SubPos = extras.getInt("id");
	    Log.d("testing", Integer.toString(SubPos));
	    setContentView(R.layout.activity_second);
		tweets = JsonParser.parseTweet(this, MainActivity.users.get(SubPos).getUrl());
		ListView listView = (ListView) findViewById(R.id.listView2);
		TweetAdapter tweetAdapter = new TweetAdapter(this, tweets);
		listView.setAdapter(tweetAdapter);

		final Button returnbutton = (Button) findViewById(R.id.buttonreturn);
		returnbutton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent inte = new Intent(SecondActivity.this,
						MainActivity.class);
				startActivity(inte);
			}
		});
		
		TextView display = (TextView)findViewById(R.id.textView2);
		display.setTextSize(20);
		display.setText(MainActivity.users.get(SubPos).getName());
		AdapterView view = (AdapterView)findViewById(R.id.listView2);
		Log.d("testing","beforeclick");
		view.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent inte2 = new Intent(SecondActivity.this,
						ThirdActivity.class);
				inte2.putExtra("text",tweets.get(position).getText());
				inte2.putExtra("id",SubPos);
				Log.d("testing", "sdg"+Integer.toString(position));
				startActivity(inte2);
			}
		});

		
	}

}
