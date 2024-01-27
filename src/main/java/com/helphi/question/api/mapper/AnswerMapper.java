package com.helphi.question.api.mapper;

public class AnswerMapper implements Mapper<com.helphi.question.api.Answer, com.helphi.question.api.grpc.Answer> {

    @Override
    public com.helphi.question.api.Answer mapFromGrpc(com.helphi.question.api.grpc.Answer grpcObject) {

        if(grpcObject == null) {
            return null;
        }

        return com.helphi.question.api.Answer.builder()
            .answerId(grpcObject.getAnswerId())
            .questionId(grpcObject.getQuestionId())
            .answerText(grpcObject.getAnswerText())
            .answerValue(grpcObject.getAnswerValue())
            .build();
    }

    @Override
    public com.helphi.question.api.grpc.Answer mapToGrpc(com.helphi.question.api.Answer apiObject) {

        if(apiObject == null) {
            return null;
        }
        
        return com.helphi.question.api.grpc.Answer.newBuilder()
            .setAnswerId(apiObject.getAnswerId())
            .setQuestionId(apiObject.getQuestionId())
            .setAnswerText(apiObject.getAnswerText())
            .setAnswerValue(apiObject.getAnswerValue())
            .build();
    }
}
