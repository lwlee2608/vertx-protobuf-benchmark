package com.grpc.benchmark.scenario;

import io.github.lwlee2608.benchmark.model.TestSubject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonBenchmarkTest {
    private static final Logger logger = LoggerFactory.getLogger(JsonBenchmarkTest.class);
    private JsonBenchmark benchmark = new JsonBenchmark();
    private JsonBenchmark.ExecutionPlan plan = new JsonBenchmark.ExecutionPlan();

    @BeforeEach
    void init() {
        plan = new JsonBenchmark.ExecutionPlan();
        plan.setUp();
    }

    @Test
    public void decode() throws IOException {
        benchmark.decode(plan);
    }

    @Test
    public void encode() throws IOException {
        benchmark.encode(plan);
    }

    @Test
    public void encodeDecode() throws IOException {
        String encoded = benchmark.encode(plan.testSubject);
        TestSubject decoded = benchmark.decode(encoded);
        Assertions.assertEquals(plan.testSubject, decoded);

        logger.info(encoded);
    }
}
