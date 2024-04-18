package com.helphi.question.api;

import java.time.Instant;
import java.util.List;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@CqlName("user_responses_by_condition_user")
public class UserResponse {
    @ClusteringColumn
    private long responseId;
    private long questionId;
    @PartitionKey(2)
    private String conditionId;
    @PartitionKey(1)
    private String userId;
    private List<Answer> answer;
    private Instant timestamp;
}