package com.mayankPaliwal.utilsExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel  {


    public static String SHEET_PATH = System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";
    static Workbook book;
    static Sheet sheet;


    public static Object[][] getDataFromExcel(String sheet_Name){

        FileInputStream file ;
        try{

            file = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(file);

            for (int i = 0; i < book.getNumberOfSheets(); i++) {
                System.out.println("Available sheet: [" + book.getSheetName(i) + "]");
            }
            sheet = book.getSheet(sheet_Name);

            if(sheet == null){
               throw new RuntimeException("sheet not found " + sheet_Name );
            }
        } catch (IOException e) {
            System.out.println("File not found !!");
            e.printStackTrace();
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0 ; i < sheet.getLastRowNum(); i++ ){

            for(int j = 0 ; j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;

    }

}
