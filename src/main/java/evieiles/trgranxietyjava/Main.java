package evieiles.trgranxietyjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();

        //create class to hold triggers
        class Triggers{
            public String triggerName;
            public String triggerDescription;
            public String triggerType;

            //constructor
            public Triggers(String triggerName, String triggerDescription, String triggerType){
                this.triggerName = triggerName;
                this.triggerDescription = triggerDescription;
                this.triggerType = triggerType;
            }

            //setters
            public void setTriggerName(String triggerName){
                this.triggerName = triggerName;
            }
            public void setTriggerDescription(String triggerDescription){
                this.triggerDescription = triggerDescription;
            }
            public void setTriggerType(String triggerType){
                this.triggerType = triggerType;
            }

            //getters
            public String getTriggerName(){
                return triggerName;
            }
            public String getTriggerDescription(){
                return triggerDescription;
            }
            public String getTriggerType(){
                return triggerType;
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}