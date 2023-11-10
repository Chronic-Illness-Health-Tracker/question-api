package com.helphi.api;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionAnswer implements Serializable {

    private long questionId;
    private long conditionId;
    private long answerId;
    private String answer;
    private int answerValue;
    private Timestamp answerTimestamp;
    private long userId;
    private int bucket;

}
