package com.helphi.api.mapper;

public class AnswerMapper implements Mapper<com.helphi.api.Answer, com.helphi.api.grpc.Answer> {

    @Override
    public com.helphi.api.Answer mapFromGrpc(com.helphi.api.grpc.Answer grpcObject) {

        if(grpcObject == null) {
            return null;
        }

        return com.helphi.api.Answer.builder()
            .answerId(grpcObject.getAnswerId())
            .questionId(grpcObject.getQuestionId())
            .answerText(grpcObject.getAnswerText())
            .answerValue(grpcObject.getAnswerValue())
            .build();
    }

    @Override
    public com.helphi.api.grpc.Answer mapToGrpc(com.helphi.api.Answer apiObject) {

        if(apiObject == null) {
            return null;
        }
        
        return com.helphi.api.grpc.Answer.newBuilder()
            .setAnswerId(apiObject.getAnswerId())
            .setQuestionId(apiObject.getQuestionId())
            .setAnswerText(apiObject.getAnswerText())
            .setAnswerValue(apiObject.getAnswerValue())
            .build();
    }
}
