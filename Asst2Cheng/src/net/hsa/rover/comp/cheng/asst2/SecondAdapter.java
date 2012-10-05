package net.hsa.rover.comp.cheng.asst2;


import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SecondAdapter extends ArrayAdapter<Tweet> {

	ArrayList<Tweet> tweets;

	public SecondAdapter(Activity activity, ArrayList<Tweet> tweets) {
		super(activity, R.layout.row_tweet, R.id.tweet, tweets);
		this.tweets = tweets;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		
		((TextView) view.findViewById(R.id.tweet)).setText(tweets
				.get(position).getText());
		return view;
	}

}
