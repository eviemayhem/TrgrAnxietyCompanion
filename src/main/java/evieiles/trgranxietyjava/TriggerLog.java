package evieiles.trgranxietyjava;

import java.util.Date;

public class TriggerLog {
    public Date date;
    public int dangerScore;
    public String trigger;
    public String skillPreference;
    public String skillSelection;
    public Boolean skillSuccess;
    public String journalEntry;

    //constructors
    public TriggerLog(){
        this.date = new Date();
        this.dangerScore = 0;
        this.trigger = "";
        this.skillPreference = "";
        this.skillSelection = "";
        this.skillSuccess = true;
        this.journalEntry = "";
    }
    public TriggerLog(Date date){
        this.date = date;
    }

    //setters
    public void setDate(Date date){
        this.date = date;
    }
    public void setDangerScore(int dangerScore){
        this.dangerScore = dangerScore;
    }
    public void setTrigger(String trigger){
        this.trigger = trigger;
    }
    public void setSkillPreference(String skillPreference){
        this.skillPreference = skillPreference;
    }
    public void setSkillSelection(String skillSelection){
        this.skillSelection = skillSelection;
    }
    public void setSkillSuccess(Boolean skillSuccess){
        this.skillSuccess = skillSuccess;
    }
    public void setJournalEntry(String journalEntry){
        this.journalEntry = journalEntry;
    }
    //getters
    public Date getDate(){
        return this.date;
    }
    public int getDangerScore(){
        return this.dangerScore;
    }
    public String getTrigger(){
        return this.trigger;
    }
    public String getSkillPreference(){
        return this.skillPreference;
    }
    public String getSkillSelection(){
        return this.skillSelection;
    }
    public Boolean getSkillSuccess(){
        return this.skillSuccess;
    }
    public String getJournalEntry(){
        return this.journalEntry;
    }
}
