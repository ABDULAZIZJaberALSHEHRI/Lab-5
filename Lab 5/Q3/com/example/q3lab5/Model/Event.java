package com.example.q3lab5.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {
    private int id;
    private String description;
    private int capacity;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty("date")
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDate startDate;
    private LocalDate endDate;
}
