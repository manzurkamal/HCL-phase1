package virtualkey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class Directory {

    String name;

    ArrayList<File> files = new ArrayList<File>();

    ArrayList<Directory> directories = new ArrayList<Directory>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<File> getFiles() {
    	files.sort(Comparator.comparing(File::getName));
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
    
    public void SearchFile(String filename) {
    	boolean isFound=false;
        for (File f : files) {
        	
            if (f.getName().toLowerCase().equals(filename.toLowerCase()+".txt")) {
                System.out.println("File " + filename + ".txt found");
                isFound=true;
            }                       
        }        
        if(!isFound) {
        	 System.out.println("File " + filename + " not found");
        }       
    }

    public void DeleteFile(File file) {
    	
    	int counter=0;
    	int toDelete=-1;
    	 for (File f : files) {
             if (f.getName().equals(file.name)) {
            	
            	 toDelete=counter;
             }
             counter++;
         }
    	  if(toDelete!=-1) {
    		  files.remove(toDelete);
    		  System.out.println(file.name+ " removed");
    	  }
    	  else {
    		  System.out.println("File not Found");
    	  }
    }
    public boolean AddFile(File file) {
    	boolean isAdded = true;
    	
    	for (File f : files) {
        	
            if (f.getName().toLowerCase().equals(file.getName())) {
                isAdded=false;
            }
    	}
    	if (isAdded) {
    		files.add(file);
    	}
    	return isAdded;      
    }
}