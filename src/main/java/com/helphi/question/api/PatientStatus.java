package com.helphi.question.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientStatus {
    private ConditionStatus status;
    private int score;
    private Date timestamp;
}
