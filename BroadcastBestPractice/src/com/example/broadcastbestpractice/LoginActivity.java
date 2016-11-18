package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	private EditText accountEdit;
	private EditText passwordEdit;
	private Button login;

	private CheckBox remmemberPass;

	private SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		pref = PreferenceManager.getDefaultSharedPreferences(this);

		accountEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);

		remmemberPass = (CheckBox) findViewById(R.id.remember_pass);

		boolean isRemember = pref.getBoolean("remember_password", false);
		if (isRemember) {
			String accountString = pref.getString("account", "");
			String password = pref.getString("password", "");
			accountEdit.setText(accountString);
			passwordEdit.setText(password);
			remmemberPass.setChecked(true);
		}
		
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String account = accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();

				if (account.equals("admin") && password.equals("123456")) {

					SharedPreferences.Editor editor = pref.edit();
					if (remmemberPass.isChecked()) {
						editor.putBoolean("remember_password", true);
						editor.putString("account", account);
						editor.putString("password", password);
					}else {
						editor.clear();
					}
					editor.commit();
					Intent intent = new Intent(LoginActivity.this,	MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(LoginActivity.this,
							"account or password is invalid",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	void saveloginstate() {
	}
}
