package com.athena.automation.framework.tooling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    
    String retelem;
    
    @SuppressWarnings("deprecation")
    
    //Use this function to read data from excel file.
    //Parameters:
    //fileName - String object
    //sheetName - String object
    //ColumnName - String object
    //rowNum - String object
    public String readXLSXFile(String fileName, String sheetName, String columnName,int rowNum) {
        InputStream XlsxFileToRead = null;
        XSSFWorkbook workbook = null;
        
        try {
            XlsxFileToRead = new FileInputStream(fileName);
            
            //Getting the workbook instance for xlsx file
            workbook = new XSSFWorkbook(XlsxFileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //getting the first sheet from the workbook using sheet name. 
        // We can also pass the index of the sheet which starts from '0'.
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row;
        XSSFCell cell;
        
        //Iterating all the rows in the sheet
        Iterator rows = sheet.rowIterator();
    
             int col_Num = -1;
                sheet = workbook.getSheet(sheetName);
                row = sheet.getRow(0);
                for(int i = 0; i < row.getLastCellNum(); i++)
                {
                    if(row.getCell(i).getStringCellValue().trim().equals(columnName.trim()))
                        col_Num = i;
                }
     
                
                row = sheet.getRow(rowNum - 1);
                cell = row.getCell(col_Num);
                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    System.out.print(cell.getStringCellValue() + " ");
                    retelem = cell.getStringCellValue() + " ";
                    
                } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + " ");
                    retelem = cell.getNumericCellValue() + " ";
                }
                
                
            System.out.println();
            try {
                XlsxFileToRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return retelem;
    
    }
    
    
//    public static void main(String[] args) {
//        ReadExcel readXlsx = new ReadExcel();
//        readXlsx.readXLSXFile("C:/Book1.xlsx","Sheet1","Name",3);    
//    }

}