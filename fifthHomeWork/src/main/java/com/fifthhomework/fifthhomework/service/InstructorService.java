package com.fifthhomework.fifthhomework.service;



import com.fifthhomework.fifthhomework.dto.InstructorDTO;
import com.fifthhomework.fifthhomework.entity.Instructor;
import com.fifthhomework.fifthhomework.exception.InstructorIsAlreadyExistException;
import com.fifthhomework.fifthhomework.mapper.BaseMapper;
import com.fifthhomework.fifthhomework.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final BaseMapper baseMapper;


    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        instructorRepository.findAll().forEach(instructorList::add);
        return instructorList;
    }

    public Instructor findById(long id) {
        return instructorRepository.findById(id).get();
    }

    public Instructor save(InstructorDTO instructorDTO) {

        if (instructorRepository.existsByPhoneNumber(instructorDTO.getPhoneNumber())){
            throw new InstructorIsAlreadyExistException();
        }

        Instructor instructor = null;
        if (instructorDTO.getType().equals("PermanentInstructor")){
            instructor = baseMapper.mapToPermanent(instructorDTO);
        }
        if (instructorDTO.getType().equals("VisitingResearcher")){
            instructor = baseMapper.mapToVisiting(instructorDTO);
        }
        return instructor==null? null:instructorRepository.save(instructor);
    }

    public Instructor update(InstructorDTO instructorDTO) {
        return save(instructorDTO);
    }

    public void deleteById(long id) {
        instructorRepository.deleteById(id);
    }

    public void deleteByObject(InstructorDTO instructorDTO) {
        long id = instructorDTO.getId();
        deleteById(id);
    }

    public List<Instructor> findIncludeName(String name) {
        return instructorRepository.findByNameContains(name);
    }

    public void deleteByName(String name) {
        instructorRepository.deleteInstructorByName(name);
    }

}
