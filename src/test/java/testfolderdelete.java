import java.io.File;

import org.testng.annotations.Test;

public class testfolderdelete {
	
	String projectpath= System.getProperty("user.dir");
	File folder = new File(projectpath+"/screenshot");
	@Test
	public void delete(){

    // Get a list of all files in the folder
    File[] files = folder.listFiles();
   System.out.println("here");
    if (files != null) {
        // Iterate through the files and delete each one
        for (File file : files) {
            if (file.isFile()) { // Check if it's a file (not a folder)
                if (file.delete()) {
                    System.out.println("Deleted file: " + file.getName());
                } else {
                    System.out.println("Failed to delete file: " + file.getName());
                }
            }
        }
    } else {
        System.out.println("No files found in the folder.");
    }
	}

}
