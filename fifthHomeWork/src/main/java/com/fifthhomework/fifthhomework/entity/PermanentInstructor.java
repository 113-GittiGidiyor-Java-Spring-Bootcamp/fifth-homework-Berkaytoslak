package com.fifthhomework.fifthhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermanentInstructor extends Instructor {
    private double fixedSalary;


}
