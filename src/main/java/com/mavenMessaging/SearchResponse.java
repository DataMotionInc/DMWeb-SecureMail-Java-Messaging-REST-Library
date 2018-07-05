package com.mavenMessaging;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
	@JsonProperty("PageDetails") @Getter @Setter
	private PageDetails details;
	
	@JsonProperty("Results")@Getter @Setter
	private ArrayList<Results> results;
}
