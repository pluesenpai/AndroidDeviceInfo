package org.slackcnt.android.androiddeviceinfo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView textView = (TextView) findViewById(R.id.info_label);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("Width: ");
		stringBuilder.append(dm.widthPixels);
		stringBuilder.append(" px\n");

		stringBuilder.append("Height: ");
		stringBuilder.append(dm.heightPixels);
		stringBuilder.append(" px\n");

		stringBuilder.append("\n");

		stringBuilder.append("Density: ");
		stringBuilder.append(dm.densityDpi);
		stringBuilder.append(" dpi\n");

		stringBuilder.append("Density: ");
		switch(dm.densityDpi) {
			case DisplayMetrics.DENSITY_LOW:
				stringBuilder.append("ldpi");
				break;
			case DisplayMetrics.DENSITY_MEDIUM:
				stringBuilder.append("mdpi");
				break;
			case DisplayMetrics.DENSITY_HIGH:
				stringBuilder.append("hdpi");
				break;
			case DisplayMetrics.DENSITY_XHIGH:
				stringBuilder.append("xhdpi");
				break;
			case DisplayMetrics.DENSITY_XXHIGH:
				stringBuilder.append("xxhdpi");
				break;
			case DisplayMetrics.DENSITY_TV:
				stringBuilder.append("tvdpi");
				break;
		}
		stringBuilder.append("\n");
		stringBuilder.append("\n");

		stringBuilder.append("Screen: ");
		if((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
			stringBuilder.append("large");
		} else if((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
			stringBuilder.append("normal");
		} else if((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
			stringBuilder.append("small");
		} else if((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
			stringBuilder.append("xlarge");
		} else if((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_UNDEFINED) {
			stringBuilder.append("undefined");
		} else {
			stringBuilder.append("?");
		}
		stringBuilder.append("\n");

		textView.setText(stringBuilder.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
