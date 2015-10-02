package com.theoreticsinc.schoolapp.fragments;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.theoreticsinc.schoolapp.R;
import com.theoreticsinc.schoolapp.utils.LazyAdapter;

import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class AlertsListFragment extends Fragment {

	ListView list;
	LazyAdapter adapter;

	private LayoutInflater inflater;

	public AlertsListFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		int i = getArguments().getInt("SettingsItem");
		Log.d("LEAGUE CHAT", "SettingsItem:" + i);
		View rootView = null;

		rootView = inflater.inflate(R.layout.main, container,
				false);
		getActivity().setTitle("Settings");

		List<String> mStrings = new ArrayList<String>();
		mStrings.add("https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png");
		mStrings.add("https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg");
		mStrings.add("https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg");
		mStrings.add("https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png");
		mStrings.add("https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png");
		mStrings.add("https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg");
		mStrings.add("https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png");
		mStrings.add("https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg");

		list=(ListView)rootView.findViewById(R.id.list);
		adapter=new LazyAdapter(getActivity(), mStrings);
		list.setAdapter(adapter);

		Button b=(Button)rootView.findViewById(R.id.button1);
		b.setOnClickListener(buttonListener);

		return rootView;
	}

	public View.OnClickListener buttonListener=new View.OnClickListener(){
		@Override
		public void onClick(View arg0) {
			adapter.imageLoader.clearCache();
			adapter.notifyDataSetChanged();
			//finish();
		}
	};
}
