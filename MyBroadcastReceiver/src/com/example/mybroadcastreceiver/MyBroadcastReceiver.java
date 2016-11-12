package com.example.mybroadcastreceiver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("RE", "Received broadcast!");
		Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
		abortBroadcast();

	}

}
