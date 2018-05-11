package com.golubev.denis.meduzareader.presentation.mvp.global.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersProviderImpl @Inject constructor(): SchedulersProvider {

    override fun ui() = AndroidSchedulers.mainThread()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun io(): Scheduler = Schedulers.io()

    override fun newThread(): Scheduler = Schedulers.newThread()

    override fun trampoline(): Scheduler = Schedulers.trampoline()
}