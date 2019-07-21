package com.fh.easyexcel.controller;

import com.fh.easyexcel.entity.Classes;
import com.fh.easyexcel.entity.Student;
import com.fh.easyexcel.entity.Teacher;
import com.fh.easyexcel.excel.ExcelUtil;
import com.fh.easyexcel.service.IEasyExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "easyexcel")
public class EasyExcelController {

    @Autowired
    private IEasyExcelService iEasyExcelService;

    /**
     * 导出一个sheet页
     * @param response
     */
    @RequestMapping(value = "getOneSheet")
    public void writeExcel(HttpServletResponse response){
        List<Student> list = iEasyExcelService.getAllStudent();
        String fileName = "学生表";
        String sheetName = "学生";
        ExcelUtil.writeExcel(response, list, fileName, sheetName, new Student());
    }

    /**
     * 导出多个sheet页
     * @param response
     */
    @RequestMapping(value = "getMoreSheet")
    public void writeExcels(HttpServletResponse response){
        List<Student> list = iEasyExcelService.getAllStudent();
        List<Teacher> teachers = iEasyExcelService.getAllTeacher();
        List<Classes> classes = iEasyExcelService.getAllClasses();
        String fileName = "信息表";
        String sheetName1 = "学生";
        String sheetName2 = "老师";
        String sheetName3 = "课程";
        ExcelUtil.writeExcelWithSheets(response,list , fileName, sheetName1, new Student())
                .write(teachers, sheetName2, new Teacher())
                .write(classes, sheetName3, new Classes()).finish();
    }


    /**
     * 读取一个sheet页或读取多个sheet
     * @param file
     * @return
     */
    @RequestMapping(value = "readOneSheet",method = RequestMethod.POST)
    @ResponseBody
    public Integer readOneSheet(@RequestParam(value = "file",required = false) MultipartFile file){
        return iEasyExcelService.readOneSheet(file);
    }

    /**
     * 读取多个sheet页，每个sheet页数据不一样,分别为学生、教师、课程
     * @param file
     * @return
     */
    @RequestMapping(value = "readMoreSameSheet",method = RequestMethod.POST)
    @ResponseBody
    public Integer readMoreSameSheet(@RequestParam(value = "file",required = false) MultipartFile file){
        return iEasyExcelService.readMoreSameSheet(file);
    }

    /**
     * 导入指定sheet和指定行
     * @param file
     * @param sheetNum
     * @param headLineNum
     * @return
     */
    @RequestMapping(value = "readFixedSheet",method = RequestMethod.POST)
    @ResponseBody
    public Integer readFixedSheet(@RequestParam(value = "file",required = false) MultipartFile file,
                                @RequestParam(value="sheetNum", required = false) Integer sheetNum,
                                @RequestParam(value = "headLineNum",required = false) Integer headLineNum){
        return iEasyExcelService.readFixedSheet(file, sheetNum, headLineNum);
    }

    /**
     * 读取学生为李四的数据
     * @param file
     * @return
     */
    @RequestMapping(value = "readFixName",method = RequestMethod.POST)
    @ResponseBody
    public Integer readFixName(@RequestParam(value = "file",required = false) MultipartFile file){
        return iEasyExcelService.readFixName(file);
    }

}
