package utilities;

import java.io.File;

public class DeleteFiles {
	
	String path = System.getProperty("user.dir")+"/ExtentReports";
//	File folder = new File(path);
	public void deletefiles(File folder)
	{
		 File[] files = folder.listFiles();
		if(files!=null)
		{
			for(File f: files)
			{
				if(f.isFile())
				{
					if(f.delete())
					{
						System.out.println("Files deleted successfully!!!");
					}else
					{
						System.out.println("Error while deleting files");
					}
				}
			}
		}else
		{
			System.out.println("Files not found");
		}
	}

}
