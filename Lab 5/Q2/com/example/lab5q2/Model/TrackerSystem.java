package com.example.lab5q2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class TrackerSystem {
    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
