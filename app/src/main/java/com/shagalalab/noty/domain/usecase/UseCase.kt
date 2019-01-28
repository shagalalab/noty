package com.shagalalab.noty.domain.usecase

import androidx.lifecycle.LiveData

interface UseCase<P, R> {
    suspend fun execute(param: P): R
}

interface LiveDataUseCase<P, R> {
    fun execute(param: P): LiveData<R>
}