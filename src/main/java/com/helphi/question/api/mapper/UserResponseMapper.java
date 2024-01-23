package com.helphi.question.api.mapper;

import java.time.Instant;

public class UserResponseMapper implements Mapper<com.helphi.question.api.UserResponse, com.helphi.api.grpc.UserResponse> {

    @Override
    public com.helphi.question.api.UserResponse mapFromGrpc(com.helphi.api.grpc.UserResponse grpcObject) {

        if(grpcObject == null) {
            return null;
        }

        return com.helphi.question.api.UserResponse.builder()
            .responseId(grpcObject.getResponseId())
            .questionId(grpcObject.getQuestionId())
            .conditionId(grpcObject.getConditionId())
            .userId(grpcObject.getUserId())
            .userName(grpcObject.getUserName())
            .responseText(grpcObject.getResponseText())
            .responseValue(grpcObject.getResponseValue())
            .answerTimestamp(
                Instant.ofEpochSecond(
                    grpcObject.getAnswerTimestamp().getSeconds(),
                    grpcObject.getAnswerTimestamp().getNanos())
            )
            .bucket(0)
            .build();
    }

    @Override
    public com.helphi.api.grpc.UserResponse mapToGrpc(com.helphi.question.api.UserResponse apiObject) {
        
        if(apiObject == null) {
            return null;
        }

        return com.helphi.api.grpc.UserResponse.newBuilder()
            .setResponseId(apiObject.getResponseId())
            .setQuestionId(apiObject.getQuestionId())
            .setConditionId(apiObject.getConditionId())
            .setUserId(apiObject.getUserId())
            .setUserName(apiObject.getUserName())
            .setResponseText(apiObject.getResponseText())
            .setResponseValue(apiObject.getResponseValue())
            .setAnswerTimestamp(com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(apiObject.getAnswerTimestamp().getEpochSecond())
                .setNanos(apiObject.getAnswerTimestamp().getNano())
                .build())
            .setBucket(apiObject.getBucket())
            .build();
    }
}
