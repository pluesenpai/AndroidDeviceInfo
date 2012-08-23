package org.slackcnt.android.androiddeviceinfo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView textView = (TextView) findViewById(R.id.info_label);

		DisplayMetrics dm = getDisplayMetrics();

		StringBuilder stringBuilder = new StringBuilder();
		printResolution(stringBuilder, dm);
		printScreenDensity(stringBuilder, dm);
		printScreenSize(stringBuilder);

		stringBuilder.append("\n");

		printSystemInfo(stringBuilder);

		stringBuilder.append("\n");

		printDeviceInfo(stringBuilder);

		textView.setText(stringBuilder.toString());
	}

	private DisplayMetrics getDisplayMetrics()
	{
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm;
	}

	private void printResolution(StringBuilder stringBuilder, DisplayMetrics dm)
	{
		stringBuilder.append("Resolution: ");
		stringBuilder.append(dm.widthPixels);
		stringBuilder.append(" x ");

		stringBuilder.append(dm.heightPixels);
		stringBuilder.append(" px\n");
	}

	private void printScreenDensity(StringBuilder stringBuilder,
			DisplayMetrics dm)
	{
		stringBuilder.append("Density: ");
		stringBuilder.append(dm.densityDpi);
		stringBuilder.append(" dpi");

		stringBuilder.append(" (");
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
		stringBuilder.append(")\n");
	}

	private void printScreenSize(StringBuilder stringBuilder)
	{
		stringBuilder.append("Screen size: ");
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
	}

	private void printSystemInfo(StringBuilder stringBuilder)
	{
		stringBuilder
				.append("Android version: " + Build.VERSION.RELEASE + "\n");
		stringBuilder.append("SDK: " + Build.VERSION.SDK);
		stringBuilder.append("\n");
	}

	private void printDeviceInfo(StringBuilder stringBuilder)
	{
		stringBuilder.append("Board: " + Build.BOARD + "\n");
		stringBuilder.append("Brand: " + Build.BRAND + "\n");
		stringBuilder.append("Device: " + Build.DEVICE);
		stringBuilder.append("\n");
	}
}
