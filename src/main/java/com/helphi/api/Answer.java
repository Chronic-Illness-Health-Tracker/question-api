package com.helphi.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {
    private long answerId;
    private long questionId;
    private String answerText;
    private int answerValue;
}
