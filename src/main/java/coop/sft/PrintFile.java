package coop.sft;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.io.*;

public class PrintFile {
    public void printFile(File file) throws IOException, PrintException {

        //Java print api sample example
        InputStream stream = new FileInputStream(file);

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
