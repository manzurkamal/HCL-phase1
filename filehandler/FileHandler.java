package com.filehandler.main;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileHandler {

	public static void main(String[] args) {
		
		//String fileName = "file.txt";		
		FileOperations fileOperations = new FileOperations(); 
		fileOperations.DeleteFileIfExists("file.txt"); 
		fileOperations.WriteAppendFile("Hello everyone!"); 
		fileOperations.WriteAppendFile("\nHow are you all doing today?"); 
		fileOperations.WriteAppendFile("\nI am working on a java project."); 
		fileOperations.WriteAppendFile("\nLet's have a great day today."); 
		fileOperations.ReadFileStream("file.txt"); 
		 
	}

}
