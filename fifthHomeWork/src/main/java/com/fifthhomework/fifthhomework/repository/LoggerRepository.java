package com.fifthhomework.fifthhomework.repository;

import com.fifthhomework.fifthhomework.entity.ExceptionLogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoggerRepository extends CrudRepository<ExceptionLogger,Long> {

    List<ExceptionLogger> findExceptionTransactionLoggerByMessage(String message);
    List<ExceptionLogger> findExceptionTransactionLoggerByLocalDateAfter(LocalDate localDate);

}
