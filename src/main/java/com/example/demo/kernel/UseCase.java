package com.example.demo.kernel;

import jakarta.annotation.Nullable;

import java.util.Optional;

public interface UseCase <TInput, TOutput> {
    TOutput execute(TInput payload, TInput payloadToken);
}
