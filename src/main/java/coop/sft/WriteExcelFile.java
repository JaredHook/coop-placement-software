package coop.sft;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

    private static String[] columns = {"Student Name", "Email", "Program Name", "Company Name", "Start Date", "End Date"};

    public static void writeExcelFile(Person person)
    {

//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

//Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Student Data");

//This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put("2", new Object[] {person.getFirstName() + " " + person.getLastName(), "tom@willis.com", "MSD", "Survey Monkey", "21-08-2019", "18-01-2020" });


//Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 1;

// Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

// Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

// Create a Header Row
        Row headerRow = sheet.createRow(0);

// Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
//Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("writtenExcelFile.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("****File written successfully*****");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
