package com.datamotion.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to hold an ArrayList of folders
 */
@AllArgsConstructor
@NoArgsConstructor
public class Folders {
	/**
	 * <code>ArrayList</code> of folders
	 */
	@JsonProperty("Folders") @Getter @Setter
	private ArrayList<Folder> Folders;
}
