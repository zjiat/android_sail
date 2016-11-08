package com.example.uiwidgettest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button button, probutton, alertDlogButton, proDlogButton;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button);
		editText = (EditText) findViewById(R.id.edit_text);
		imageView = (ImageView) findViewById(R.id.image_view);
		progressBar = (ProgressBar) findViewById(R.id.rogress_bar);
		probutton = (Button) findViewById(R.id.proButton);
		alertDlogButton = (Button)findViewById(R.id.alertDialogButton);
		proDlogButton = (Button)findViewById(R.id.proDialogButton);

		button.setOnClickListener(this);
		probutton.setOnClickListener(this);
		alertDlogButton.setOnClickListener(this);
		proDlogButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button:
			// String inputText = editText.getText().toString();
			// Toast.makeText(MainActivity.this, inputText,
			// Toast.LENGTH_SHORT).show();
			// imageView.setImageResource(R.drawable.jelly_bean);
			if (progressBar.getVisibility() == View.GONE) {
				progressBar.setVisibility(View.VISIBLE);
			} else {
				progressBar.setVisibility(View.GONE);
			}
			break;
		case R.id.proButton:
			int progress = progressBar.getProgress();
			progress = progress + 10;
			progressBar.setProgress(progress);
			break;
			
		case R.id.alertDialogButton:
			AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
			dialogBuilder.setTitle("This is Dialog");
			dialogBuilder.setMessage("Something important.");
			dialogBuilder.setCancelable(false);
			dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {  }
			}); 
			dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {	}
			});
			dialogBuilder.show();
			break;
			
		case R.id.proDialogButton:
			ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setTitle("This is ProgressDialog");
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(true);
			progressDialog.show();
			break;
		default:
			break;
		}
	}

}
