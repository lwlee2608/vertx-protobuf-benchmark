package io.github.lwlee2608.benchmark.data;

import io.github.lwlee2608.benchmark.model.TestSubject;

public class PlaceholderData {

    static public io.vertx.protobuf.generated.TestSubject getGoogleProtoObject() {
        return io.vertx.protobuf.generated.TestSubject.newBuilder()
                .setBoolField(true)
                .setDoubleField(42.42)
                .setStringField("FooBarA")
                .setIntField(42)
                .setIntField2(420)
                .setIntField3(42000)
                .setIntField4(4200000)
                .setChildField(io.vertx.protobuf.generated.TestSubject.newBuilder()
                        .setBoolField(true)
                        .setDoubleField(42.42)
                        .setStringField("FooBarB")
                        .setIntField(42)
                        .setIntField2(420)
                        .setIntField3(42000)
                        .setIntField4(4200000)
                )
                .build();
    }

    static public TestSubject getPojo() {
        return new TestSubject()
                .setBoolField(true)
                .setStringField("FooBarA")
                .setDoubleField(42.42)
                .setIntField(42)
                .setIntField2(420)
                .setIntField3(42000)
                .setIntField4(4200000)
                .setChildField(new TestSubject()
                        .setBoolField(true)
                        .setStringField("FooBarB")
                        .setDoubleField(42.42)
                        .setIntField(42)
                        .setIntField2(420)
                        .setIntField3(42000)
                        .setIntField4(4200000)
                );
    }
}
