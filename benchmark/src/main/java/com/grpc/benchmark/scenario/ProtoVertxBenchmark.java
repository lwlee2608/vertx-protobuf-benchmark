package com.grpc.benchmark.scenario;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.grpc.benchmark.data.PlaceholderData;
import io.github.lwlee2608.benchmark.model.TestSubject;
import io.github.lwlee2608.benchmark.model.TestSubjectProtoConverter;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Threads(8)
@Fork(value = 1, warmups = 3)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ProtoVertxBenchmark {
    private static final Logger logger = LoggerFactory.getLogger(ProtoVertxBenchmark.class);

    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        TestSubject testSubject;
        byte[] onWire;

        @Setup(Level.Trial)
        public void setUp() throws IOException {
            testSubject = PlaceholderData.getPojo();
            onWire = encode(testSubject);
        }
    }

    @Benchmark
    public TestSubject decode(ExecutionPlan plan) throws IOException {
        return decode(plan.onWire);
    }

    @Benchmark
    public byte[] encode(ExecutionPlan plan) throws IOException {
        return encode(plan.testSubject);
    }

    public static TestSubject decode(byte[] onWire) throws IOException {
        CodedInputStream input = CodedInputStream.newInstance(onWire);
        TestSubject testSubject = new TestSubject();
        TestSubjectProtoConverter.fromProto(input, testSubject);
        return testSubject;
    }

    public static byte[] encode(TestSubject testSubject) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CodedOutputStream output = CodedOutputStream.newInstance(baos, 35);
        TestSubjectProtoConverter.toProto(testSubject, output);
        output.flush();
        return baos.toByteArray();
    }
}
