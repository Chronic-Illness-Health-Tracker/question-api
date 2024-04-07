package com.helphi.question.api.mapper;

import com.helphi.question.api.ConditionCheckIn;

public class CheckInMapper implements Mapper<com.helphi.question.api.ConditionCheckIn, com.helphi.question.api.grpc.ConditionCheckIn> {
    @Override
    public com.helphi.question.api.ConditionCheckIn mapFromGrpc(com.helphi.question.api.grpc.ConditionCheckIn grpcObject) {
        return new ConditionCheckIn(grpcObject.getConditionId(), grpcObject.getSubclinicalScore(), grpcObject.getUnwellScore());
    }

    @Override
    public com.helphi.question.api.grpc.ConditionCheckIn mapToGrpc(com.helphi.question.api.ConditionCheckIn apiObject) {
        return com.helphi.question.api.grpc.ConditionCheckIn.newBuilder()
                .setConditionId(apiObject.getConditionId())
                .setSubclinicalScore(apiObject.getSubclinicalScore())
                .setUnwellScore(apiObject.getUnwellScore())
                .build();
    }
}
