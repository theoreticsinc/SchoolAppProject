package com.theoreticsinc.myschoolbuddyapp.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.theoreticsinc.myschoolbuddyapp.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name= extras.getString("NAME");
            String details= extras.getString("DETAILS");
            if (name!= null) {
                TextView title = (TextView) findViewById(R.id.titleText);
                title.setText(name);
            }
            if (details!= null) {
                TextView detailstv = (TextView) findViewById(R.id.detailsText);
                detailstv.setText(details);
            }
            if(getIntent().hasExtra("byteArray")) {
                ImageView previewThumbnail = (ImageView) findViewById(R.id.detailsImage);
                Bitmap b = BitmapFactory.decodeByteArray(
                        getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
                previewThumbnail.setImageBitmap(b);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
