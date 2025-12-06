package com.praktikum.studentdata.util;

public record OperationResult(boolean success, String message) {

    public static OperationResult success(String msg) {
        return new OperationResult(true, msg);
    }

    public static OperationResult fail(String msg) {
        return new OperationResult(false, msg);
    }

    public boolean isFailed() {
        return !success;
    }
}