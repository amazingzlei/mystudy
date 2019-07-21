package com.fh.vue.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class Classes extends BaseRowModel{
    @ExcelProperty(index = 0,value = "课程名")
    private String name;
    @ExcelProperty(index = 1,value = "教师")
    private String teacher;
    @ExcelProperty(index = 2,value = "教室地址")
    private String address;
}
