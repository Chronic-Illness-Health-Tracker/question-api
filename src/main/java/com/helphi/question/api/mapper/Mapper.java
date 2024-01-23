package com.helphi.question.api.mapper;

public interface Mapper<T, S> {

    public T mapFromGrpc(S grpcObject);
    public S mapToGrpc(T apiObject);
}