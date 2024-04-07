package com.helphi.question.api;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@CqlName("questions_by_condition")
public class Question {
    @ClusteringColumn
    private long questionId;
    @PartitionKey
    private String conditionId;
    private QuestionType questionType;
    private Set<String> possibleAnswers;
    private Set<Integer> answerScoreRange;
    private List<Integer> answerScore;
}
