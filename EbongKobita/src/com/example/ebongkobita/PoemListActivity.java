package com.example.ebongkobita;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.example.model.Content;
import com.example.repository.DBHelper;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

public class PoemListActivity extends ActionBarActivity {

	ListView listView;
	List<Content>poems;
	private TextView contentTypeName;
	private TextView contentTypeWriter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poem_list);
		
		
		
		contentTypeName = (TextView) findViewById(R.id.contentTypeName);
		contentTypeWriter = (TextView) findViewById(R.id.contentTypeWriter);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");
		
		contentTypeName.setTypeface(font);
		contentTypeWriter.setTypeface(font);
		
		
		DBHelper poemDbHelper = new DBHelper(this, "", null, 1, "poem");
		
		String contentType=getIntent().getStringExtra("CONTENT_TYPE");
		
		if(contentType.equals("poem")){
			poemDbHelper=new DBHelper(this,"",null,1,"poem");
			contentTypeName.setText(getResources().getString(R.string.poem));
		}
		else if(contentType.equals("letter")){
			poemDbHelper=new DBHelper(this,"",null,1,"letter");
			contentTypeName.setText(getResources().getString(R.string.letter));
		}
		else if(contentType.equals("story")){
			poemDbHelper=new DBHelper(this,"",null,1,"story");
			contentTypeName.setText(getResources().getString(R.string.story));
		}
		else if(contentType.equals("speech")){
			poemDbHelper=new DBHelper(this,"",null,1,"speech");
		//	contentTypeName.setText(getResources().getString(R.string.speech));
		//	Intent intent = new Intent(getApplicationContext(),SpeechActivity.class);
		//	startActivity(intent);
		}
		else if(contentType.equals("song")){
			poemDbHelper=new DBHelper(this,"",null,1,"song");
			contentTypeName.setText(getResources().getString(R.string.song));
		}
		else if(contentType.equals("myWriting")){
			poemDbHelper=new DBHelper(this,"",null,1,"myWriting");
			contentTypeName.setText(getResources().getString(R.string.myWriting));
		}
		
		for (int i = 0; i < 10; i++) {
			Content poem = new Content();
			poem.Author=getResources().getString(R.string.author)+Integer.toString(i);
			poem.Details=getResources().getString(R.string.author)+Integer.toString(i);
			poem.Name=getResources().getString(R.string.author)+Integer.toString(i);
			
		//	poemDbHelper.insertData(poem);	
		}
		
		
		poems = poemDbHelper.getAllContent();
		TextView textView = (TextView) findViewById(R.id.textView1);
		
		//textView.setText((CharSequence) poemDbHelper.getContent(1).Author);
	
		listView = (ListView) findViewById(R.id.listView1);
		initialize();
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), PoemDetailsActivity.class);
				intent.putExtra("id", Integer.toString(poems.get(position).id));
				intent.putExtra("TABLE_NAME", getIntent().getStringExtra("CONTENT_TYPE"));
				startActivity(intent);
			}
		});
	
	}
	
	public void initialize()
	{
		ListAdapter adapter = new BaseAdapter() {
			
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			@Override
			public View getView(int position, View view, ViewGroup parent) {
				// TODO Auto-generated method stub
				if(view==null)
				{
					view = inflater.inflate(R.layout.poem, null);
				}
				TextView textView1 = (TextView) view.findViewById(R.id.textView1);
				TextView textView2 = (TextView) view.findViewById(R.id.textView2);
				textView1.setText(poems.get(position).Name);
				textView2.setText(poems.get(position).Author);
			    
				Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");  
		        textView1.setTypeface(font);
		        textView2.setTypeface(font);
				
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return poems.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return poems.size();
			}
		};
		
		listView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poem, menu);
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
