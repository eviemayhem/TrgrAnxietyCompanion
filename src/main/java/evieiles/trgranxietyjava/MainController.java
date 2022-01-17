package evieiles.trgranxietyjava;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;

public class MainController implements Initializable {
    //Element Variables
    @FXML private Label chooseLbl;
    @FXML private Button assistanceBtn;
    @FXML private Button refuseBtn;
    @FXML private Pane initiatePane;
    @FXML private Slider dangerAssess;
    @FXML private Pane successPane;
    @FXML private Label eventLoggedText;

    @FXML private Button ySkill;
    @FXML private Button noSkill;
    @FXML private Label skillLabel;
    @FXML private CheckBox artBox;
    @FXML private CheckBox distractBox;
    @FXML private CheckBox physBox;
    @FXML private CheckBox cbtBox;

    @FXML private Label tryLbl;
    @FXML private ChoiceBox<String> skillChoice;
    //DropDown Menu
    @FXML private ChoiceBox<String> trgrList;
    @FXML private Label compassionText;

    @FXML private Button checkYes;
    @FXML private Button  checkNo;

    @FXML private Button skillSuccess;
    @FXML private Button skillFail;
    @FXML private Label retryText;
    @FXML private ImageView companionHolder;
    @FXML private ImageView bubbleHolder;
//    @FXML private Timer followUpTimer;
    @FXML private Button suggestSkillBtn;

    //Organizational panes for hiding visibility
    @FXML private Pane assessmentPane;
    @FXML private Pane triggerPane;
    @FXML private Pane csOfferPane;
    @FXML private Pane preferencePane;
    @FXML private Pane csChoosePane;
    @FXML private Pane followUpPane;


    //Companion Phases

    @FXML Image companionHappy = new Image("happy.png");
  Image companionContent = new Image ("companionContent.png");
  Image upset = new Image ("upset.png");
  Image worried = new Image ("compOhNo.png");
 Image thoughtBubble = new Image ("thoughtBubble.png");

    //create array of triggers
    private String[] triggers = {"Social Anxiety", "Interpersonal Relations", "Physical Wellness", "Work Stressors", "School", "Finances"};
    // creates arrays for coping skill options to use to populate depending on checkboxes selected
    private String[] artSkills = {"Drawing from Life", "Recreate your favorite piece of art", "Virtual Art Gallery" };
    private String[] distractskills = {"Dumb Dad Jokes","Heat/Cold therapy", "Audio therapy", "Cleaning", "Repetitive Motion"};
    private String[] physSkills = {"Heat/Cold Therapy", "Go for a run/Walk", "Yoga", "Hygiene Self-Care"};
    private String[] cbtSkills = {"Cognitive Restructuring", "Guided Discorvery", "Thought Recording", "Activity Scheduling"};

    //Initiate log
    Date date = new Date();
    TriggerLog triggerLog = new TriggerLog(date);


    //if assistanceBtn was selected, disable ok btn
    @FXML
    private void initiateAssistance(MouseEvent mouseEvent) {
        initiatePane.setVisible(false);
        companionHolder.setImage(worried);
        compassionText.setText("I am sorry you are currently experiencing distress. I am here to help.\n On a scale of 1-5, how distressed are you?");
        assessmentPane.setVisible(true);
        System.out.print(triggerLog.getDate());

    }

    //Returns value of danger assessment slider
    @FXML
    private void dangerAssessment(MouseEvent mouseEvent){
        System.out.print("\n current danger level: " + dangerAssess.getValue());
        triggerLog.setDangerScore((int) dangerAssess.getValue());

        //If danger value is > 4, show pop-up with advice to contact doctor
        if (dangerAssess.getValue() > 4){
            compassionText.setText("Due to the severity of your distress, we highly recommend reaching out to your treatment team.");
            companionHolder.setImage(upset);
        }
        else{
            compassionText.setText("Do you think you can pinpoint what is bothering you?");
           triggerPane.setVisible(true);
           dangerAssess.setVisible(false);

        }
    }

    @FXML
    private void triggerSelection(MouseEvent mouseEvent) {
        trgrList.getValue();
        triggerLog.setTrigger(trgrList.getValue());
        System.out.println("\n Trigger Selected: " + trgrList.getValue());
        System.out.print("Submit button clicked.");
        triggerPane.setVisible(false);
        csOfferPane.setVisible(true);
        compassionText.setText("I see...so you are dealing with " + trgrList.getValue() + ".\n I'm sure that must be tough.\nIf you'd like, I could provide a few skills to try to help you calm down."); //Change companion text
    }
//Offer Coping Skill
    private void skillAccept(MouseEvent mouseEvent){
        csOfferPane.setVisible(false);
        compassionText.setText("Excellent!\nBefore we get started, please select the type of self care you enjoy.");
    }

    //if refuseBtn was selected, delete assistanceBtn
    @FXML
    private void refuseAssistance(MouseEvent mouseEvent) {
        initiatePane.setVisible(false);
        compassionText.setText("I'm glad to hear you are feeling healthy today!\nPlease let me know if you need further assistance.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //on window initilization, hide certain labels until triggered.
        companionHolder.setImage(companionHappy);
        bubbleHolder.setImage(thoughtBubble);
        assessmentPane.setVisible(false);
        triggerPane.setVisible(false);
        csOfferPane.setVisible(false);
        preferencePane.setVisible(false);
        csChoosePane.setVisible(false);
        followUpPane.setVisible(false);
        successPane.setVisible(false);


        //add items to choicebox
        trgrList.getItems().addAll(triggers);
    }


}