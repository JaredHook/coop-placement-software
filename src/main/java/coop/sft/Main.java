package coop.sft;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        GridPane root = new GridPane();
        FlowPane leftbanner = new FlowPane();
        leftbanner.setPrefWidth(150);
        String bgStyle = "-fx-background-color: BEIGE;"
                + "-fx-background-radius: 0%;"
                + "-fx-background-inset: 5px;";
        leftbanner.setStyle(bgStyle);

        root.add(leftbanner, 0, 0, 1, 1);
        root.add(createGridPane(), 1, 0, 1, 1);
        Scene scene = new Scene(root, 950, 650);
        stage.setTitle("Willis College ");
        stage.setScene(scene);
        stage.show();
    }

    public GridPane createGridPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(20);
        grid.setVgap(20);

        Text txt = new Text("Student Coop placement Status ");
        txt.setFont(Font.font("Dialog", FontWeight.BOLD, 12));

        grid.add(txt, 1, 0, 1, 1);
        grid.add(new Separator(), 0, 1, 3, 1);

        grid.add(new Label("Students Name:"), 0, 2, 1, 1);
        grid.add(new TextField(), 1, 2, 1, 1);

        grid.add(new Label("Cours/Bash/Year:"), 0, 3, 1, 1);
        grid.add(new TextField(), 1, 3, 1, 1);
        grid.add(new Button("Browse..."), 2, 3, 1, 1);

        grid.add(new Label("Coop Host :"), 0, 4, 1, 1);

        grid.add(new TextField(), 1, 4, 1, 1);


        //Text txt2 = new Text("S ");
        //txt2.setFont(Font.font("Dialog", FontWeight.BOLD, 12));

        //grid.add(txt2, 1, 0, 2, 2);
        grid.add(new Separator(), 0, 1, 3, 1);

        grid.add(new Label("Students Name:"), 0, 2, 1, 1);
        grid.add(new TextField(), 1, 2, 1, 1);

        grid.add(new Label("Cours/Bash/Year:"), 0, 3, 1, 1);
        grid.add(new TextField(), 1, 3, 1, 1);
        grid.add(new Button("Browse..."), 2, 3, 1, 1);

        grid.add(new Label("Coop Host :"), 0, 4, 1, 1);

        grid.add(new TextField(), 1, 4, 1, 1);


        grid.add(new Separator(), 0, 5, 3, 1);

        grid.add(new Label("Coop placement :"), 0, 6, 1, 1);
        ComboBox<String> cb = new ComboBox<>();
        cb.setPrefWidth(400);
        grid.add(cb, 1, 6, 1, 1);
        grid.add(new Button("StartDate/EndDate"), 2, 6, 1, 1);

        grid.add(new CheckBox("Create Custom Preloader"), 0, 7, 3, 1);

        grid.add(new Label("\tProject Name:"), 0, 8, 1, 1);
        grid.add(new TextField(), 1, 8, 1, 1);

        grid.add(new Separator(), 0, 9, 3, 1);

        grid.add(new CheckBox("contract sign on  "
                + "Libraries"), 0, 10, 3, 1);

        grid.add(new Label("Contact Adress "), 0, 11, 1, 1);
        grid.add(new TextField(), 1, 11, 1, 1);
        grid.add(new Button("Browse..."), 2, 11, 1, 1);

        grid.add(new Label("Contact Person  "),1, 12, 1, 1);

        grid.add(new CheckBox("Work Address "), 0, 13, 1, 1);
        grid.add(new TextField(), 1, 13, 1, 1);

        grid.add(new CheckBox(""), 0, 14, 1, 1);

        grid.add(new Separator(), 0, 15, 3, 1);

        FlowPane fp2 = new FlowPane(Orientation.HORIZONTAL, 20, 20);
        fp2.setAlignment(Pos.CENTER_RIGHT);
        Button btn = new Button("Save and Print");
        fp2.getChildren().addAll(
                btn
        );
        btn.setOnAction(e ->{
            WriteExcelFile.writeExcelFile();
            WordGenerator wg = new WordGenerator();

            //VK lines text filename
//            String textFilename = "src/main/resources/coop.sft/textFile.txt";
//
//            //Gather VK Lines from text file
//            List<String> textFileLines = null;
//            try {
//                textFileLines = wg.getLines(textFilename);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }

            //Create word document according to VK lines

            try {
                wg.createWord();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        grid.add(fp2, 0, 16, 1, 2);
        grid.add(new Separator(), 3, 18, 1, 1);
        Text txtom = new Text("Office Manager ");
        txtom.setFont(Font.font("Dialog", FontWeight.BOLD, 12));

        grid.add(txtom, 2, 17, 1, 1);
        Text txtpc = new Text("Placement Coordinator");
        txtpc.setFont(Font.font("Dialog", FontWeight.BOLD, 12));

        grid.add(txtpc, 3, 18, 1, 1);
        return grid;
    }
}

