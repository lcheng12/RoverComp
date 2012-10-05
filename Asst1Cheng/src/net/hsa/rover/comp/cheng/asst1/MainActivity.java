package net.hsa.rover.comp.cheng.asst1;

import android.os.Bundle;
import android.R.color;
import android.R.id;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static int temp;
	public static int sum;
	Intent inte;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		temp = 0;
		sum = 0;
		final Button btns[] = new Button[12];
		btns[0] = (Button) findViewById(R.id.button0);
		btns[1] = (Button) findViewById(R.id.button1);
		btns[2] = (Button) findViewById(R.id.button2);
		btns[3] = (Button) findViewById(R.id.button3);
		btns[4] = (Button) findViewById(R.id.button4);
		btns[5] = (Button) findViewById(R.id.button5);
		btns[6] = (Button) findViewById(R.id.button6);
		btns[7] = (Button) findViewById(R.id.button7);
		btns[8] = (Button) findViewById(R.id.button8);
		btns[9] = (Button) findViewById(R.id.button9);
		btns[10] = (Button) findViewById(R.id.buttonplus);
		btns[11] = (Button) findViewById(R.id.buttonenter);

		final EditText display = (EditText) findViewById(R.id.editText1);

		btns[0].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("0");
				temp = temp * 10 + 0;
			}
		});

		btns[1].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("1");
				temp = temp * 10 + 1;
			}
		});

		btns[2].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("2");
				temp = temp * 10 + 2;
			}
		});

		btns[3].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("3");
				temp = temp * 10 + 3;
			}
		});
		btns[4].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("4");
				temp = temp * 10 + 4;
			}
		});
		btns[5].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("5");
				temp = temp * 10 + 5;
			}
		});
		btns[6].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("6");
				temp = temp * 10 + 6;
			}
		});
		btns[7].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("7");
				temp = temp * 10 + 7;
			}
		});
		btns[8].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("8");
				temp = temp * 10 + 8;
			}
		});
		btns[9].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("9");
				temp = temp * 10 + 9;
			}
		});
		btns[10].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				display.append("+");
				sum = sum + temp;
				temp = 0;
			}
		});
		btns[11].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sum = sum + temp;
				Intent inte = new Intent(MainActivity.this,
						SecondActivity.class);
				startActivity(inte);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
