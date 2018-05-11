package testcase;


import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import config.BuildKeyWord;
import utility.ReadExcelFile;
import utility.ReadProperties;

public class Login {

	
	public void loginpage() throws Exception{
		ReadProperties ObjectName = new ReadProperties();
		Properties p = ObjectName.getObject();
		BuildKeyWord Keyword= new BuildKeyWord();
		ReadExcelFile ExcelData = new ReadExcelFile();
			Sheet TestSheet= ExcelData.ReadExcel(p.getProperty("ExcelFilePath"), p.getProperty("ExcelFileName"), p.getProperty("ExcelSheetName"));
		int rowCount = TestSheet.getLastRowNum()-TestSheet.getFirstRowNum();
		for(int i=1;i<=rowCount;i++){
			Row row = TestSheet.getRow(i);
			Keyword.performOperation(p, row.getCell(4).toString(), row.getCell(5).toString(), row.getCell(6).toString(), row.getCell(7).toString());
			System.out.println(row.getCell(3).toString()+"----"+ row.getCell(4).toString()+"----"+
		            row.getCell(5).toString()+"----"+ row.getCell(6).toString()+"----"+row.getCell(7).toString());
		}
		
	}


public static void main(String[] arg)
{
	Login obj = new Login();
	try {
		obj.loginpage();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}