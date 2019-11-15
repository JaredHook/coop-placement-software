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
    public List<String> getLines(String fileName) throws Exception {
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
    public void createWord(Person person) throws IOException {
        //Blank Document
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(OPCPackage.open("src/main/resources/coop.sft/CoopTemplate.docx"));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        //Write the Document in file system
        File file = new File("createdWord.docx");
        FileOutputStream out = new FileOutputStream(file);
        //create Paragraph
        TextReplacer replacer = new TextReplacer("$Student", person.getFirstName() + " " + person.getLastName());
        replacer.replace(document);
        replacer.setSearchValue("$Course");
        replacer.setReplacement(person.getCourse() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Batch");
        replacer.setReplacement(person.getBatch() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Year");
        replacer.setReplacement(person.getYear() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Coop-Host");
        replacer.setReplacement(person.getCoopHost() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Start-Date");
        replacer.setReplacement(person.getStartDate() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$End-Date");
        replacer.setReplacement(person.getEndDate() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Contract-Signed-On");
        replacer.setReplacement(person.getContractSignedOn() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Actual-End-Date");
        replacer.setReplacement(person.getActualEndDate() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$WSIB-On-File");
        replacer.setReplacement(person.getWsib() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Insurance-On-File");
        replacer.setReplacement(person.getInsurance() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Evaluation-1-Due-Date");
        replacer.setReplacement(person.getEvaluation1DueDate() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Evaluation-1-Submitted-On");
        replacer.setReplacement(person.getEvaluation1SubmittedOn() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Evaluation-2-Due-Date");
        replacer.setReplacement(person.getEvaluation2DueDate() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Evaluation-2-Submitted-On");
        replacer.setReplacement(person.getEvaluation2SubmittedOn() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Timesheet-Due-Date");
        replacer.setReplacement(person.getTimesheetDueDate() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Timesheet-Submitted-On");
        replacer.setReplacement(person.getTimesheetSubmittedOn() + " ");
        replacer.replace(document);
        //TODO: Change variable on template from $Work-Address to $Contact-Email
        replacer.setSearchValue("$Contact-Email");
        replacer.setReplacement(person.getContactEmail() + " ");
        replacer.replace(document);
        //TODO: Change variable on template from $Contact-Person to $Contact-Name
        replacer.setSearchValue("$Contact-Name");
        replacer.setReplacement(person.getContactName() + " ");
        replacer.replace(document);
        replacer.setSearchValue("$Contact-Number");
        replacer.setReplacement(person.getContactNumber() + " ");
        replacer.replace(document);
        //TODO: Add variable to template $Contact-Address
        replacer.setSearchValue("$Contact-Address");
        replacer.setReplacement(person.getContactAddress() + " ");
        replacer.replace(document);


        // these fields no longer required on ui form - only on word doc template.
        //replacer.setSearchValue("$Follow-ups");
        //replacer.setReplacement(person.getFollowUps() + " ");
        //replacer.replace(document);
        //replacer.setSearchValue("$Pass-Fail-Entered");
        //replacer.setReplacement(person.getPassFailEntered() + " ");
        //replacer.replace(document);
        //replacer.setSearchValue("$Attendance-Entered");
        //replacer.setReplacement(person.getAttendanceEntered() + " ");
        //replacer.replace(document);
        //replacer.setSearchValue("$Office-Manager");
        //replacer.setReplacement(person.getOfficeManager() + " ");
        //replacer.replace(document);
        //replacer.setSearchValue("$Placement-Coordinator");
        //replacer.setReplacement(person.getPlacementCoordinator() + " ");
        //replacer.replace(document);

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


        //Close document
        out.close();

        PrintFile pf = new PrintFile();
        try {
            pf.printFile(file);
        } catch (PrintException e) {
            e.printStackTrace();
        }
        System.out.println("createdWord" + ".docx" + " written successfully");
    }



//    private static XWPFDocument replaceText(XWPFDocument doc, String findText, String replaceText) {
//
//        for (XWPFParagraph p : doc.getParagraphs()) {
//            List<XWPFRun> runs = p.getRuns();
//            for (XWPFRun r : runs) {
//                String text = r.getText(0);
//                if (text != null && text.contains(findText)) {
//                    text = text.replace(findText, replaceText);
//                    r.setText(text, 0);
//                }
//            }
//        }
//        return doc;
//    }

}