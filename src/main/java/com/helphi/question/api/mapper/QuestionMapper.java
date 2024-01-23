package com.helphi.question.api.mapper;

import java.time.Instant;

public class QuestionMapper implements Mapper<com.helphi.question.api.Question, com.helphi.api.grpc.Question> {

    @Override
    public com.helphi.question.api.Question mapFromGrpc(com.helphi.api.grpc.Question grpcObject) {
        if(grpcObject == null) {
            return null;
        }

        AnswerMapper answerMapper = new AnswerMapper();
        com.helphi.question.api.Answer answer = answerMapper.mapFromGrpc(grpcObject.getAnswer());

        return com.helphi.question.api.Question.builder()
            .questionId(grpcObject.getQuestionId())
            .conditionId(grpcObject.getConditionId())
            .answer(answer)
            .createdAt(Instant.ofEpochSecond(
                grpcObject.getCreatedAt().getSeconds(),
                grpcObject.getCreatedAt().getNanos())
            )
            .build();
    }

    @Override
    public com.helphi.api.grpc.Question mapToGrpc(com.helphi.question.api.Question apiObject) {

        if(apiObject == null) {
            return null;
        }

        com.helphi.api.grpc.Question.Builder builder = com.helphi.api.grpc.Question.newBuilder()
            .setQuestionId(apiObject.getQuestionId())
            .setConditionId(apiObject.getConditionId())
            .setCreatedAt(com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(apiObject.getCreatedAt().getEpochSecond())
                .setNanos(apiObject.getCreatedAt().getNano())
            .build());
        
        AnswerMapper answerMapper = new AnswerMapper();
        com.helphi.api.grpc.Answer answer = answerMapper.mapToGrpc(apiObject.getAnswer());

        if(answer != null) {
            builder.setAnswer(answer);
        }

        return builder.build();
    }
}
