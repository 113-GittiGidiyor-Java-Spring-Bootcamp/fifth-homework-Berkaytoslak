package com.fifthhomework.fifthhomework.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifthhomework.fifthhomework.entity.Course;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @ApiModelProperty(hidden = true)
    private long id;

    @NotBlank(message = "İsim zorunludur.")
    private String name;
    private String address;

    @ApiModelProperty(example = "yyyy-mm-dd")
    @NotNull(message = "Doğum günü zorunludur.")
    private String birthDate;

    @NotBlank(message = "Cinsiyet girilmesi zorunludur.")
    private String gender;
    @JsonIgnore
    private List<Course> courseList;

}
