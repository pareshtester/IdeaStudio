package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class CreateFile {

	 public File fileSetup()
	 {   String path = System.getProperty("user.dir");
	 Date d = new Date();
	 String datepath = d.toString().replace(" ", "-").replace(":","-");
		 File extentFile = new File(path+"/ExtentReports/"+datepath+".html");
		 try {
			if(extentFile.createNewFile())
			 {
				 System.out.println("File created successfully"+extentFile.getName());
			 }else {
				 System.out.println("File already exists");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.out.println("Error occured");
			e.printStackTrace();
		}
		 return extentFile;
	 }
}
