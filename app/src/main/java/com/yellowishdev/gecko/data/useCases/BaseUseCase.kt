package com.yellowishdev.gecko.data.useCases

interface BaseUseCase<TResponse, TParam> {
    suspend operator fun invoke(param: TParam): TResponse
}