package com.helphi.question.api.mapper;

import com.helphi.question.api.QuestionType;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

public class QuestionMapper implements Mapper<com.helphi.question.api.Question, com.helphi.question.api.grpc.Question> {

    @Override
    public com.helphi.question.api.Question mapFromGrpc(com.helphi.question.api.grpc.Question grpcObject) {
        if(grpcObject == null) {
            return null;
        }

        return com.helphi.question.api.Question.builder()
                .questionId(grpcObject.getQuestionId())
                .conditionId(grpcObject.getConditionId())
                .questionType(QuestionType.valueOf(grpcObject.getQuestionType()))
                .possibleAnswers(new HashSet<String>(grpcObject.getPossibleAnswersList()))
                .answerScore(grpcObject.getAnswerScoreList())
                .build();
    }

    @Override
    public com.helphi.question.api.grpc.Question mapToGrpc(com.helphi.question.api.Question apiObject) {

        if(apiObject == null) {
            return null;
        }

        com.helphi.question.api.grpc.Question.Builder builder = com.helphi.question.api.grpc.Question.newBuilder()
                .setQuestionId(apiObject.getQuestionId())
                .setConditionId(apiObject.getConditionId())
                .setQuestionType(String.valueOf(apiObject.getQuestionType()))
                .addAllPossibleAnswers(apiObject.getPossibleAnswers())
                .addAllAnswerScore(apiObject.getAnswerScore());

        return builder.build();
    }
}
