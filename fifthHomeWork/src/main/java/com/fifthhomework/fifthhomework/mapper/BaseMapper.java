package com.fifthhomework.fifthhomework.mapper;


import com.fifthhomework.fifthhomework.dto.StudentDTO;
import com.fifthhomework.fifthhomework.entity.PermanentInstructor;
import com.fifthhomework.fifthhomework.entity.Student;
import com.fifthhomework.fifthhomework.entity.VisitingResearcher;
import com.fifthhomework.fifthhomework.dto.CourseDTO;
import com.fifthhomework.fifthhomework.dto.InstructorDTO;
import com.fifthhomework.fifthhomework.entity.Course;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface BaseMapper {

    @InheritConfiguration(name = "Instructor")
    PermanentInstructor mapToPermanent(InstructorDTO instructorDTO);

    @InheritConfiguration(name = "Instructor")
    VisitingResearcher mapToVisiting(InstructorDTO instructorDTO);

    Student mapperFromStudentDTOSt(StudentDTO studentDTO);

    Course mapperFromCourseDTOtoCr(CourseDTO courseDTO);




}
