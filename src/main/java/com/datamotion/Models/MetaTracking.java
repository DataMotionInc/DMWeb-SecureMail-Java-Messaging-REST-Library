package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MetaTracking {
	@JsonProperty("Recipients") @Getter @Setter
	private ArrayList<Recipients> Recipients;
}
