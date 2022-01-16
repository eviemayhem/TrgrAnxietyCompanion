package evieiles.trgranxietyjava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

public class MainController implements Initializable {
    //Element Variables
    @FXML private Label chooseLbl;
    @FXML private Button assistanceBtn;
    @FXML private Button okBtn;
    @FXML private Label dangerText;
    @FXML private Slider dangerAssess;
    @FXML private Label copingSkillSuggest;
    @FXML private Button ySkill;
    @FXML private Button noSkill;
    @FXML private Label skillLabel;
    @FXML private CheckBox artBox;
    @FXML private CheckBox distractBox;
    @FXML private CheckBox physBox;
    @FXML private CheckBox cbtBox;
    @FXML private Label skillProcessingText;
    @FXML private Label tryLbl;
    @FXML private ChoiceBox<String> skillChoice;
    //DropDown Menu
    @FXML private ChoiceBox<String> trgrList;
    @FXML private Label compassionText;
    @FXML private Label skillAcceptText;
    @FXML private Button checkYes;
    @FXML private Button  checkNo;
    @FXML private Label skillDescText;
    @FXML private Label followUpText;
    @FXML private Button skillSuccess;
    @FXML private Button skillFail;
    @FXML private Label retryText;
    @FXML private Label eventLoggedText;
    @FXML private ImageView companionImg;
//    @FXML private Timer followUpTimer;
    @FXML private Button suggestSkillBtn;

    //Organizational panes for hiding visibility
    @FXML private Pane assessmentPane;
    @FXML private Pane triggerPane;
    @FXML private Pane csOfferPane;
    @FXML private Pane preferencePane;
    @FXML private Pane csChoosePane;
    @FXML private Pane followUpPane;
    @FXML private Pane companionPane;

    //create array of triggers
    private String[] triggers = {"Social Anxiety", "Interpersonal Relations", "Physical Wellness", "Work Stressors", "School", "Finances"};
    // creates arrays for coping skill options to use to populate depending on checkboxes selected
    private String[] artSkills = {"Drawing from Life", "Recreate your favorite piece of art", "Virtual Art Gallery" };
    private String[] distractskills = {"Dumb Dad Jokes","Heat/Cold therapy", "Audio therapy", "Cleaning", "Repetitive Motion"};
    private String[] physSkills = {"Heat/Cold Therapy", "Go for a run/Walk", "Yoga", "Hygiene Self-Care"};
    private String[] cbtSkills = {"Cognitive Restructuring", "Guided Discorvery", "Thought Recording", "Activity Scheduling"};



    //if assistanceBtn was selected, disable ok btn
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
        chooseLbl.setVisible(false);
        assessmentPane.setVisible(false);
        triggerPane.setVisible(false);
        csOfferPane.setVisible(false);
        preferencePane.setVisible(false);
        csChoosePane.setVisible(false);
        followUpPane.setVisible(false);


        //add items to choicebox
        trgrList.getItems().addAll(triggers);
    }
}