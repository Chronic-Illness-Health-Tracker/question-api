package com.helphi.api.mapper;

public class QuestionMapper implements Mapper<com.helphi.api.Question, com.helphi.api.grpc.Question> {

    @Override
    public com.helphi.api.Question mapFromGrpc(com.helphi.api.grpc.Question grpcObject) {
        if(grpcObject == null) {
            return null;
        }

        AnswerMapper answerMapper = new AnswerMapper();
        com.helphi.api.Answer answer = answerMapper.mapFromGrpc(grpcObject.getAnswer());

        return com.helphi.api.Question.builder()
            .questionId(grpcObject.getQuestionId())
            .conditionId(grpcObject.getConditionId())
            .answer(answer)
            .build();
    }

    @Override
    public com.helphi.api.grpc.Question mapToGrpc(com.helphi.api.Question apiObject) {

        if(apiObject == null) {
            return null;
        }
        
        AnswerMapper answerMapper = new AnswerMapper();
        com.helphi.api.grpc.Answer answer = answerMapper.mapToGrpc(apiObject.getAnswer());
        return com.helphi.api.grpc.Question.newBuilder()
            .setQuestionId(apiObject.getQuestionId())
            .setConditionId(apiObject.getConditionId())
            .setAnswer(answer)
            .build();
    }
    
}
