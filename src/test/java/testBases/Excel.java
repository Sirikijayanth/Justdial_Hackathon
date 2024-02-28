package testBases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	static String file="C:\\Users\\2304081\\eclipse-workspace\\Hackathon_Project\\src\\test\\java\\testBases\\Excel.java";
	public static void setCellData(String sheet,int r,int c,String text) throws IOException {
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		if(ws.getRow(r)!= null) {
			row=ws.getRow(r);
		}
		else {
			row=ws.createRow(r);
		}
		cell=row.createCell(c);
		cell.setCellValue(text);
		fo=new FileOutputStream(file);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}
}
