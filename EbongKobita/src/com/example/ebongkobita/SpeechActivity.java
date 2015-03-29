package com.example.ebongkobita;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

;

public class SpeechActivity extends ActionBarActivity {

	private Button countryButton;
	private Button languageButton;
	private Button religionButton;
	private Button mindButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech);

		countryButton = (Button) findViewById(R.id.buttonCountry);
		languageButton = (Button) findViewById(R.id.buttonLanguage);
		religionButton = (Button) findViewById(R.id.buttonReligion);
		mindButton = (Button) findViewById(R.id.buttonMind);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"Lohit_14-04-2007.ttf");
		countryButton.setTypeface(font);
		languageButton.setTypeface(font);
		religionButton.setTypeface(font);
		mindButton.setTypeface(font);

		countryButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						SpeechDetailActivity.class);
				intent.putExtra("CONTENT_NAME", "country");

				startActivity(intent);

			}
		});

		languageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						SpeechDetailActivity.class);
				intent.putExtra("CONTENT_NAME", "language");

				startActivity(intent);

			}
		});

		religionButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						SpeechDetailActivity.class);
				intent.putExtra("CONTENT_NAME", "religion");

				startActivity(intent);

			}
		});

		mindButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						SpeechDetailActivity.class);
				intent.putExtra("CONTENT_NAME", "mind");

				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speech, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
