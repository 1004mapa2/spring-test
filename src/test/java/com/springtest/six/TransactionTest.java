package com.springtest.six;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TransactionTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void rollbackTest() {
        assertThrows(RuntimeException.class, () -> {
            transactionService.addAndThrow(2, "test");
        });

        assertNull(transactionService.getName(2));
    }

    @Test
    void readOnlyTest() {
        assertThrows(DataAccessException.class, () -> {
            transactionService.readOnlyTest(2, "test");
        });
    }
}
