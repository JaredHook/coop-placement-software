package coop.sft;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class PopUpWindow {


    protected void handleSubmitButtonAction(TextField textField1, TextField textField2, Button submit ){

        Window owner = submit.getScene().getWindow();
        if(textField1.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner,"Form Error!",
                    "Please enter your name");
            return;
        }

        if(textField2.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner,"Form Error!",
                    "Please enter last name");
            return;
        }

        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Confirmation Box",
                "Submitted and Printed Successfully");

    }




}
