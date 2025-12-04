package com.example.studentdata.util;

public class OperationResult {
    private final boolean success;
    private final String message;

    private OperationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static OperationResult ok(String msg) {
        return new OperationResult(true, msg);
    }

    public static OperationResult fail(String msg) {
        return new OperationResult(false, msg);
    }

    public boolean isFailed() { return !success; }
    public String getMessage() { return message; }
}