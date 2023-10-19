package com.grpc.benchmark.data;

import io.github.lwlee2608.benchmark.model.TestSubject;

public class PlaceholderData {

    static public io.vertx.protobuf.generated.TestSubject getGoogleProtoObject() {
        return io.vertx.protobuf.generated.TestSubject.newBuilder()
                .setBoolField(true)
                .setDoubleField(42.42)
                .setStringField("FooBar")
                .setIntField(42)
                .setIntField2(420)
                .setIntField3(42000)
                .setIntField4(4200000)
                .build();
    }

    static public TestSubject getPojo() {
        TestSubject payload = new TestSubject();
        payload.setBoolField(true);
        payload.setStringField("FooBar");
        payload.setDoubleField(42.42);
        payload.setIntField(42);
        payload.setIntField2(420);
        payload.setIntField3(42000);
        payload.setIntField4(4200000);
        return payload;
    }
}
