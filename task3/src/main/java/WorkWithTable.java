import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class WorkWithTable {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Row row;

    private void createTable(){
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Sheet");
        int rowNum = 0;

        row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Код");
        row.createCell(1).setCellValue("organization");
        row.createCell(2).setCellValue("documentKind");
        row.createCell(3).setCellValue("templateName");
        row.createCell(4).setCellValue("hiddenDelete");
    }

    public void writeToXLSX(List<DataModel> dataModelList, String outputPath, String fileName){
        createTable();

        System.out.println(new Timestamp(System.currentTimeMillis()));

        int rowNum = 0;
        for (DataModel dm : dataModelList){
            ++rowNum;
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(dm.getCod());
            row.createCell(1).setCellValue(dm.getOrganizationName());
            row.createCell(2).setCellValue(dm.getDocumentKind());
            row.createCell(3).setCellValue(dm.getTemplateName());
            row.createCell(4).setCellValue(dm.getHiddenDelete());
        }

        try (FileOutputStream out = new FileOutputStream(new File(outputPath + fileName))) {
            workbook.write(out);
            System.out.println(new Timestamp(System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
