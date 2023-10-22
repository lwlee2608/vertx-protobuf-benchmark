package io.github.lwlee2608.benchmark.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.protobuf.annotations.FieldNumberStrategy;
import io.vertx.codegen.protobuf.annotations.ProtobufGen;
import lombok.Data;

@Data
@DataObject
@ProtobufGen(fieldNumberStrategy = FieldNumberStrategy.COMPACT)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestSubject {
    private int intField;
    private int intField2;
    private int intField3;
    private int intField4;
    private String stringField;
    private boolean boolField;
    private double doubleField;
//    private byte[] bytesField;
}
