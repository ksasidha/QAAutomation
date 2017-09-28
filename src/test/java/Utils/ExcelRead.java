package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
  public ExcelRead() 
  {
	  
	   
		   	  
  }
  

public String getCelldata(int sheetIndex,int rownum,int columnum)
  {
	 sh=wb.getSheetAt(sheetIndex);
	  cell=sh.getRow(rownum).getCell(columnum);
	  if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC ) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	          return  String.valueOf((dateFormat.format(cell.getDateCellValue())));
	        } else {
			return String.valueOf(cell.getNumericCellValue());}
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return "";
			
		}
	  /*String data=cell.getStringCellValue();
	  return data;
	  
	  */
	return null;
  }
  


public int getrowcount(int sheetIndex)
 {
	sh=wb.getSheetAt(sheetIndex);
	rowcount = sh.getLastRowNum();
	 return rowcount;
 }
public int getcolumncount(int sheetIndex)
{
	 sh=wb.getSheetAt(sheetIndex);
	 row=sh.getRow(0);
	 columncount=row.getLastCellNum();
	 return columncount;
}

public void Writetoexcel(int Sheet,int row,int col,String value) throws Exception

{	
	FileInputStream fin;

		fin = new FileInputStream(new File("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx"));	
		
		wb=new XSSFWorkbook(fin);
		
		sh=wb.getSheetAt(Sheet) ;
		//FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		Cell cell=sh.getRow(row).getCell(col);
	   //String  i="250";
	   // Row=wsh.getRow(23);
	    //wCell=Row.getCell(8);
		if (cell == null)
		    cell = sh.getRow(row).createCell(col);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
		//CellValue value1 = evaluator.evaluate( cell ) ;
		//System.out.println(value1);
		fin.close();
		
		FileOutputStream output_file =new FileOutputStream(new File ("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx"));  
        
        wb.write(output_file); //write changes
          
        output_file.close();  //close the stream   
        
    
       
	  	
	
}


}


