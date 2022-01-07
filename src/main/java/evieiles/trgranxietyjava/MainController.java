package evieiles.trgranxietyjava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Element Variables
    @FXML
    private Label chooseLbl;

    @FXML
    private Button assistanceBtn;
    @FXML
    private Button okBtn;

    //DropDown Menu
    @FXML private ChoiceBox<String> trgrList;
    //create array of triggers
    private String[] triggers = {"Social Anxiety", "Interpersonal Relations", "Physical Wellness", "Work Stressors", "School", "Finances"};


    //if assistanceBtn was selected, hide the okBtn
    @FXML
    private void assistanceClick(MouseEvent mouseEvent) {
        okBtn.setDisable(true);
        chooseLbl.setVisible(true);
    }
    //if okBtn was selected, delete assistanceBtn
    @FXML
    private void OkClick(MouseEvent mouseEvent) {
        assistanceBtn.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //on window initilization, hide certain labels until triggered.
//        chooseLbl.setVisible(false);

        //add items to choicebox
        trgrList.getItems().addAll(triggers);
    }
}