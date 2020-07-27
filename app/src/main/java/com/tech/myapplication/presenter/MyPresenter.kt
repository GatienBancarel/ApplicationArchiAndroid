package com.tech.myapplication.presenter

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech.myapplication.interactor.ChuckNorris
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScoped
class MyPresenter @Inject constructor(
    val viewModel: MyViewModel,
    @ActivityContext private val context: Context
) {

    fun present(joke: ChuckNorris) {
        val chuckNorrisViewModel = ChuckNorrisViewModel(joke.value)
        viewModel.liveData.postValue(chuckNorrisViewModel)
    }
}

@Singleton
class MyViewModel @Inject constructor(): ViewModel(), LifecycleObserver {
    val liveData: MutableLiveData<ChuckNorrisViewModel> = MutableLiveData()
}