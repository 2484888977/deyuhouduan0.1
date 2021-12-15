package com.deyu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Systemlog {
    private int id;
    private String datetime;
    private String ip;
    private String info;
    private String state;
    private String username;
}
