package com.theoreticsinc.schoolapp;

/**
 * Created by Angelo on 9/27/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import utils.LazyAdapter;

public class ListActivity extends Activity {

    ListView list;
    LazyAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> mStrings = new ArrayList<String>();
        mStrings.add("https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png");
        mStrings.add("https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg");
        mStrings.add("https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg");
        mStrings.add("https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png");
        mStrings.add("https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png");
        mStrings.add("https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg");
        mStrings.add("https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png");
        mStrings.add("https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg");
        setContentView(R.layout.main);

        list=(ListView)findViewById(R.id.list);
        adapter=new LazyAdapter(this, mStrings);
        list.setAdapter(adapter);

        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(listener);
    }

    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }

    public OnClickListener listener=new OnClickListener(){
        @Override
        public void onClick(View arg0) {
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
            finish();
        }
    };

    private List<String> mStrings;

    @Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("returnKey1", "Swinging on a star. ");
        data.putExtra("returnKey2", "You could be better then you are. ");
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }

}