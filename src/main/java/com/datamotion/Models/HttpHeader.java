package com.datamotion;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HttpHeader {
	@Getter @Setter
	private String Key;
	
	@Getter @Setter
	private String Value;	
}
