package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to hold an ArrayList of folders
 */

public class Folders {
	/**
	 * <code>ArrayList</code> of folders
	 */
	@JsonProperty("Folders")
	private ArrayList<Folder> Folders;

	@Override
	public String toString() {
		return "Folders [\nFolders=" + Folders + "]";
	}

	@JsonIgnore
	public Folders() {
		Folders = null;
	}

	@JsonIgnore
	public Folders(ArrayList<Folder> folders) {
		Folders = folders;
	}

	@JsonIgnore
	public ArrayList<Folder> getFolders() {
		return Folders;
	}

	@JsonIgnore
	public void setFolders(ArrayList<Folder> folders) {
		Folders = folders;
	}
}
