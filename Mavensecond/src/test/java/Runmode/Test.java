/*package Runmode;

import org.apache.xpath.operations.String;
import datatable.Xls_Reader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader datatable=new Xls_Reader(System.getProperty("user.dir")+"//src//config//Controller.xlsx");
       java.lang. String testcase="SignupAllAges";
		System.out.println(datatable.getCellData("Test Cases", "TCID", 2));
		System.out.println(datatable.getRowCount("Test Cases"));
		
		 
		 for(int i=2; i<=datatable.getRowCount("Test Cases");i++ ){
	    	  if(datatable.getCellData("Test Cases", "TCID", i).equals(testcase)){
	    		  if(datatable.getCellData("Test Cases", "Runmode", i).equals("Y"))
	    			  System.out.println("Runmode is Yes");
	    		  else
	    			  System.out.println("Runmode is No");
	    	  }
	    	  
	     	      
	       boolean b =Boolean.valueOf("true");

			
		
	}

}}*/