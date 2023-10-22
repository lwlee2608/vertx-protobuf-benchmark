package io.github.lwlee2608.benchmark.scenario;

import com.google.protobuf.CodedOutputStream;
import io.github.lwlee2608.benchmark.data.PlaceholderData;
import io.vertx.protobuf.generated.TestSubject;
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
public class ProtoGoogleBenchmark {
    private static final Logger logger = LoggerFactory.getLogger(ProtoGoogleBenchmark.class);

    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        TestSubject testSubject;
        byte[] onWire;

        @Setup(Level.Trial)
        public void setUp() throws IOException {
            testSubject = PlaceholderData.getGoogleProtoObject();
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
        return TestSubject.parseFrom(onWire);
    }

    public static byte[] encode(TestSubject testSubject) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CodedOutputStream output = CodedOutputStream.newInstance(baos, 35);
        testSubject.writeTo(output);
        output.flush();
        return baos.toByteArray();
    }
}
