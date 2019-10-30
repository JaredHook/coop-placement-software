package coop.sft;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.io.*;

public class PrintFile {
    public void printFile(/*setup arguments for printing*/) throws IOException, PrintException {

        //Java print api sample example
        InputStream stream = new FileInputStream(new File("src/main/resources/coop.sft/textFile.txt"));

        DocFlavor myFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc myDoc = new SimpleDoc(stream, myFormat, null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        aset.add(new Copies(1));
        PrintService default1 = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = default1.createPrintJob();
        job.print(myDoc, aset);
        stream.close();

    }
}
