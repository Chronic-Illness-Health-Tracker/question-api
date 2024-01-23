package com.helphi.question.api;

import com.datastax.oss.driver.api.mapper.annotations.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Answer {
    private long answerId;
    private long questionId;
    private String answerText;
    private int answerValue;
}
