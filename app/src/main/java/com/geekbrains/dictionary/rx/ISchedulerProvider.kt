package com.geekbrains.dictionary.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {
    val ui: Scheduler
    val io: Scheduler
}