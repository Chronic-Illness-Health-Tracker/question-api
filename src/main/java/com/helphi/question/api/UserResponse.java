package com.helphi.question.api;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {
    private long responseId;
    private long questionId;
    private String conditionId;
    private String userId;
    private String userName;
    private String responseText;
    private int responseValue;
    private Instant answerTimestamp;
    private int bucket;
}