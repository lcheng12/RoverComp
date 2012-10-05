package net.hsa.rover.comp.cheng.asst2;


import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<User> {

	ArrayList<User> users;

	public UserAdapter(Activity activity, ArrayList<User> users) {
		super(activity, R.layout.row_user, R.id.name, users);
		this.users = users;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		
		((TextView) view.findViewById(R.id.name)).setText(users
				.get(position).getName());
		((TextView) view.findViewById(R.id.description)).setText(users.get(position)
				.getDescription());
		((TextView) view.findViewById(R.id.description)).setTextSize(15);

		return view;
	}

}
