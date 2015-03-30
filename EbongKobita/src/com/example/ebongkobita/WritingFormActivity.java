package com.example.ebongkobita;

import java.sql.Types;

import org.w3c.dom.Text;

import com.example.model.Content;
import com.example.repository.DBHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class WritingFormActivity extends ActionBarActivity {

	private EditText contentEditText;
	private EditText contentNameEditText;
	private Button saveButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_writing_form);
		
		contentEditText = (EditText)findViewById(R.id.editTextContent);
		contentNameEditText=(EditText)findViewById(R.id.editTextContentName);
		saveButton = (Button)findViewById(R.id.buttonSave);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");
		contentEditText.setTypeface(font);
		contentNameEditText.setTypeface(font);
		saveButton.setTypeface(font);
		
		saveButton.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DBHelper myContentHelper = new DBHelper(getApplicationContext(), "", null, 1, "myWriting");
				Content myContent = new Content();
				myContent.Author="Own";
				myContent.Name=contentNameEditText.getText().toString();
				myContent.Details=contentEditText.getText().toString();
				myContentHelper.insertData(myContent);
				
				Toast.makeText(getApplicationContext(),getResources().getString(R.string.writingSaveConfirmationMsg), Toast.LENGTH_LONG).show();
				/*Toast t=Toast.makeText(getApplicationContext(), getResources().getString(R.string.writingSaveConfirmationMsg), Toast.LENGTH_LONG);
			    
				TextView toastView = new TextView(getApplicationContext());
		    	Typeface font = Typeface.createFromAsset(getAssets(), "Lohit_14-04-2007.ttf");
			    toastView.setTypeface(font);
			    toastView.setText(getResources().getString(R.string.writingSaveConfirmationMsg));
				toastView.setTextColor(Color.WHITE);
				toastView.setBackgroundColor(Color.BLACK);
				toastView.setHeight(20);
				
				t.setView(toastView);
				t.show();*/
				
			    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.writing_form, menu);
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
