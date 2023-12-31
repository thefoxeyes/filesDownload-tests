package com.ezopikhinaelena;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XlsXlsxFileTest {
    @Test
    void downloadXlsXlsxFile() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("175_school.xlsx");
        XLS xlsFile = new XLS(stream);
        String stringCellValue = xlsFile.excel.getSheetAt(1).getRow(3).getCell(1).getStringCellValue();
        Assertions.assertTrue(stringCellValue.equals("Бондаренко Наталья Николаевна"));
    }
}