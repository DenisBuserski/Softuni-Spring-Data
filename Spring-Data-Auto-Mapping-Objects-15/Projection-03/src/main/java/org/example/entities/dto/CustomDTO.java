package org.example.entities.dto;

public class CustomDTO {
    private String firstName;
    private String lastName;
    private int mangerLastNameLength;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMangerLastNameLength() {
        return mangerLastNameLength;
    }

    public void setMangerLastNameLength(int mangerLastNameLength) {
        this.mangerLastNameLength = mangerLastNameLength;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mangerLastNameLength=" + mangerLastNameLength +
                '}';
    }
}
