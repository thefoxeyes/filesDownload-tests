package com.ezopikhinaelena;

import com.codeborne.pdftest.PDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class PdfFileTest {
    @Test
    void downloadPdfFile() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File filePdf = $(byText("PDF download")).download();
        PDF parsedPdf = new PDF(filePdf);
        assertThat(parsedPdf.author).contains("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein");
    }

    @Test
    public void testReadPdfFile() throws IOException {
        Path filePath = Paths.get("src", "test", "resources", "pamyatka_roditelyam.pdf");
        String pdfText = readPdfFile(filePath);
        Assertions.assertTrue(pdfText.contains("Особенности организации и правила пребывания детей в детских лагерях."));
    }

    private String readPdfFile(Path filePath) throws IOException {
        PDDocument document = PDDocument.load(Files.newInputStream(filePath));
        {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}
