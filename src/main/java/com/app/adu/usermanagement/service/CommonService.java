package com.app.adu.usermanagement.service;

import java.util.List;
import java.util.Optional;

public interface CommonService<T, R> {
    Optional<R> findOne(T t);

    List<R> findAll();

    R create(R r);

    void delete(T t);

    void deleteEntity(R r);

    R update(R r);
}