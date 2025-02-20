package com.spring.web.service;

import com.spring.web.entity.Student;
import com.spring.web.model.StudentDto;
import com.spring.web.repository.StudentRepository;
import com.spring.web.exception.StudentNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository,
                          ModelMapper modelMapper){
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public List<StudentDto> getStudents(){
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    public Optional<StudentDto> getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        return Optional.of(modelMapper.map(student, StudentDto.class));
    }

    public StudentDto saveStudent(StudentDto studentDto){
        Student student = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return modelMapper.map(student, StudentDto.class);
    }

    public String deleteStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return "Student has been deleted";
        }else{
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setMobile(studentDto.getMobile());
        student.setGender(studentDto.getGender());
        student.setAge(studentDto.getAge());
        student.setNationality(studentDto.getNationality());
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }
}
