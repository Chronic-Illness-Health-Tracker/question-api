package com.helphi.question.api.mapper;

import java.time.Instant;

public class UserResponseMapper implements Mapper<com.helphi.question.api.UserResponse, com.helphi.question.api.grpc.UserResponse> {

    @Override
    public com.helphi.question.api.UserResponse mapFromGrpc(com.helphi.question.api.grpc.UserResponse grpcObject) {

        if(grpcObject == null) {
            return null;
        }

        AnswerMapper answerMapper = new AnswerMapper();

        return com.helphi.question.api.UserResponse.builder()
                .responseId(grpcObject.getResponseId())
                .questionId(grpcObject.getQuestionId())
                .conditionId(grpcObject.getConditionId())
                .userId(grpcObject.getUserId())
                .answer(answerMapper.mapFromGrpc(grpcObject.getAnswer()))
                .timestamp(
                        Instant.ofEpochSecond(
                                grpcObject.getTimestamp().getSeconds(),
                                grpcObject.getTimestamp().getNanos())
                )
            .build();
    }

    @Override
    public com.helphi.question.api.grpc.UserResponse mapToGrpc(com.helphi.question.api.UserResponse apiObject) {
        
        if(apiObject == null) {
            return null;
        }

        long timestampSeconds;
        int timestampNanos;
        if(apiObject.getTimestamp() == null){
            timestampSeconds = 0;
            timestampNanos = 0;
        } else {
            timestampSeconds = apiObject.getTimestamp().getEpochSecond();
            timestampNanos = apiObject.getTimestamp().getNano();
        }

        AnswerMapper answerMapper = new AnswerMapper();

        return com.helphi.question.api.grpc.UserResponse.newBuilder()
                .setResponseId(apiObject.getResponseId())
                .setQuestionId(apiObject.getQuestionId())
                .setConditionId(apiObject.getConditionId())
                .setUserId(apiObject.getUserId())
                .setAnswer(answerMapper.mapToGrpc(apiObject.getAnswer()))
                .setTimestamp(com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(timestampSeconds)
                        .setNanos(timestampNanos)
                        .build())
            .build();
    }
}
