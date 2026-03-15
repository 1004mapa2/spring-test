package com.springtest.six;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TestMapper testMapper;

    public void add(int id, String name) {
        testMapper.add(id, name);
    }

    public String getName(int id) {
        return testMapper.getName(id);
    }

    @Transactional
    public void addAndThrow(int id, String name) {
        add(id, name);
        throw new RuntimeException("test exception");
    }
}
