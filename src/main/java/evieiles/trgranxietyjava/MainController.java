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
    //distraction skills
    CopingSkills distraction = new CopingSkills("Dumb Dad Joke", "What do you call a witch who lives at the beach?\nA sand witch.", "Distraction.");
    //art Skills
    CopingSkills art = new CopingSkills("Drawing From Life", "Pick an object from your life and draw it.", "Art");
    //Physical
    CopingSkills physical = new CopingSkills("Hot/Cold Therapy", "Hold a hot cup of tea or maybe hold an icecube.", "Physical");
    //CBT
    CopingSkills cbt = new CopingSkills("Cognitive Restructuring", "IDK my bff jill", "Cbt");


    //Element Variables
    @FXML private Pane initiatePane;
    @FXML private Slider dangerAssess;
    @FXML private Pane successPane;
    @FXML private CheckBox artBox;
    @FXML private CheckBox distractBox;
    @FXML private CheckBox physBox;
    @FXML private CheckBox cbtBox;

 //ChoiceBoxes
    @FXML private ChoiceBox<String> skillChoice;
    @FXML private ChoiceBox<String> trgrList;
    @FXML private Label compassionText;
    @FXML private ImageView companionHolder;
    @FXML private ImageView bubbleHolder;
//    @FXML private Timer followUpTimer;

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
    private String[] artSkills = {"Drawing from Life"};
    private String[] distractskills = {"Dumb Dad Jokes"};
    private String[] physSkills = {"Heat/Cold Therapy"};
    private String[] cbtSkills = {"Cognitive Restructuring"};

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

    //Allows user to select a trigger
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

    //Offers the user Coping Skill
    @FXML
    private void skillAccept(MouseEvent mouseEvent){
        companionHolder.setImage(companionContent);
        csOfferPane.setVisible(false);
        compassionText.setText("Excellent!\nBefore we get started, please select the type of self care you enjoy.");
        preferencePane.setVisible(true);

    }

    //Determine coping skills preferences
    @FXML
    private void preferenceSelect(MouseEvent mouseEvent){
        if (distractBox.isSelected()){
            skillChoice.getItems().addAll(distractskills);
            triggerLog.setSkillPreference("Distraction");
            compassionText.setText("I see that you like to distract yourself when you're upset.\n Let's see what we have in our toolbox.");
            csChoosePane.setVisible(true);
        }
        else if (artBox.isSelected()){
            skillChoice.getItems().addAll(artSkills);
            triggerLog.setSkillPreference("Art");
            compassionText.setText("I see that you like to create art.\n Let's see what we have in our toolbox.");
            csChoosePane.setVisible(true);
        }
        else if (physBox.isSelected()){
            skillChoice.getItems().addAll(physSkills);
            triggerLog.setSkillPreference("Physical");
            compassionText.setText("I see that you like to be physical.\n Let's see what we have in our toolbox.");
            csChoosePane.setVisible(true);
        }
        else if (cbtBox.isSelected()){
            triggerLog.setSkillPreference("CBT");
            skillChoice.getItems().addAll(cbtSkills);
            compassionText.setText("I see that you enjoy CBT.\n Let's see what we have in our toolbox.");
            csChoosePane.setVisible(true);
        }
        else{
            compassionText.setText("Please select a preference type. You can select more than one.");
        }
    }

    //Choose Skill and change description
    @FXML
    private void skillSelection(MouseEvent mouseEvent){
        triggerLog.setSkillSelection(skillChoice.getValue());
        if (skillChoice.getValue() == "Distraction"){
            compassionText.setText(distraction.skillDescription);
        }
        else if (skillChoice.getValue() == "Art"){
            compassionText.setText(art.skillDescription);
        }
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