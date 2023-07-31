package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excellutil {

	



    public static boolean Excel_File_Check(String sFile)
    {
        if(sFile.isEmpty())
        {
            System.err.println("File name is blank");
            return false;
        }
        else if(sFile.endsWith(".xls") || sFile.endsWith(".xlsx"))
        {
            if(new File(sFile).exists())
            {
                return true;
            }
            else
            {
                System.err.println("File Not Exists....");
                return false;
            }
        }
        else
        {
            System.err.println("Invalid File tyep. : " + sFile );
        }
        return false;
    }
    public static boolean SheetCheck(String sFile,String sSheet )
    {
        if(Excel_File_Check(sFile))
        {
            try {
                InputStream oFile = new FileInputStream(sFile);
                Workbook oWBook = WorkbookFactory.create(oFile);
                Sheet oSheet = oWBook.getSheet(sSheet);
                if(oSheet==null)
                {
                    System.err.println("Sheet Not found : " + sSheet + "in : " +sFile );
                    oWBook.close();
                    oFile.close();
                    return false;
                }
                else
                {oWBook.close();
                oFile.close();
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        
        return false;
    }
    public static int GetMaxRowNo(String sFile,String sSheet)
    {
        if(SheetCheck(sFile, sSheet)== true)
        {
            try {
                InputStream oFile = new FileInputStream(sFile);
                Workbook oWBook = WorkbookFactory.create(oFile);
                Sheet oSheet = oWBook.getSheet(sSheet);
                if(oSheet==null)
                {
                    System.err.println("Sheet Not found : " + sSheet + "in : " +sFile );
                    oWBook.close();
                    oFile.close();
                    return -1;
                }
                else
                {
                    oWBook.close();
                    oFile.close();
                    return oSheet.getLastRowNum();
                }
            } catch (Exception e) {
                return -1;
            }
            
        }
        else
        {
            return -1;
        }
    }

    public static String GetCellStringValue(String sFile,String sSheet,int iRow,int iCell)
    {int  i = GetMaxRowNo(sFile, sSheet);
        if(i != -1 && i >= iRow)
        {
            try {
                InputStream oFile = new FileInputStream(sFile);
                Workbook oWBook = WorkbookFactory.create(oFile);
                Sheet oSheet = oWBook.getSheet(sSheet);
                Row oRow =  oSheet.getRow(iRow);
                //oRow.getLastCellNum();
                Cell oCell = oRow.getCell(iCell);
                if(oCell != null)
                {
                    oWBook.close();
                    oFile.close();
                    
                    return oCell.getStringCellValue();
                }
                else
                {
                    oWBook.close();
                    oFile.close();
                    return "<Fail to get value>";
                }
            } catch (Exception e) {
                return "<Fail to get value>";
            }
            
            
        }
        else
        {
            return "<Fail to get value>";
        }
    }

}
