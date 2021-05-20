package Compiler;

// Functional interface for lambda expressions
public interface Lambda<TOut, TIn> {
    TOut execute(TIn i);
}
