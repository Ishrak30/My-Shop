/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnaina;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
/**
 *
 * @author Faiyaz
 */
public class Accessexcelfile {
    
    //when making a purchase
public void addrecord(String name,String department,String Size,double quantity,double ID) throws Exception{
 OPCPackage pkg = OPCPackage.open(new FileInputStream("Merchandise-Info.xlsx"));

   XSSFWorkbook wb = new XSSFWorkbook(pkg);
XSSFSheet sheet = wb.getSheetAt(0);

int lastrownum = sheet.getLastRowNum();

//INPUT ROW
int inputrow = lastrownum+1;
XSSFRow row = sheet.createRow(inputrow);
row = sheet.getRow(inputrow);

    XSSFCell cell[] = new XSSFCell[5];
    
   //name
       cell[0] = row.createCell(0);
        cell[0].setCellType(CellType.STRING);
           cell[0].setCellValue(name);
    
   //Department
     cell[1] = row.createCell(1);
    cell[1].setCellType(CellType.STRING);
        cell[1].setCellValue(department);
    
    //Size
      cell[2] = row.createCell(2);
    cell[2].setCellType(CellType.STRING);
         cell[2].setCellValue(Size);
    
    //Quantity
      cell[3] = row.createCell(3);
    cell[3].setCellType(CellType.NUMERIC);
             cell[3].setCellValue(quantity);
    
    //Contact number
    cell[4] = row.createCell(4);
    cell[4].setCellType(CellType.NUMERIC);
        cell[4].setCellValue(ID);
    
wb.write(new FileOutputStream("Merchandise-Info.xlsx"));
wb.close();

    }

//remove 1 from stock

public void removefromstock(String department,String size,double quantity) throws Exception{
OPCPackage opk = OPCPackage.open(new FileInputStream("MerchandiseOrders.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(opk);
    XSSFSheet sheet = wb.getSheetAt(0);
    XSSFCell cell[] = new XSSFCell[3];
    
int lastrownum = sheet.getLastRowNum();
int firstrownum = sheet.getFirstRowNum()+1;

    for(int rownum=firstrownum;rownum<=lastrownum;rownum++){
    XSSFRow row = sheet.getRow(rownum);
    cell[0]=row.getCell(0);
    cell[1]=row.getCell(1);
    cell[2]=row.getCell(2);
    
        String inputDepartment = cell[0].getStringCellValue();
        String inputSize = cell[1].getStringCellValue();
        double quant = cell[2].getNumericCellValue();
        
        if(department.equals(inputDepartment)&&size.equals(inputSize)){
            cell[2].setCellType(CellType.NUMERIC);
            cell[2].setCellValue(quant-quantity);
        }
        }
      wb.write(new FileOutputStream("MerchandiseOrders.xlsx"));
      wb.close();
     }
}
