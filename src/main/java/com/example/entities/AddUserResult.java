package com.example.entities;

public class AddUserResult  {
    private final boolean success;
    private final String message;

    public AddUserResult(boolean success, String message) {
        
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
