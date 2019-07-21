package com.fh.ajax.controller;

import com.fh.vue.common.HttpUtils;
import com.fh.vue.common.ResultVo;
import com.fh.vue.domain.Img;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("ajax")
public class AjaxCrosController {

    @ResponseBody
    @RequestMapping("/getFromHttpUtils")
    public String httputils(String url, String id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id );
        return HttpUtils.sendPost(url, map);
    }

    @ResponseBody
    @RequestMapping("/getFromHttpUtilsByJson")
    public ResultVo getFromHttpUtilsByJson(String url, Img img){
        Gson gson = new Gson();
        ResultVo resultVo = gson.fromJson(HttpUtils.sendPost(url, gson.toJson(img)), ResultVo.class);
        return resultVo;
    }
}
