package org.upgrad.upstac.testrequests;

import lombok.Data;
import org.upgrad.upstac.testrequests.consultation.Consultation;
import org.upgrad.upstac.testrequests.lab.LabResult;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.models.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class TestRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long requestId;

    @ManyToOne
    private User createdBy;

    private LocalDate created=LocalDate.now();

    private RequestStatus status = RequestStatus.INITIATED;


    private String name;
    private Gender gender;
    private String address;
    private Integer age;
    private String email;
    private String phoneNumber;
    private Integer pinCode;

    @OneToOne(mappedBy="request")
    Consultation consultation;

    @OneToOne(mappedBy="request")
    LabResult labResult;

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public void setLabResult(LabResult labResult) {
        this.labResult = labResult;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RequestStatus getStatus() {
        return this.status;
    }
}
