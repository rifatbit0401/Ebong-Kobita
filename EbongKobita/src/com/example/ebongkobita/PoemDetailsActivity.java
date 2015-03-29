package com.example.ebongkobita;

import com.example.model.Content;
import com.example.repository.DBHelper;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PoemDetailsActivity extends ActionBarActivity {

	/*private TextView contentNameView;
	private TextView contentWriterView;
	*/private TextView contentDetailsView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poem_details);
		
	/*	contentNameView=(TextView)findViewById(R.id.contentName);
		contentWriterView=(TextView)findViewById(R.id.contentWriter);
	*/	contentDetailsView=(TextView)findViewById(R.id.contentDetails);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");
		
	/*	contentNameView.setTypeface(font);
		contentWriterView.setTypeface(font);
	*/	contentDetailsView.setTypeface(font);
		
		int id=Integer.parseInt(getIntent().getStringExtra("id"));
		DBHelper bookDbHelper = new DBHelper(this, "", null, 1, getIntent().getStringExtra("TABLE_NAME"));
		Content content = bookDbHelper.getContent(id);
		
	/*	contentNameView.setText(content.Name);
		contentWriterView.setText(content.Author);
	*/	contentDetailsView.setText(Html.fromHtml(content.Details));
		
		//textView.setText(bookDbHelper.getContent(id).Author);
		//textView.setText("HHHHHHHHHHHH");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poem_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
