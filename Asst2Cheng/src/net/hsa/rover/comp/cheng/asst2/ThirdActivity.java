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
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ThirdActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d("testing", "sdg");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		Bundle extras = getIntent().getExtras();
	    String SubPos = extras.getString("text");
	    final int position = extras.getInt("id");
		final TextView display = (TextView) findViewById(R.id.textView1);
		display.setTextSize(20);
		display.setText(SubPos);
		
		final Button returnbutton = (Button) findViewById(R.id.buttonreturn2);
		returnbutton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent inte = new Intent(ThirdActivity.this,
						SecondActivity.class);
				inte.putExtra("id", position);
				startActivity(inte);
			}
		});
		
	}

}
