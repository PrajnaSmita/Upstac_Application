package org.upgrad.upstac.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.upgrad.upstac.users.models.Gender;
import org.upgrad.upstac.users.models.AccountStatus;
import org.upgrad.upstac.users.roles.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column
    @JsonIgnore
    @ToString.Exclude
    private String password;

    private LocalDateTime created;

    private LocalDate dateOfBirth;


    private LocalDateTime updated;

    private String firstName;

    private AccountStatus status;

    @Column(unique = true)
    private String email;


    private String lastName;


    private Gender gender;

    @Column(unique = true)
    private String phoneNumber;
    private String address;

    private Integer pinCode;

    //CascadeType.PERSIST has issues with many to many which makes us not use CascadeType.ALL
    //So Using  other Cascades other than CascadeType.PERSIST
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
//    @JoinTable(name = "USER_ROLES", joinColumns = {
//            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
//            @JoinColumn(name = "ROLE_ID") })
//    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    public boolean doesRoleIsDoctor() {

        return doesUserHasRole("DOCTOR");


    }

    public boolean doesUserHasRole(String s) {
        return roles.stream()
                .filter(role -> {
                    return role.getName().equalsIgnoreCase(s);
                })
                .findFirst()
                .isPresent();
    }

    public boolean doesRoleIsUser() {
        return doesUserHasRole("USER");
    }

    public boolean doesRoleIsAuthority() {
        return doesUserHasRole("GOVERNMENT_AUTHORITY");
    }

    public boolean doesRoleIsTester() {
        return doesUserHasRole("TESTER");
    }

    public Integer getAge(){

        if(null != dateOfBirth)
            return LocalDate.now().getYear() - dateOfBirth.getYear();
        else
            return 0;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountStatus getStatus() {
        return this.status;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}
