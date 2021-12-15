package com.investment.services;

import java.util.List;
import java.util.Optional;

public interface PaperService<F, P> {
    void add(F form, Integer userId);
    void update(F form, P paper);
    void delete(Integer id);
    P getById(Integer id);
    List<P> findAllByUserId(Integer userId);
}
