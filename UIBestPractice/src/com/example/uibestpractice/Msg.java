package com.example.uibestpractice;

import javax.security.auth.PrivateCredentialPermission;

import android.R.integer;

public class Msg {

	//常量定义
	public static final int TYPE_RECEIVED = 0;
	public static final int TYPE_SEND = 1;
	
	private String content;
	private int type;
	
	public Msg(String content, int type){
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}
	
	
	
}
