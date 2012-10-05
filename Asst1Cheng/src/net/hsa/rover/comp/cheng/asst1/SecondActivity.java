package net.hsa.rover.comp.cheng.asst1;

import android.os.Bundle;
import android.R.color;
import android.R.id;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_second);
		final EditText display2 = (EditText) findViewById(R.id.editTextnew);
		display2.append("The result is " + Integer.toString(MainActivity.sum)
				+ ".");

		final Button returnbutton = (Button) findViewById(R.id.buttonreturn);
		returnbutton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent inte = new Intent(SecondActivity.this,
						MainActivity.class);
				startActivity(inte);
			}
		});

	}

}
