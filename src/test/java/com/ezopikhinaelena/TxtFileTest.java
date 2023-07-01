package com.ezopikhinaelena;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TxtFileTest {
    @Test
    void downloadTxtFile() throws Exception {
        open("https://github.com/SpectatorLife/PoolTrainingForLoad/blob/master/test.txt");
        File fileText = $("#raw-url").download();
        String xFile = FileUtils.readFileToString(fileText, "UTF-8");
        Assertions.assertTrue(xFile.contains("список упражненений в супер группе"));
    }

    @Test
    public void testReadTxtFile() throws IOException {
        Path filePath = Paths.get("src", "test", "resources", "Precious_stones.txt");
        String fileContent = Files.readString(filePath);
        Assertions.assertTrue(fileContent.contains("Pacific"));
    }
}