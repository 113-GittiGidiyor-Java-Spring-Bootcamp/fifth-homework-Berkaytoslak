package com.fifthhomework.fifthhomework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor"), @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher")})
public class Instructor extends BasePerson {
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();
}
