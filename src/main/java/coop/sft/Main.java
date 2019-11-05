package coop.sft;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        FlowPane leftbanner = new FlowPane();
        leftbanner.setStyle("-fx-border-color: black");

        //Create a ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        // Set content for ScrollPane
        scrollPane.setContent(root);
        // Always show vertical scroll bar
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        // Horizontal scroll bar is only displayed when needed
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        leftbanner.setPrefWidth(100);
        String bgStyle = "-fx-background-color: BEIGE;"
                + "-fx-background-radius: 0%;"
                + "-fx-background-inset: 10px;";
        leftbanner.setStyle(bgStyle);


//        TextArea textArea = new TextArea();
        root.add(leftbanner, 0, 0, 1, 1);
        root.add(createGridPane(), 1, 0, 1, 1);
        Scene scene = new Scene( scrollPane, 900, 700);
        stage.setTitle("Willis College ");
        stage.setScene(scene);
        stage.show();
    }



    public GridPane createGridPane() {

        Person person = new Person();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(20);
        grid.setVgap(20);

        //Form fields Objects declaration

        Label FirstName = new Label();
        TextField Fname = new TextField();

        Label LastName = new Label();
        TextField Lname = new TextField();

        Label CourseL = new Label();
        TextField Course = new TextField();

        TextField BatchYear = new TextField();
        DatePicker Batch = new DatePicker();

        Label CoopHostL = new Label();
        TextField CoopHost = new TextField();




        Text txt = new Text("Student Coop placement Status");
        txt.setFont(Font.font("Dialog", FontWeight.BOLD, 20));
        grid.add(txt, 1, 0, 1, 1);

        //Head text separator column layout

        grid.add(new Separator(), 0, 1, 3, 1);

        //Student name label

        Text ProfileText = new Text("Student's Profile");
        ProfileText.setFont(Font.font("Dialog", FontWeight.BOLD, 15));
        grid.add(ProfileText, 1, 2, 1, 1);

        grid.add(new Label("First Name:"), 0, 3, 1, 1);
        grid.add(FirstName, 2, 3, 1,1);
        grid.add(Fname, 1, 3, 1, 1);

        grid.add(new Label("Last Name:"), 0, 4, 1, 1);
        grid.add(Lname, 1, 4, 1, 1);

        grid.add(new Label("Course studied:"), 0, 5, 1, 1);
        grid.add(Course, 1, 5, 1, 1);

//        grid.add(new Separator(), 0, 4, 3, 1);

        grid.add(new Label("Bash/Year:"), 0, 6, 1, 1);

        //Date Picker
        DatePicker datePicker = new DatePicker();
        grid.add(Batch, 1, 6, 1, 1);


        //Add Button to read date
//        Button button = new Button("Read Date");
//        button.setOnAction(action -> {
//            LocalDate value = datePicker.getValue();
//        });
//

//        grid.add(new TextField(), 1, 5, 1, 1);
//        grid.add(new Button("Browse..."), 2, 5, 1, 1);

        grid.add(new Label("Coop Host :"), 0, 7, 1, 1);
        grid.add(new TextField(), 1, 7, 1, 1);


        //Text txt2 = new Text("S ");
        //txt2.setFont(Font.font("Dialog", FontWeight.BOLD, 12));

        //grid.add(txt2, 1, 0, 2, 2);


//        grid.add(new Separator(), 0, 6, 3, 1);

//        grid.add(new Label("Students Name:"), 0, 2, 1, 1);
//        grid.add(new TextField(), 1, 2, 1, 1);

//        grid.add(new Label("Cours/Bash/Year:"), 0, 3, 1, 1);
//        grid.add(new TextField(), 1, 3, 1, 1);
//        grid.add(new Button("Browse..."), 2, 3, 1, 1);
//
//        grid.add(new Label("Coop Host :"), 0, 4, 1, 1);
//
//        grid.add(new TextField(), 1, 4, 1, 1);

//
//        grid.add(new Separator(), 0, 5, 3, 1);

        // Coop start and end date selector

        VBox vbox = new VBox(20);

        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(90));

        vbox.getChildren().add(new Label("Start Date:"));
        vbox.getChildren().add(startDatePicker);
        vbox.getChildren().add(new Label("End Date:"));
        vbox.getChildren().add(endDatePicker);



        //Coop Schedule
        grid.add(new Label("Coop placement :"), 0, 8, 1, 1);
        ComboBox<String> cb = new ComboBox<>();
        cb.setPrefWidth(400);
        grid.add(vbox, 1, 8, 1, 1);
//        grid.add(new Button("StartDate/EndDate"), 2, 8, 1, 1);



        //Pre-loader
        grid.add(new CheckBox("Create Custom Pre-loader"), 0, 9, 3, 1);

        //Project Name
        grid.add(new Label("Project Name:"), 0, 10, 1, 1);
        grid.add(new TextField(), 1, 10, 1, 1);

        //separator
        grid.add(new Separator(), 0, 11, 3, 1);

        //Project Name
        grid.add(new Label("WSIB on file:"), 0, 12, 1, 1);
        grid.add(new TextField(), 1, 12, 1, 1);

        grid.add(new Label("Insurance on file:"), 0, 13, 1, 1);
        grid.add(new TextField(), 1, 13, 1, 1);




//Contract signed check box
        grid.add(new CheckBox("contract signed"), 0, 14, 3, 1);



//Contact address
        grid.add(new Label("Contact Address "), 0, 15, 1, 1);
        grid.add(new TextField(), 1, 15, 1, 1);
        grid.add(new Button("Browse..."), 2, 15, 1, 1);
//Contact person text
        grid.add(new Label("Contact Person"),1, 16, 1, 1);
//Work address
        grid.add(new CheckBox("Work Address "), 0, 17, 1, 1);
        grid.add(new TextField(), 1, 17, 1, 1);

//        grid.add(new CheckBox(""), 0, 14, 1, 1);

        //Lower end Buttons FlowPane
        FlowPane fp2 = new FlowPane(Orientation.HORIZONTAL, 20, 20);
        fp2.setAlignment(Pos.CENTER_RIGHT);

        //Save and Print button
        Button btn = new Button("Save and Print");
        fp2.getChildren().addAll(
                btn
        );
        //Search button added
        Button search = new Button("Search");
        fp2.getChildren().addAll(
                search
        );

        //Search button action set
        search.setOnAction(e ->
        {

            FirstName.setText(" First Name " + Fname.getText());
            System.out.println(Fname.getText() + " " + Lname.getText());
            LastName.setText("Last Name " + Lname.getText());
        });

        //Save and Print button action set
        btn.setOnAction(e ->{
            person.setFirstName(Fname.getText());
            person.setLastName(Lname.getText());
            WriteExcelFile.writeExcelFile(person);
            WordGenerator wg = new WordGenerator();

            //VK lines text filename
            String textFilename = "src/main/resources/coop.sft/textFile.txt";

            //Gather VK Lines from text file
            List<String> textFileLines = null;
            try {
                textFileLines = wg.getLines(textFilename);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Create word document according to VK lines
            try {
                wg.createWord(textFileLines);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        grid.add(fp2, 1, 18, 1, 2);

//        grid.add(new Separator(), 3, 19, 1, 1);

        grid.add(new Separator(), 0, 21, 3, 1);

        //Office manager text
        Text txtom = new Text("Office Manager ");
        txtom.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
        grid.add(txtom, 0, 23, 1, 1);

        //Placement coordinator text
        Text txtpc = new Text("Placement Coordinator");
        txtpc.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
        grid.add(txtpc, 2, 23, 1, 1);

        return grid;
    }
}

