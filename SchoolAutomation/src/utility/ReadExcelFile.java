package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public Sheet ReadExcel(String FilePath,String FileName,String SheetName) throws IOException{
		File file = new File(FilePath+"/"+FileName);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook TestWorkbook= null;
		String FileExtensionName = FileName.substring(FileName.indexOf("."));
		System.out.println(FileExtensionName);
		
		if(FileExtensionName.equalsIgnoreCase(".xlsx"))
		{
			TestWorkbook = new XSSFWorkbook(inputstream);
			System.out.println("It is .xlsx file");
		
		}
		
		else if (FileExtensionName.equalsIgnoreCase(".xls"))
		{
			TestWorkbook = new HSSFWorkbook(inputstream);
		}
		Sheet TestSheet = null;
		TestSheet = TestWorkbook.getSheetAt(0);
		return TestSheet;
		
	}
}

