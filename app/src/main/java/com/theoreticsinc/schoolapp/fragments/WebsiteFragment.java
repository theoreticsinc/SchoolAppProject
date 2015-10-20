package com.theoreticsinc.schoolapp.fragments;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.theoreticsinc.schoolapp.R;

@TargetApi(11)
public class WebsiteFragment extends Fragment {

	private LayoutInflater inflater;

	public WebsiteFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = null;

		rootView = inflater.inflate(R.layout.websitelink, container,
				false);

		ImageButton menuButton = (ImageButton) rootView.findViewById(R.id.menuButton2);
		menuButton.setVisibility(View.GONE);
		ImageView headerLogo = (ImageView) rootView.findViewById(R.id.headerLogo);
		headerLogo.setVisibility(View.GONE);

		WebView webView = (WebView) rootView.findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://andreans.edu.ph/");

		return rootView;
	}
}
