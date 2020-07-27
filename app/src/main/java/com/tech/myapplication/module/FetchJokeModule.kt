package com.tech.myapplication.module

import androidx.lifecycle.ViewModelProvider
import com.tech.myapplication.MainActivity
import com.tech.myapplication.controller.MyController
import com.tech.myapplication.controller.MyControllerDecorator
import com.tech.myapplication.presenter.MyPresenter
import com.tech.myapplication.presenter.MyViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object FetchJokeModule {

    @Provides
    fun provideMyControllerDecorator(
        controllerImpl: MyController
    ): MyControllerDecorator = MyControllerDecorator(controllerImpl)

}