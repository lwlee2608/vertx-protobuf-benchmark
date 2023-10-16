package com.grpc.benchmark.scenario;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.grpc.benchmark.data.PlaceholderData;
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
@Fork(value = 1, warmups = 2)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ProtoBenchMark {
    private static final Logger logger = LoggerFactory.getLogger(ProtoBenchMark.class);

//    @State(Scope.Benchmark)
//    public static class ExecutionPlan {
//        ExamplePayload payload;
//        byte[] bytePayload;
//
//        @Setup(Level.Trial)
//        public void setUp() throws IOException {
//            payload = PlaceholderData.getProtoPayload();
//
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            CodedOutputStream output = CodedOutputStream.newInstance(baos);
//            PlaceholderData.getProtoPayload().writeTo(output);
//            output.flush();
//            bytePayload = baos.toByteArray();
//        }
//    }

//    @Benchmark
//    public ExamplePayload decode(ExecutionPlan plan) throws InvalidProtocolBufferException {
//        return ExamplePayload.parseFrom(plan.bytePayload);
//    }
//
//    @Benchmark
//    public byte[] encode(ExecutionPlan plan) throws IOException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        CodedOutputStream output = CodedOutputStream.newInstance(baos, 50);
//        plan.payload.writeTo(output);
//        output.flush();
//        return baos.toByteArray();
//    }
}
