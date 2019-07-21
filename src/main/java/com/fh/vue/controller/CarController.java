package com.fh.vue.controller;

import com.fh.vue.common.HttpUtils;
import com.fh.vue.common.ResultVo;
import com.fh.vue.domain.Car;
import com.fh.vue.domain.Comment;
import com.fh.vue.domain.Img;
import com.fh.vue.service.ICarService;
import com.fh.vue.utils.ResultVoUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("vue")
public class CarController {
    @Autowired
    private ICarService iCarService;

    @RequestMapping("getCar")
    @ResponseBody
    public ResultVo getCar(){
        return ResultVoUtil.success(iCarService.getCars());
    }

    @RequestMapping(value = "getStudent",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getStudent(){
        return ResultVoUtil.success(iCarService.getStudent());
    }

    @RequestMapping(value = "getTeacher",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getTeacher(){
        return ResultVoUtil.success(iCarService.getTeacher());
    }

    @RequestMapping(value = "addCar",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addCar(@RequestBody Car car){
        return ResultVoUtil.success(iCarService.addCar(car));
    }

    @RequestMapping(value = "delCar",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo delCar(Car car){
        return ResultVoUtil.success(iCarService.delCar(car));
    }

    @RequestMapping(value = "getImg",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getImg(){
        return ResultVoUtil.success(iCarService.getImg());
    }

    @RequestMapping(value = "getNewList",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getNewList(){
        return ResultVoUtil.success(iCarService.getNewList());
    }

    @RequestMapping(value = "getNewInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getNewInfo(String id){
        return ResultVoUtil.success(iCarService.getNewInfo(id));
    }

    @RequestMapping(value = "getComments",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getComments(int id){
        return ResultVoUtil.success(iCarService.getComments(id));
    }

    @RequestMapping(value = "addComment",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo adComment(@RequestBody Comment comment){
        return ResultVoUtil.success(iCarService.adComment(comment));
    }

    @RequestMapping(value = "getType",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getType(){
        return ResultVoUtil.success(iCarService.getType());
    }

    @RequestMapping(value = "getImgListById",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getImgListById(String id){
        return ResultVoUtil.success(iCarService.getImgListById(id));
    }

    @RequestMapping(value = "getPhotoInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getPhotoInfo(String id){
        return ResultVoUtil.success(iCarService.getPhotoInfo(id));
    }
}
