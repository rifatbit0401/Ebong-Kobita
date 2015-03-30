package com.example.ebongkobita;

import com.example.model.Content;
import com.example.repository.DBHelper;
import com.example.repository.IRepository;

import android.R.bool;
import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {

	private Button peomButton;
	private Button letterButton;
	private Button	photoButton;
	private Button	storyButton;	
	private Button speechButton;
	private Button songButton;
	private Button writeButton;
	private Button myWritingButton;
	private Button linkButton;
	private Button searchButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initialize();
       
        SharedPreferences sharedPreferences = getSharedPreferences("Test Preference", MODE_PRIVATE);
        boolean initialized=sharedPreferences.getBoolean("database initialize", true);
        
        if(!sharedPreferences.contains("db8"))
        {
        	prepeareDatabase();
        	Editor editor = sharedPreferences.edit();
        	editor.putString("db8", "initialzed");
        	editor.commit();
        }
       // sharedPreferences.
        
      /*Intent intent = new Intent(this, PoemListActivity.class);
        startActivity(intent);*/
        
       /* if(initialized)
        {
        	prepeareDatabase();
        }*/
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    private void prepeareDatabase()
    {
    	preparePoemTable();
    	prepareSongTable();
    	prepareLetterTable();
    	prepareSpeechTable();
    	prepareStoryTable();
    	prepareLinkTable();
    }

    private void prepareLinkTable() {
		DBHelper linkDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "link");
    	linkDbHelper.dropTable();
    	linkDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "link");
    	
    	Content content = new Content();
    	content.Name="https://www.google.com.bd/";//getResources().getString(R.string.gan1Name);
    	/*content.Author=getResources().getString(R.string.gan1Author);
    	content.Details=getResources().getString(R.string.gan1);
    	*/
    	
    	Content content1 = new Content();
    	content1.Name="https://www.yahoo.com/";//getResources().getString(R.string.gan1Name);
    	
    	linkDbHelper.insertData(content);
    	linkDbHelper.insertData(content1);
	}
    
    private void prepareSongTable() {
		DBHelper songDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "song");
    	songDbHelper.dropTable();
    	songDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "song");
    	
    	Content content = new Content();
    	content.Name=getResources().getString(R.string.gan1Name);
    	content.Author=getResources().getString(R.string.gan1Author);
    	content.Details=getResources().getString(R.string.gan1);
    	
    	songDbHelper.insertData(content);
	}


	private void preparePoemTable() {
		DBHelper poemDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "poem");
    	poemDbHelper.dropTable();
    	poemDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "poem");
    	
    	Content content = new Content();
    	content.Name=getResources().getString(R.string.kobita1Name);
    	content.Author=getResources().getString(R.string.kobita1Author);
    	content.Details=getResources().getString(R.string.kobita1);
    	
    	poemDbHelper.insertData(content);
	}


	private void prepareLetterTable() {
		DBHelper letterDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "letter");
    	letterDbHelper.dropTable();
    	letterDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "letter");
    	
    	Content letter1 = new Content();
    	letter1.Name=getResources().getString(R.string.cithi1Name);
    	letter1.Author=getResources().getString(R.string.cithi1Writer);
    	letter1.Details=getResources().getString(R.string.chithi1);
    	
    	Content letter2 = new Content();
    	letter2.Name=getResources().getString(R.string.cithi2Name);
    	letter2.Author=getResources().getString(R.string.cithi2Writer);
    	letter2.Details=getResources().getString(R.string.chithi2);
    	
    	letterDbHelper.insertData(letter1);
    	letterDbHelper.insertData(letter2);
	}
	private void prepareSpeechTable() {
		DBHelper speechDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "speech");
    	speechDbHelper.dropTable();
    	speechDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "speech");
    	
    	Content countrySpeech = new Content();
    	countrySpeech.Name="country";
    	countrySpeech.Details=getResources().getString(R.string.bani1);
    	
    	
    	Content languageSpeech = new Content();
    	languageSpeech.Name="language";
    	languageSpeech.Details=getResources().getString(R.string.bani2);
    	
    	
    	Content religionSpeech = new Content();
    	religionSpeech.Name="religion";
    	religionSpeech.Details=getResources().getString(R.string.bani3);
    	
    	Content mindSpeech = new Content();
    	mindSpeech.Name="mind";
    	mindSpeech.Details=getResources().getString(R.string.bani4);
    	
    	
    	speechDbHelper.insertData(countrySpeech);
    	speechDbHelper.insertData(languageSpeech);
    	speechDbHelper.insertData(religionSpeech);
    	speechDbHelper.insertData(mindSpeech);
	}
	
	private void prepareStoryTable() {
		DBHelper storyDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "story");
    	storyDbHelper.dropTable();
    	storyDbHelper = new DBHelper(getApplicationContext(), "", null, 1, "story");
    	
    	Content story1 = new Content();
    	story1.Name=getResources().getString(R.string.golpo1Name);
    	story1.Author=getResources().getString(R.string.golpo1Writer);
    	story1.Details=getResources().getString(R.string.golpo1);
    	
    	Content story2 = new Content();
    	story2.Name=getResources().getString(R.string.golpo2Name);
    	story2.Author=getResources().getString(R.string.golpo2Writer);
    	story2.Details=getResources().getString(R.string.golpo2);
    	
    	storyDbHelper.insertData(story1);
    	storyDbHelper.insertData(story2);
	}
    
    private void prepeareTable(String tableName)
    {
    	DBHelper dbHelper = new DBHelper(this,"",null,1,tableName);
    	try {
			dbHelper.dropTable();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	dbHelper=new DBHelper(this,"",null,1,tableName);
		
		for (int i = 0; i < 10; i++) {
			Content content = new Content();
			content.Author=tableName+" "+getResources().getString(R.string.author);
			content.Name=tableName+" "+getResources().getString(R.string.author);
			content.Details=tableName+" "+getResources().getString(R.string.author);
			dbHelper.insertData(content);
		}
    }
    
    private void initialize()
    {
    	peomButton = (Button) findViewById(R.id.buttonPoem);
    	letterButton = (Button) findViewById(R.id.buttonLetter);
    	photoButton = (Button) findViewById(R.id.buttonPhoto);
    	storyButton = (Button) findViewById(R.id.buttonStory);
    	speechButton = (Button)findViewById(R.id.buttonSpeech);
    	songButton = (Button)findViewById(R.id.buttonSong);
    	myWritingButton=(Button)findViewById(R.id.buttonMyWriting);
    	writeButton = (Button)findViewById(R.id.buttonWrite);
    	linkButton = (Button)findViewById(R.id.buttonLink);
    	searchButton = (Button)findViewById(R.id.buttonSearch);
    	
    	Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");
    	
    	this.peomButton.setTypeface(font);
    	this.letterButton.setTypeface(font);
    	this.photoButton.setTypeface(font);
    	this.storyButton.setTypeface(font);
    	this.speechButton.setTypeface(font);
    	this.songButton.setTypeface(font);
    	this.myWritingButton.setTypeface(font);
    	this.writeButton.setTypeface(font);
    	this.linkButton.setTypeface(font);
    	this.searchButton.setTypeface(font);
    	
    	this.peomButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent = new Intent(getApplicationContext(), PoemListActivity.class);
		       intent.putExtra("CONTENT_TYPE", "poem");	
		       startActivity(intent);
				
			}
		});
    	
    	this.letterButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						PoemListActivity.class);
				intent.putExtra("CONTENT_TYPE", "letter");
				startActivity(intent);
	}
		});
    	
    	this.storyButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						PoemListActivity.class);
				intent.putExtra("CONTENT_TYPE", "story");
				startActivity(intent);

			}
		});
    	this.speechButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						SpeechActivity.class);
				//intent.putExtra("CONTENT_TYPE", "speech");
				startActivity(intent);

			}
		});
    	
    	
    	this.songButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						PoemListActivity.class);
				intent.putExtra("CONTENT_TYPE", "song");
				startActivity(intent);

			}
		});
    	
    	this.myWritingButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						PoemListActivity.class);
				intent.putExtra("CONTENT_TYPE", "myWriting");
				startActivity(intent);

			}
		});

		this.writeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						WritingFormActivity.class);
				//intent.putExtra("CONTENT_TYPE", "speech");
				startActivity(intent);

			}
		});
		
		this.linkButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						LinkActivity.class);
				intent.putExtra("CONTENT_TYPE", "link");
				startActivity(intent);

			}
		});  
		
		this.searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.bd/"));
//				/Log.d("database", "okkkkkkkkk");
				startActivity(intent);
			}
		});
		
		this.photoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
			 startActivity(intent);
			}
		});
    	
    }
    
}
 
