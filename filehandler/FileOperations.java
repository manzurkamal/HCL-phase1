package com.filehandler.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations {
	
	private File myFile;

    public File getMyFile() {
        return myFile;
    }    

    //Delete file so that the same statements are not duplicated
    public boolean DeleteFileIfExists(String fileName) {
        boolean status = false;
        try {
            myFile = new File(fileName);
            if (myFile.exists()) {
                status = myFile.delete();
               if (status == true) {
                   System.out.println("Deleted");
               }
               else {
                   System.out.println("No delete performed.");
               }
               return status;
            }
        }
        catch( Exception ex) {
            System.err.println(ex.getMessage());
        }
        return status;
    }
    
    //Handles both writing and appending to a file
    public boolean WriteAppendFile(String textToWrite) {

        //FileWriter writer = null;
        BufferedWriter writer = null;
        try {
            //writer = new FileWriter(myFile);
        	writer = new BufferedWriter(new FileWriter(new File("file.txt"), true));
            writer.write(textToWrite);
            //System.out.print(textToWrite);

            return true;
        }
        catch(IOException iex) {
            System.err.println("Failed writing to file.");
        }
        catch(NullPointerException npe) {
            System.err.println("File does not exist yet.");
        }
        finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
        return false;
    }
    
    //Reading from a file 
    public boolean ReadFileStream(String fileName) {
        try {
            Stream<String> str = Files.lines(Paths.get(fileName));
            for (String line : str.collect(Collectors.toList())) {
                System.out.println(line);
            }
            str.close();
        }
        catch(IOException iex) {
            System.err.println(iex.getMessage());
            return false;
        }
        return true;
    }

}
