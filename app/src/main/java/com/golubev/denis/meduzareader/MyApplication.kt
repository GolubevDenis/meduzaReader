package com.golubev.denis.meduzareader

import android.app.Application
import android.databinding.DataBindingUtil
import com.golubev.denis.meduzareader.di.global.ApplicationComponent
import com.golubev.denis.meduzareader.di.global.BindingComponent
import com.golubev.denis.meduzareader.di.global.DaggerApplicationComponent
import com.golubev.denis.meduzareader.di.global.DaggerBindingComponent
import com.golubev.denis.meduzareader.di.global.modules.ApplicationModule
import io.realm.Realm

class MyApplication : Application(){

    companion object {
        private lateinit var appComponent: ApplicationComponent
        fun getApplicationComponent() = appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()

        val bindingComponent = DaggerBindingComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build()
        DataBindingUtil.setDefaultComponent(bindingComponent)
    }
}