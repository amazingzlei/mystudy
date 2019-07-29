package com.fh.easyexcel.service.impl;

import com.fh.easyexcel.entity.Classes;
import com.fh.easyexcel.entity.Student;
import com.fh.easyexcel.entity.Teacher;
import com.fh.easyexcel.excel.ExcelUtil;
import com.fh.easyexcel.service.IEasyExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EasyExcelServiceImpl implements IEasyExcelService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAllStudent() {
        String sql = "SELECT * FROM student";
        RowMapper rowMapper = new BeanPropertyRowMapper(Student.class);
        List<Student> students = jdbcTemplate.query(sql, rowMapper);
        return students;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        String sql = "SELECT * FROM teacher";
        RowMapper rowMapper = new BeanPropertyRowMapper(Teacher.class);
        List<Teacher> teachers = jdbcTemplate.query(sql, rowMapper);
        return teachers;
    }

    @Override
    public List<Classes> getAllClasses() {
        String sql = "SELECT * FROM class";
        RowMapper rowMapper = new BeanPropertyRowMapper(Classes.class);
        List<Classes> classes = jdbcTemplate.query(sql, rowMapper);
        return classes;
    }

    /**
     * 只有一个sheet页的上传
     * @param file
     * @return
     */
    @Override
    public Integer readStudentSheet(MultipartFile file) {
        List<Object> students = ExcelUtil.readExcel(file, new Student());
        int count = 0;
        if(!CollectionUtils.isEmpty(students)){
            for (Object obj:students
                    ) {
                Student student = (Student) obj;
                String sql = "INSERT INTO student values(?,?,?,?,?)";
                count += jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSex(),
                        student.getAddress(), student.getPhone());
            }
            if(count == students.size()){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    /**
     * 多个sheet页上传，每一个sheet数据不一样
     * @param file
     * @return
     */
    @Override
    public Integer readMoreDataSheet(MultipartFile file) {
        List<Object> students = ExcelUtil.readExcel(file, new Student(), 1);
        List<Object> teachers = ExcelUtil.readExcel(file, new Teacher(), 2);
        List<Object> classes = ExcelUtil.readExcel(file, new Classes(), 3);
        int count = 0;
        if(!CollectionUtils.isEmpty(students)){
            for (Object obj:students
                    ) {
                Student student = (Student) obj;
                String sql = "INSERT INTO student values(?,?,?,?,?)";
                count += jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSex(),
                        student.getAddress(), student.getPhone());
            }

        }

        if(!CollectionUtils.isEmpty(teachers)){
            for (Object obj:teachers
                    ) {
                Teacher teacher = (Teacher) obj;
                String sql = "INSERT INTO teacher values(?,?,?,?,?)";
                count += jdbcTemplate.update(sql, teacher.getName(), teacher.getNumber(), teacher.getAge(),
                        teacher.getSex(), teacher.getPhone());
            }

        }

        if(!CollectionUtils.isEmpty(classes)){
            for (Object obj:classes
                    ) {
                Classes classes1 = (Classes) obj;
                String sql = "INSERT INTO class values(?,?,?)";
                count += jdbcTemplate.update(sql, classes1.getName(), classes1.getTeacher(), classes1.getAddress());
            }

        }

        if(count == (students.size()+teachers.size()+classes.size())){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 读取叫李四的学生信息
     * @param file
     * @return
     */
    @Override
    public Integer readFixName(MultipartFile file) {
        List<Object> students = ExcelUtil.readFixedNameExcel(file, new Student());
        int count = 0;
        if(!CollectionUtils.isEmpty(students)){
            for (Object obj:students
                    ) {
                Student student = (Student) obj;
                String sql = "INSERT INTO student values(?,?,?,?,?)";
                count += jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSex(),
                        student.getAddress(), student.getPhone());
            }
            if(count == students.size()){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    /**
     * 导入指定sheet页和指定行
     * @param file
     * @param sheetNum
     * @param headLineNum
     * @return
     */
    @Override
    public Integer readFixedSheet(MultipartFile file, Integer sheetNum, Integer headLineNum) {
        List<Object> students = ExcelUtil.readExcel(file, new Student(), sheetNum, headLineNum);
        int count = 0;
        if(!CollectionUtils.isEmpty(students)){
            for (Object obj:students
                    ) {
                Student student = (Student) obj;
                String sql = "INSERT INTO student values(?,?,?,?,?)";
                count += jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSex(),
                        student.getAddress(), student.getPhone());
            }
            if(count == students.size()){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
}
