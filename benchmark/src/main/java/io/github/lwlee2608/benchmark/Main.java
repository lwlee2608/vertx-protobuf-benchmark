package io.github.lwlee2608.benchmark;

import io.github.lwlee2608.benchmark.scenario.JsonBenchmark;
import io.github.lwlee2608.benchmark.scenario.ProtoGoogleBenchmark;
import io.github.lwlee2608.benchmark.scenario.ProtoVertxBenchmark;
import org.openjdk.jmh.profile.AsyncProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main( String[] args ) throws Exception {
        String useAsyncProfilerProp = System.getProperty("profiler");

        if (Boolean.parseBoolean(useAsyncProfilerProp)) {
            Options opt = new OptionsBuilder()
                    .include(ProtoGoogleBenchmark.class.getSimpleName())
                    .include(JsonBenchmark.class.getSimpleName())
                    .include(ProtoVertxBenchmark.class.getSimpleName())
                    .addProfiler(AsyncProfiler.class, "output=flamegraph;dir=/tmp/")
                    .forks(1)
                    .build();
            new Runner(opt).run();
        } else {
            org.openjdk.jmh.Main.main(args);
        }
    }
}
