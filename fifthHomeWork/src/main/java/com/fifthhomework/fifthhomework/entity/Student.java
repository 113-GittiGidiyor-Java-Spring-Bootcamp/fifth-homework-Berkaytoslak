package com.fifthhomework.fifthhomework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BasePerson {
    private String birthDate;
    private String gender;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();

    public Student(String name, String address, String birthDate, String gender) {
        setName(name);
        setAddress(address);
        setBirthDate(birthDate);
        setGender(gender);
    }

}
