package com.ezopikhinaelena;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DocDocxFileTest {
    @Test
    public void testReadWordFile() throws IOException {
        String fileName = "Version_Control_System.doc";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        String fileText = readWordFile(file);
        Assertions.assertTrue(fileText.contains("СКВ"));
    }

    private String readWordFile(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            WordExtractor extractor = new WordExtractor(inputStream);
            return extractor.getText();
        }
    }
}
