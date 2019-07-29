package com.fh.easyexcel.service;

import com.fh.easyexcel.entity.Classes;
import com.fh.easyexcel.entity.Student;
import com.fh.easyexcel.entity.Teacher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEasyExcelService {

    List<Student> getAllStudent();

    List<Teacher> getAllTeacher();

    List<Classes> getAllClasses();

    Integer readStudentSheet(MultipartFile file);

    Integer readMoreDataSheet(MultipartFile file);

    Integer readFixName(MultipartFile file);

    Integer readFixedSheet(MultipartFile file, Integer sheetNum, Integer headLineNum);
}
