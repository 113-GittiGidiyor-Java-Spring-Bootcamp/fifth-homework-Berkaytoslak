package com.fifthhomework.fifthhomework.service;


import com.fifthhomework.fifthhomework.entity.ExceptionLogger;
import com.fifthhomework.fifthhomework.repository.LoggerRepository;
import com.fifthhomework.fifthhomework.util.Formatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExceptionService {

    private final LoggerRepository loggerRepository;


    public List<ExceptionLogger> getAll() {
        return (List<ExceptionLogger>) loggerRepository.findAll();
    }

    public List<ExceptionLogger> getCourseAlreadyExistExceptions(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Course daha önce oluşturuldu.");
    }

    public List<ExceptionLogger> getInstructorAlreadyExistExceptions(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Instructor daha önce oluşturuldu");
    }
    public List<ExceptionLogger> getStudentAgeNotValidExceptions(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Student yaş aralığı 18 - 40 olmalıdır.");
    }
    public List<ExceptionLogger> getStudentNumberForOneCourseExceededException(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Maximum 20 öğrenci olabilir.");
    }

    public List<ExceptionLogger> getExceptionsByDate(String date){
        LocalDate localDate = Formatter.convertStringToLocalDate(date);
        return loggerRepository.findExceptionTransactionLoggerByLocalDateAfter(localDate);
    }

}
