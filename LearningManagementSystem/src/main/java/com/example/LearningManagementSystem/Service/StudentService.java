package com.example.LearningManagementSystem.Service;

import com.example.LearningManagementSystem.DTO.StudentDTO;
import com.example.LearningManagementSystem.DTO.StudentProfileDTO;
import com.example.LearningManagementSystem.Entity.Student;
import com.example.LearningManagementSystem.Entity.StudentProfile;
import com.example.LearningManagementSystem.Exception.StudentNotFoundException;
import com.example.LearningManagementSystem.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    public List<StudentProfileDTO> getAllStudents(){
        List<Student> students=studentRepo.findAll();
        List<StudentProfileDTO> studentProfileDTOS=new ArrayList<>();
        for(Student student:students){
           studentProfileDTOS.add(convertToStudentDTO(student));
        }
        return studentProfileDTOS;
    }

    private StudentProfileDTO convertToStudentDTO(Student student){
        StudentProfileDTO studentProfileDTO=new StudentProfileDTO();
        studentProfileDTO.setStudentId(student.getStudentId());
        studentProfileDTO.setName(student.getName());
        studentProfileDTO.setEmail(student.getEmail());
        studentProfileDTO.setPhoneNumber(student.getPhoneNumber());
        if(student.getProfile()!=null){
            studentProfileDTO.setAddress(student.getProfile().getAddress());
            studentProfileDTO.setDateOfBirth(student.getProfile().getDateOfBirth());
            studentProfileDTO.setEducation(student.getProfile().getEducation());
        }
        return studentProfileDTO;
    }

    public StudentProfileDTO addStudent(Student student){
        StudentProfile studentProfile=student.getProfile();
        if(studentProfile!=null){
            studentProfile.setStudent(student);
        }
        Student savedStudent=studentRepo.save(student);
        return convertToStudentDTO(savedStudent);
    }

    public void deleteStudent(long id) {
        Student student=studentRepo.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Studnet with id:"+id+" not found"));
        studentRepo.delete(student);
    }
}
