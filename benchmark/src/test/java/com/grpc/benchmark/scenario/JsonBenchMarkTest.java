package com.grpc.benchmark.scenario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class JsonBenchMarkTest {
    private JsonBenchMark benchMark = new JsonBenchMark();
    private JsonBenchMark.ExecutionPlan plan = new JsonBenchMark.ExecutionPlan();

    @BeforeEach
    void init() {
        plan = new JsonBenchMark.ExecutionPlan();
        plan.setUp();
    }

    @Test
    public void decode() {
        benchMark.decode(plan);
    }

    @Test
    public void encode() {
        String payload = benchMark.encode(plan);
        System.out.println("size " + payload.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(payload);
//        System.out.println(TestUtils.prettyHexDump(payload.getBytes(StandardCharsets.UTF_8)));
    }
}
