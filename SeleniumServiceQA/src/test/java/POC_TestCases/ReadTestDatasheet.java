package POC_TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadTestDatasheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println();
	}
	
	 public String Readsheet(String file,String sheetName,String rowvalue,String colnumvalue) {
		 String ReturnCellvalue = "";
		 try {
		    	
				FileInputStream inputStream = new FileInputStream(file);
				HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
				HSSFSheet sheet = workbook.getSheet(sheetName);
				HSSFFormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
				DataFormatter objDefaultFormat = new DataFormatter();
				for(int i=0; i<=sheet.getLastRowNum(); i++)
				{
					//System.out.println("Rowvalue---"+sheet.getRow(i).getCell(0).getStringCellValue());
					if (rowvalue.equals(sheet.getRow(i).getCell(0).getStringCellValue()))
					{
						for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
						{
							//System.out.println("colomnvalue---"+sheet.getRow(0).getCell(j).getStringCellValue());
							if (colnumvalue.equals(sheet.getRow(0).getCell(j).getStringCellValue()))
							{
								Cell cellvalue=sheet.getRow(i).getCell(j);
								objFormulaEvaluator.evaluate(cellvalue); // This will evaluate the cell, And any type of cell will return string value
							    ReturnCellvalue = objDefaultFormat.formatCellValue(cellvalue,objFormulaEvaluator);
							    //System.out.println("datavalue----"+ReturnCellvalue);
							 break;
							}
							
						}
						break;
					}
					
				}
				//System.out.println("datavalue----"+ReturnCellvalue);
			} 
		    catch (Exception e) {
				
				e.printStackTrace();
			}
		    return ReturnCellvalue;
		}
		   
	
	public  String getdatafromsheet(String sheetName,String rowvalue,String colnumvalue){
		String Datavalue="";
		   File sourceDir = new File(System.getProperty("user.dir"));
		    System.out.println("The current directory is = "+sourceDir);
		    if(sourceDir.exists()) {
		        if(sourceDir.isDirectory())
		        {
		            String[] filesInsideThisDir = sourceDir.list();
		           int numberOfFiles = filesInsideThisDir.length;
		           System.out.println(numberOfFiles);
		            for(String filename : filesInsideThisDir)
		            {
		                if(filename.contains("Spring"))
		            	System.out.println("(prFiles) The file name to read is = "+filename);
		                Datavalue= Readsheet(filename, sheetName,rowvalue,colnumvalue);
		                
		            }
		        } else {
		            System.out.println("(processFiles) Source specified is not a directory.");
		        }
		    } 
		    else {
		    	System.out.println("Source directy is not specified correct path "+sourceDir);
		    }
			return Datavalue;
	   
	}
}
