package Utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import Testcases.Testbase;

public class TestUtil extends Testbase{
	
	public static boolean isskip(String testcase){
    for (int i=2; i<=datatable.getRowCount("Test cases");i++){
	if (datatable.getCellData("Test cases", "TCID",i).equals(testcase)){
		if(datatable.getCellData("Test cases", "Runmode",i).equals("Y"))
	      return false;
		else
			return true;
	
	}
	
}
return false;
           
}
	
	
	public static Object[][] getData(String sheetName){
		// return test data;
		// read test data from xls
		
		int rows=datatable.getRowCount(sheetName)-1;
		if(rows <=0){
			Object[][] testData =new Object[1][0];
			return testData;
			
		}
	    rows = datatable.getRowCount(sheetName);  // 3
		int cols = datatable.getColumnCount(sheetName);
		System.out.println("total rows -- "+ rows);
		System.out.println("total cols -- "+cols);
		Object data[][] = new Object[rows-1][cols];
		
		for( int rowNum = 2 ; rowNum <= rows ; rowNum++){
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=datatable.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
		
		
	}
	
	// store screenshots
	
public static void takeScreenShot(String fileName)

{
	
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

try {
	
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+" .jpg"));
	
	
}catch(IOException e){
	
	
	e.printStackTrace();
}
	
	
}
	
//make zip of reports

public static void zip(String filepath)
{
	
	try{
		
		File inFolder=new File(filepath);
		File outFolder=new File("Reports.zip");
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	    BufferedInputStream in =null;
		
		byte[] data = new byte[1000];
		String files[] = inFolder.list();
		
		for(int i=0; i<files.length; i++)
		{
			
			in = new BufferedInputStream(new FileInputStream(inFolder.getPath() + "/"  +files[i]), 1000);
			out.putNextEntry(new ZipEntry(files[i]));
			
			int count;
			
			while((count = in.read(data, 0,1000)) != -1)

{
	
	out.write(data, 0 , count);
}
			
			out.closeEntry();
			
		}
		
		
		out.flush();
		out.close();
			
	}			
		
	
	catch(Exception e)
	  {
		  e.printStackTrace();
	  } 
	 }


public static Object now(String string) {
	// TODO Auto-generated method stub
	return null;
}	
		
		
		
		
	}

	

	
	
	


		