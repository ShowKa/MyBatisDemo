package com.showka.MyBatisDemo.entity;

import lombok.Data;

@Data
public class Todo {
    private int id;
    private String title;
    private String details;
    private boolean finished;
}
