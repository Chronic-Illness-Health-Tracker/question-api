package com.helphi.question.api.mapper;

import com.helphi.question.api.ConditionStatus;
import java.time.Instant;
import java.util.Date;

public class PatientStatusMapper implements Mapper<com.helphi.question.api.PatientStatus, com.helphi.question.api.grpc.PatientStatus> {
    @Override
    public com.helphi.question.api.PatientStatus mapFromGrpc(com.helphi.question.api.grpc.PatientStatus grpcObject) {
        com.helphi.question.api.PatientStatus patientStatus = new com.helphi.question.api.PatientStatus();

        patientStatus.setStatus(ConditionStatus.valueOf(grpcObject.getStatus()));
        patientStatus.setScore(grpcObject.getScore());

        Instant instant = Instant.ofEpochSecond( grpcObject.getTimestamp().getSeconds(), grpcObject.getTimestamp().getNanos());
        patientStatus.setTimestamp(Date.from(instant));

        return patientStatus;
    }

    @Override
    public com.helphi.question.api.grpc.PatientStatus mapToGrpc(com.helphi.question.api.PatientStatus apiObject) {

        Instant instant = apiObject.getTimestamp().toInstant();
        return com.helphi.question.api.grpc.PatientStatus.newBuilder()
                .setStatus(String.valueOf(apiObject.getStatus()))
                .setScore(apiObject.getScore())
                .setTimestamp(com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(instant.getEpochSecond())
                        .setNanos(instant.getNano())
                        .build())
                .build();
    }
}
