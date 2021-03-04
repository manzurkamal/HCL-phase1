package virtualkey;

public class DirectoryService {

    private static Directory fileDirectory = new Directory();

    public static void AddTestData() {
        fileDirectory.AddFile(new File("test1.txt"));
        fileDirectory.AddFile(new File("test2.txt"));
        fileDirectory.AddFile(new File("test3.txt"));
        fileDirectory.AddFile(new File("test4.txt"));
        
    }
    
    public static boolean AddUserData(String filename) {
    	boolean holder=fileDirectory.AddFile(new File(filename+".txt"));
    	return holder;
    }
    
    public static void DeleteUserData(String filename) {
        fileDirectory.DeleteFile(new File(filename+".txt"));
    }    
    
    public static void SearchUserData(String filename) {
        fileDirectory.SearchFile(filename);
    }

    public static void PrintFiles() {    	

        for (File file : DirectoryService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        DirectoryService.fileDirectory = fileDirectory;
    }
}