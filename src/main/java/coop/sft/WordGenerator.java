package coop.sft;

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
            XWPFDocument document = new XWPFDocument();
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(
                    new File("createdWord" + ".docx"));

            //create Paragraph
            XWPFParagraph docHeader = document.createParagraph();
            docHeader.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun title = docHeader.createRun();
            title.setText("WILLIS COLLEGE " + "\n");
            // styling for text
            title.setBold(true);
            title.setFontSize(18);
            document.write(out);

            PrintFile pf = new PrintFile();
            try {
                pf.printFile(/*add document here and pass it to print method to be printed*/);
            } catch (PrintException e) {
                e.printStackTrace();
            }
            //Close document
            out.close();
            System.out.println("createdWord" + ".docx" + " written successfully");
        }

}