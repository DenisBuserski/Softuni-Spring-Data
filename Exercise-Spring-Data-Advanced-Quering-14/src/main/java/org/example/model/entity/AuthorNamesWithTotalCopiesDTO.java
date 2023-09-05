package org.example.model.entity;

public class AuthorNamesWithTotalCopiesDTO {
    private String firstName;
    private String lastName;
    private long copies;

    public AuthorNamesWithTotalCopiesDTO(String firstName, String lastName, long copies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.copies = copies;
    }

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

    public long getCopies() {
        return copies;
    }

    public void setCopies(long copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + copies;
    }
}
