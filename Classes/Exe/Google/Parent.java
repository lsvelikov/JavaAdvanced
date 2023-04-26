package JavaAdvanced.Classes.Exe.Google;

public class Parent {
    private String parentsName;
    private String parentsBirthday;

    public Parent(String parentsName, String parentsBirthday) {
        this.parentsName = parentsName;
        this.parentsBirthday = parentsBirthday;
    }

    @Override
    public String toString() {
        return parentsName + " " + parentsBirthday;
    }
}
