package vn.edu.eiu.testlab;

public enum Gender {
    MALE("Nam"),
    FEMALE("Nữ"),
    OTHER("Khác");

    private final String displayName;
    Gender(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }


}
