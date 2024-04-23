package com.helphi.question.api.mapper;

import com.helphi.question.api.QuestionType;
import com.helphi.question.api.grpc.Answer;

import java.sql.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class QuestionMapper implements Mapper<com.helphi.question.api.Question, com.helphi.question.api.grpc.Question> {

    @Override
    public com.helphi.question.api.Question mapFromGrpc(com.helphi.question.api.grpc.Question grpcObject) {
        if(grpcObject == null) {
            return null;
        }

        AnswerMapper mapper = new AnswerMapper();

        List<com.helphi.question.api.Answer> apiAnswers = new ArrayList<>();
        for ( Answer answer : grpcObject.getPossibleAnswersList()) {
            apiAnswers.add(mapper.mapFromGrpc(answer));
        }
        return com.helphi.question.api.Question.builder()
                .questionId(grpcObject.getQuestionId())
                .conditionId(grpcObject.getConditionId())
                .questionText(grpcObject.getQuestionText())
                .questionType(QuestionType.valueOf(grpcObject.getQuestionType()))
                .possibleAnswers(apiAnswers)
                .questionText(grpcObject.getQuestionText())
                .build();
    }

    @Override
    public com.helphi.question.api.grpc.Question mapToGrpc(com.helphi.question.api.Question apiObject) {

        if(apiObject == null) {
            return null;
        }

        List<Answer> grpcAnswers = new ArrayList<>();
        AnswerMapper mapper = new AnswerMapper();
        for ( com.helphi.question.api.Answer answer : apiObject.getPossibleAnswers()) {
            grpcAnswers.add(mapper.mapToGrpc(answer));
        }

        com.helphi.question.api.grpc.Question.Builder builder = com.helphi.question.api.grpc.Question.newBuilder()
                .setQuestionId(apiObject.getQuestionId())
                .setConditionId(apiObject.getConditionId())
                .setQuestionText(apiObject.getQuestionText())
                .setQuestionType(String.valueOf(apiObject.getQuestionType()))
                .addAllPossibleAnswers(grpcAnswers)
                .setQuestionText(apiObject.getQuestionText());

        return builder.build();
    }
}
