package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Writetoexcel {
	
	public static XSSFWorkbook wwb;
	public static XSSFSheet wsh;
	public static XSSFCell wCell;
	public static XSSFRow Row;
	
	
	  @Test
  public void Writetoexcel(String Sheet,int row,int col,String value) throws Exception

  {	
  	FileInputStream fin;

  		fin = new FileInputStream(new File("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx"));	
  		
  		wwb=new XSSFWorkbook(OPCPackage.open(fin));
  		
  		wsh=wwb.getSheet(Sheet) ;
  		FormulaEvaluator evaluator = wwb.getCreationHelper().createFormulaEvaluator();
  		wCell=null;
  		wCell=wsh.getRow(row).getCell(col);
  	   //String  i="250";
  	   // Row=wsh.getRow(23);
  	    //wCell=Row.getCell(8);
  		wCell.setCellValue(value);
  		CellValue value1 = evaluator.evaluate( wCell ) ;
  		System.out.println(value1);
  		fin.close();
  		
  		FileOutputStream output_file =new FileOutputStream(new File ("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx"));  
          
          wwb.write(output_file); //write changes
            
          output_file.close();  //close the stream   
          
      
         
	  	
  	
  }

 


  }

  

