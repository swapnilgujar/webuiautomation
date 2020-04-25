package utils;

import java.io.File;
import java.util.Arrays;

import reporting.TestLog;

public class PDFReader {
    private PDFReader() {}
    public static String parsePdfToString(File pdfFile) {
        String resultStr="ERROR 100-PDF FILE NOT READ";
        try {
//            TestLog.get().console("File read started...");
//            FileInputStream fis=new FileInputStream(pdfFile);
//            PDFParser parser=new PDFParser(fis);
//            parser.parse();
//            COSDocument cosDoc=parser.getDocument();
//            PDDocument pdDocument=new PDDocument(cosDoc);
//            PDFTextStripper stripper=new PDFTextStripper();
//            resultStr=stripper.getText(pdDocument);
//            TestLog.get().console("File read Succeeded!");

        } catch (Exception e) {
            TestLog.get().console("ERROR::File read FAILED: "+Arrays.toString(e.getStackTrace()));
        } 
        return resultStr;
    }

    public static boolean lookupTextInPdf(File pdfFile, String lookupText) {
        String data= PDFReader.parsePdfToString(pdfFile);
        return data.contains(lookupText);
    }
}
