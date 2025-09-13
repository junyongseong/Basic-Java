package com.swagger.ex_swagger.dto;

public class HelloResponse {
    private String message;
    private String author;

    public HelloResponse() {}
    public HelloResponse(String message, String author) {
        this.message = message;
        this.author = author;
    }
    public String getMessage() { return message; }
    public String getAuthor() { return author; }
    public void setMessage(String message) { this.message = message; }
    public void setAuthor(String author) { this.author = author; }
}