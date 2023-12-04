package com.helphi.api;

import java.time.Instant;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Question {
    @ClusteringColumn
    private long questionId;
    @PartitionKey
    private String conditionId;
    private Answer answer;
    private Instant createdAt;
}
