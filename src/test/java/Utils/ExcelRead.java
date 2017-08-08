package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	XSSFWorkbook wb=null;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell cell;
	int rowcount;
	int columncount;
	
	
 
  public ExcelRead(String path) throws IOException
  {
	  
	  FileInputStream fis=new FileInputStream(path) ;
	  wb=new XSSFWorkbook(fis);
	 
		   	  
  }
  
  

public String getCelldata(String sheetName,int rownum,int columnum)
  {
	 sh=wb.getSheet(sheetName);
	  cell=sh.getRow(rownum).getCell(columnum);
	  String data=cell.getStringCellValue();
	  return data;
  }
  


public int getrowcount(String sheetName)
 {
	sh=wb.getSheet(sheetName);
	rowcount = sh.getLastRowNum()-sh.getFirstRowNum();
	 return rowcount;
 }
public int getcolumncount(String sheetName)
{
	 sh=wb.getSheet(sheetName);
	 row=sh.getRow(0);
	 columncount=row.getLastCellNum();
	 return columncount;
}


}
