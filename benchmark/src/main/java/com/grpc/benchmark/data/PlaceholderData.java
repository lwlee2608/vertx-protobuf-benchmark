package com.grpc.benchmark.data;

import io.github.lwlee2608.benchmark.model.TestSubject;
import io.vertx.core.json.JsonObject;
import io.vertx.protobuf.generated.Dataobjects;

public class PlaceholderData {
    static public io.vertx.protobuf.generated.TestSubject getProtoPayload() {

        return io.vertx.protobuf.generated.TestSubject.newBuilder()
                .setIntField(42)
//                .setStringField("Test String")
                .setBoolField(true)
                .setDoubleField(42.42)
//                .setBytesField(ByteString.copyFromUtf8("Test Bytes"))
                .setIntField2(420)
                .setIntField3(42000)
                .setIntField4(4200000)
                .build();
    }

    static public TestSubject getTestSubjectPojo() {
        TestSubject payload = new TestSubject();
        payload.setBoolField(true);
        payload.setIntField(42);
        payload.setDoubleField(42.42);
        payload.setIntField2(420);
        payload.setIntField3(42000);
        payload.setIntField4(4200000);
        return payload;
    }
}
