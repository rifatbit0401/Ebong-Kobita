package com.example.ebongkobita;

import java.util.List;

import com.example.model.Content;
import com.example.repository.DBHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class LinkActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link);
		
		DBHelper dbHelper = new DBHelper(getApplicationContext(), "", null, 1, "link");
		
		/*for(int i=0;i<10;i++)
		{
			Content content = new Content();
			content.Name="link"+i;
			dbHelper.insertData(content);
		}*/
		
		List<Content>contents = dbHelper.getAllContent();
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout1);
		
		for (Content content : contents) {
		
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			layoutParams.setMargins(0, 0, 0, 2);
			
			final Button button = new Button(this);
			button.setLayoutParams(layoutParams);
			button.setText(content.Name);
		    button.setBackgroundColor(Color.parseColor("#00365B"));
		    button.offsetTopAndBottom(20);
		    button.setTextColor(Color.WHITE);
			layout.addView(button);
			
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(button.getText().toString()));
//					/Log.d("database", "okkkkkkkkk");
					startActivity(intent);
				}
			});
			
		}
		
		/*Button button = new Button(this);
		button.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		button.setText("button");
		
		layout.addView(button);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.link, menu);
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
