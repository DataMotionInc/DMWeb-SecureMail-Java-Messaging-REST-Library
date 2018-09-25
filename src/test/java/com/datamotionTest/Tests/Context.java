package com.datamotionTest.Tests;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Context {
	@Getter @Setter
	private String Username;
	
	@Getter @Setter
	private String Password;
	
	public Context() throws IOException {
		File file = new File("userpass.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Username = br.readLine();
		Password = br.readLine();
		br.close();
	}
}
