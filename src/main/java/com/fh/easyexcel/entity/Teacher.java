package com.fh.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class Teacher extends BaseRowModel{
    @ExcelProperty(index = 0, value = "姓名")
    private String name;
    @ExcelProperty(index = 1, value = "工号")
    private String number;
    @ExcelProperty(index = 2, value = "年龄")
    private String age;
    @ExcelProperty(index = 3, value = "性别")
    private String sex;
    @ExcelProperty(index = 4, value = "手机")
    private String phone;
}
