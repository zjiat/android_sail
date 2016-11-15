package com.example.filepersistence;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edit;
	private Button saveButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText)findViewById(R.id.editText1);
		saveButton = (Button)findViewById(R.id.button);
		
		saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				save(edit.getText().toString());
			}
		});
	}
	
	private void save(String inputText) {
		FileOutputStream outputStream = null;
		BufferedWriter writer = null;
		
		try {
			outputStream = openFileOutput("my_data_file", Context.MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			writer.write(inputText);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

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
}
