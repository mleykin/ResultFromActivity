package com.niit.android;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultFromActivity extends Activity implements View.OnClickListener {
	TextView tvName;
	Button btnName;

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        tvName = (TextView) findViewById(R.id.tvName);
	        btnName = (Button) findViewById(R.id.btnName);
	        btnName.setOnClickListener(this);

	    }

	  public void onClick(View v) {
	    Intent intent = new Intent(this, NameActivity.class);
	    startActivityForResult(intent, 1);
	  }

	  public void onConfigurationChanged(Configuration newConfig){
		  Configuration config = new Configuration();
	    	if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	    		config.orientation = Configuration.ORIENTATION_PORTRAIT;
				Toast.makeText(getApplicationContext(), "Rotated22!!", Toast.LENGTH_LONG).show();
			}
		  super.onConfigurationChanged(config);

	  }

	  @Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if (data == null) {return;}
	    String name = data.getStringExtra("name").toString();
	    tvName.setText(getApplicationContext().getString(R.string.propmt) + name);
	  }
}