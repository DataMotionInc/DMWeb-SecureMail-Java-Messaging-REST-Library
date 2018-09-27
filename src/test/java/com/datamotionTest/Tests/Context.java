package com.datamotionTest.Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Context {
	private String Username;
	
	private String Password;
	
	public Context() throws IOException {
		File file = new File("userpass.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Username = br.readLine();
		Password = br.readLine();
		br.close();
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
