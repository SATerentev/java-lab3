package app;

public record Result<T>(boolean IsSuccess, T Value, String ErrorMessage) { }
