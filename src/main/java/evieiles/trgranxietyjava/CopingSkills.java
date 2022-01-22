package evieiles.trgranxietyjava;

public class CopingSkills {
    public String skillName;
    public String skillDescription;
    public String skillType;

    //constructor
    public CopingSkills(String skillName, String skillDescription, String skillType) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.skillType = skillType;
    }

    //setters
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    //getters
    public String getSkillName() {
        return skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public String getSkillType() {
        return skillType;
    }



}
