package com.golubev.denis.meduzareader.presentation.mvp.global.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

interface SchedulersProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

    fun newThread(): Scheduler

    fun trampoline(): Scheduler
}