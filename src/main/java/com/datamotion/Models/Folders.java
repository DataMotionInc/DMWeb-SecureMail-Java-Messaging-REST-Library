package com.datamotion.Models;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonProperty("Folders")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<Folder> Folders;

	@Override
	public String toString() {
		return "Folders [\nFolders=" + Folders + "]";
	}
}
