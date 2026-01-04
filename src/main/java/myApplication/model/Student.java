package myApplication.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.UUID;

@Document("students")

public class Student {
    @MongoId
    private String studentId = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String addrss;
    private String email;
    private String phoneNumber;
    private LocalDate studentshipDate;
    private LocalDate issuedDate;
    private LocalDate dueDate;
    private boolean isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getMembershipDate() {
        return studentshipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.studentshipDate = studentshipDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddrss() {
        return addrss;
    }

    public void setAddrss(String addrss) {
        this.addrss = addrss;
    }

    public String getMemberId() {
        return studentId;
    }

    public void setMemberId(String memberId) {
        this.studentId= studentId;
    }
}




