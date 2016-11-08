package com.example.uibestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView msgListView;
	private EditText inputText;
	private Button send;
	private MsgAdapter adapter;
	private List<Msg> msgList = new ArrayList<Msg>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initMsgs();
		//设置Listview数据结构
		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		
		inputText = (EditText)findViewById(R.id.input_text);
		send = (Button)findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if (!"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SEND);
					msgList.add(msg);
					//当队列有新的内容，刷新ListView中的显示
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputText.setText("");
				}			
			}
		});
	}
	private void initMsgs(){
		Msg msg1 = new Msg("Hello guy", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello, Who's that?", Msg.TYPE_SEND);
		msgList.add(msg2);
		Msg msg3 = new Msg("This is Tom. Nice to talk to you.", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
	}
}
