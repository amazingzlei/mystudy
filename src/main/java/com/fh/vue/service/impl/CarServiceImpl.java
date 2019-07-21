package com.fh.vue.service.impl;

import com.fh.vue.domain.*;
import com.fh.vue.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Car> getCars() {
        String sql = "SELECT * FROM car";
        RowMapper rowMapper = new BeanPropertyRowMapper(Car.class);
        List<Car> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public List<Teacher> getTeacher() {
        String sql = "SELECT * FROM teacher";
        RowMapper rowMapper = new BeanPropertyRowMapper(Teacher.class);
        List<Teacher> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public List<Student> getStudent() {
        String sql = "SELECT * FROM student";
        RowMapper rowMapper = new BeanPropertyRowMapper(Student.class);
        List<Student> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public Integer addCar(Car car) {
        String sql = "INSERT INTO car(name,price) VALUES(?,?)";
        return jdbcTemplate.update(sql, car.getName(),"30w");
    }

    @Override
    public Integer delCar(Car car) {
        String sql = "DELETE FROM car WHERE id = ?";
        return jdbcTemplate.update(sql, car.getId());
    }

    @Override
    public List<Img> getImg() {
        String sql = "SELECT * FROM img limit 0,3";
        RowMapper rowMapper = new BeanPropertyRowMapper(Img.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<NewList> getNewList() {
        String sql = "SELECT * FROM newList";
        RowMapper rowMapper = new BeanPropertyRowMapper(NewList.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public NewInfo getNewInfo(String id) {
        String sql = "SELECT * FROM newInfo where id=?";
        RowMapper rowMapper = new BeanPropertyRowMapper(NewInfo.class);
        return (NewInfo)jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    @Override
    public List<Comment> getComments(int id) {
        String sql = "SELECT * FROM comment limit ?,?";
        RowMapper rowMapper = new BeanPropertyRowMapper(Comment.class);
        return jdbcTemplate.query(sql, rowMapper,(id-1)*5,5);
    }

    @Override
    public Integer adComment(Comment comment) {
        String sql = "insert into comment (name,time,content) values(?,?,?)";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return jdbcTemplate.update(sql,"匿名用户",sdf.format(date),comment.getContent());
    }

    @Override
    public List<Type> getType() {
        String sql = "SELECT * FROM type";
        RowMapper rowMapper = new BeanPropertyRowMapper(Type.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Img> getImgListById(String id) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM img");
        RowMapper rowMapper = new BeanPropertyRowMapper(Img.class);
        if(!id.equals("0")){
            sb.append(" WHERE type = ?");
            return jdbcTemplate.query(sb.toString(), rowMapper,id);
        }else{
            return jdbcTemplate.query(sb.toString(), rowMapper);
        }
    }

    @Override
    public PhotoInfo getPhotoInfo(String id) {
        String sql = "SELECT * FROM photoinfo where id = 1";
        RowMapper rowMapper = new BeanPropertyRowMapper(PhotoInfo.class);
        return (PhotoInfo)jdbcTemplate.queryForObject(sql,rowMapper);
    }
}
