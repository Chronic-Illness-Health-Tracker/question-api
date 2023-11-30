package com.helphi.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
    private long questionId;
    private String conditionId;
    private Answer answer;
}
