package org.upgrad.upstac.testrequests;

import lombok.Data;
import org.upgrad.upstac.users.models.Gender;

import javax.validation.constraints.NotNull;

@Data

public class CreateTestRequest {



    private String name;
    private Gender gender;
    private String address;
    private Integer age;

    private String email;

    private String phoneNumber;


    private Integer pinCode;


    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Integer getPinCode() {
        return this.pinCode;
    }

    public String getAddress() {
        return this.address;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
