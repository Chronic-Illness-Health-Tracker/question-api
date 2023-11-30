package com.helphi.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Question {
    private long questionId;
    private String conditionId;
    private Answer answer;
}
