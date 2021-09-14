package com.fifthhomework.fifthhomework.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifthhomework.fifthhomework.entity.Instructor;
import com.fifthhomework.fifthhomework.entity.Student;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @ApiModelProperty(hidden = true)
    private long id;

    @NotBlank(message = "Course adı zorunludur.")
    private String courseName;
    @NotBlank (message = "Course adı zorunludur.")
    private String courseCode;
    @NotNull(message = "Credit girilmesi zorunludur.")
    private int creditScore;
    @JsonIgnore
    private Instructor instructor;
    @JsonIgnore
    private List<Student> studentList = new ArrayList<>();

}
