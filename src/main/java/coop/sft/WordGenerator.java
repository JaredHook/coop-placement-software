package coop.sft;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.print.PrintException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordGenerator {

    //Get lines from text file
    public List<String> getLines (String fileName) throws Exception {
        //ReadFile instance
        ReadFile rf = new ReadFile();

        //Read the text
        try {
            List<String> lines = rf.readLines(fileName);
            for (String line : lines) {
                System.out.println(line);
            }
            return lines;
        } catch (IOException e) {
            // Print out the exception that occurred
            System.out.println("Unable to create " + fileName + ": " + e.getMessage());
            throw e;
        }
    }

    //Create Word
    public void createWord() throws IOException {
            //Blank Document
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(OPCPackage.open("src/main/resources/coop.sft/coopSoftwareDoc.dotx"));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        //Write the Document in file system
            FileOutputStream out = new FileOutputStream(
                    new File("createdWord" + ".docx"));
            //create Paragraph
            replaceText(document, "Student Name", "Jeannie");

            document.write(out);


//        XWPFParagraph docHeader = document.createParagraph();
//        docHeader.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun title = docHeader.createRun();
//        XWPFRun docTitle = docHeader.createRun();
//        title.setText("WILLIS COLLEGE " + "\n");
//            docTitle.setText("STUDENT COOP PLACEMENT STATUS");
//            // styling for text
//            title.setFontFamily("Arial");
//            title.setBold(true);
//            title.setFontSize(18);
//            docTitle.setFontFamily("Arial");
//            docTitle.setBold(true);
//            docTitle.setFontSize(14);
//            PrintFile pf = new PrintFile();
//            try {
//                pf.printFile(/*add document here and pass it to print method to be printed*/);
//            } catch (PrintException e) {
//                e.printStackTrace();
//            }
            //Close document
            out.close();
            System.out.println("createdWord" + ".docx" + " written successfully");
        }

        private static XWPFDocument replaceText(XWPFDocument doc, String findText, String replaceText) {

            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if(text != null && text.contains(findText)) {
                        text = text.replace(findText, replaceText);
                        r.setText(text, 0);
                    }
                }
            }
            return doc;
        }

}