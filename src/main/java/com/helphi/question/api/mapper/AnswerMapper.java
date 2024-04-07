package com.helphi.question.api.mapper;

public class AnswerMapper implements Mapper<com.helphi.question.api.Answer, com.helphi.question.api.grpc.Answer> {

    @Override
    public com.helphi.question.api.Answer mapFromGrpc(com.helphi.question.api.grpc.Answer grpcObject) {

        if(grpcObject == null) {
            return null;
        }

        return com.helphi.question.api.Answer.builder()
            .answerText(grpcObject.getAnswerText())
            .answerScore(grpcObject.getAnswerScore())
            .build();
    }

    @Override
    public com.helphi.question.api.grpc.Answer mapToGrpc(com.helphi.question.api.Answer apiObject) {

        if(apiObject == null) {
            return null;
        }
        
        return com.helphi.question.api.grpc.Answer.newBuilder()
            .setAnswerText(apiObject.getAnswerText())
            .setAnswerScore(apiObject.getAnswerScore())
            .build();
    }
}
