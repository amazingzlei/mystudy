package com.fh.vue.domain;

import lombok.Data;

@Data
public class Comment {
    private String id;
    private String name;
    private String time;
    private String content;
}
