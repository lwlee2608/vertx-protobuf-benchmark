package io.github.lwlee2608.benchmark.scenario;

import io.github.lwlee2608.benchmark.TestUtils;
import io.vertx.protobuf.generated.TestSubject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ProtoVertxBenchmarkTest {
    private static final Logger logger = LoggerFactory.getLogger(ProtoVertxBenchmarkTest.class);
    private ProtoGoogleBenchmark benchmark = new ProtoGoogleBenchmark();
    private ProtoGoogleBenchmark.ExecutionPlan plan = new ProtoGoogleBenchmark.ExecutionPlan();

    @BeforeEach
    void init() throws IOException {
        plan = new ProtoGoogleBenchmark.ExecutionPlan();
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
        byte[] encoded = ProtoGoogleBenchmark.encode(plan.testSubject);
        TestSubject decoded = ProtoGoogleBenchmark.decode(encoded);
        Assertions.assertEquals(plan.testSubject, decoded);

        logger.info("\n{}", TestUtils.prettyHexDump(encoded));
    }
}