/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnaina;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import java.io.*;
import java.lang.StringBuffer;

public class Accounthandling {
public void createaccount(String name,String password) throws Exception{
    
        OPCPackage opk = OPCPackage.open(new FileInputStream("Accounts.xlsx"));
    XSSFWorkbook wb = new XSSFWorkbook(opk);
    
    XSSFSheet sheet = wb.getSheetAt(0);
     
        //getting the last row number to provide input
        
      int lastrownumber = sheet.getLastRowNum();
        XSSFRow row = sheet.createRow(lastrownumber+1);
        
        XSSFCell cell[] = new XSSFCell[2];
        
        //storing name in excel file
        cell[0] = row.createCell(0);
        cell[0].setCellType(CellType.STRING);
        cell[0].setCellValue(name);
        
        //storing the password in the excel file
        cell[1] = row.createCell(1);
        cell[1].setCellType(CellType.STRING);
        cell[1].setCellValue(password);
        
       wb.write(new FileOutputStream("Accounts.xlsx"));
        wb.close();
    }
    
    
    public boolean accountlogin(String name,String password) throws Exception{
    OPCPackage opk = OPCPackage.open(new FileInputStream("Accounts.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(opk);
    XSSFSheet sheet = wb.getSheetAt(0);
    XSSFCell cell[] = new XSSFCell[2];
    
    
    boolean userinformation = false;
    //getting the first and last row to search the username and password from
    int lastrownum = sheet.getLastRowNum();
    int firstrownum = sheet.getFirstRowNum()+1;
        for(int rownum=firstrownum;rownum<=lastrownum;rownum++){
        XSSFRow row =sheet.getRow(rownum);
            cell[0]=row.getCell(0);
            cell[1]=row.getCell(1);
            String username = cell[0].getStringCellValue();
            String userpassword = cell[1].getStringCellValue();
       
        
        if(username.equals(name)&&userpassword.equals(password)){
            userinformation = true;
            System.out.println("login successfull");
         break;   
            }
        }
        
        wb.close();
    return userinformation;
    }
}
