package com.grpc.benchmark.scenario;


import com.grpc.benchmark.data.PlaceholderData;
import io.github.lwlee2608.benchmark.model.TestSubject;
import io.vertx.core.json.Json;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Threads(8)
@Fork(value = 1, warmups = 3)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JsonBenchmark {
    private static final Logger logger = LoggerFactory.getLogger(JsonBenchmark.class);

    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        TestSubject testSubject;
        String onWire;

        @Setup(Level.Trial)
        public void setUp() {
            testSubject = PlaceholderData.getPojo();
            onWire = Json.encode(testSubject);
        }
    }

    @Benchmark
    public TestSubject decode(ExecutionPlan plan){
        return decode(plan.onWire);
    }

    @Benchmark
    public String encode(ExecutionPlan plan) {
        return encode(plan.testSubject);
    }

    public TestSubject decode(String onWire) {
        return Json.decodeValue(onWire, TestSubject.class);
    }

    public String encode(TestSubject testSubject) {
        return Json.encode(testSubject);
    }
}
