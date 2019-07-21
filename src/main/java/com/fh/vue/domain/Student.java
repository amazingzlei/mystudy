package com.fh.vue.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class Student extends BaseRowModel{
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ExcelProperty(value = "年龄", index = 1)
    private String age;
    @ExcelProperty(value = "性别", index = 2)
    private String sex;
    @ExcelProperty(value = "地址", index = 3)
    private String address;
    @ExcelProperty(value = "手机", index = 4)
    private String phone;
}
