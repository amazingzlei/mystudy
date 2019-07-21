package com.fh.vue.service;

import com.fh.vue.domain.*;

import java.util.List;

public interface ICarService {
    List<Car> getCars();

    List<Teacher> getTeacher();

    List<Student> getStudent();

    Integer addCar(Car car);

    Integer delCar(Car car);

    List<Img> getImg();

    List<NewList> getNewList();

    NewInfo getNewInfo(String id);

    List<Comment> getComments(int id);

    Integer adComment(Comment comment);

    List<Type> getType();

    List<Img> getImgListById(String id);

    PhotoInfo getPhotoInfo(String id);

}
