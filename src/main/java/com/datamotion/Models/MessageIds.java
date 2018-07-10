package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MessageIds {
	@JsonProperty("MessageIds") @Getter @Setter
	private ArrayList<Integer> MessageIds;
}
