package com.example.ebongkobita;

import java.sql.Types;

import com.example.model.Content;
import com.example.repository.DBHelper;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SpeechDetailActivity extends ActionBarActivity {

	private TextView speechTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech_detail);
		
		DBHelper dbHelper = new DBHelper(this,"",null,1,"speech");
		/*dbHelper.dropTable();
		dbHelper=new DBHelper(this,"",null,1,"speech");
		
		Content content = new Content();
		content.Name=getIntent().getStringExtra("CONTENT_NAME");
		content.Details=getResources().getString(R.string.bani2);
		dbHelper.insertData(content);
		*/
		
		speechTextView = (TextView)findViewById(R.id.textViewSpeech);
		Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");
		speechTextView.setTypeface(font);
		
		speechTextView.setText(Html.fromHtml(dbHelper.getContent(getIntent().getStringExtra("CONTENT_NAME")).Details));
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speech_detail, menu);
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
