package com.example.multiple.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.QuestionModel
import com.example.domain.usecases.QuestionUseCaseImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel @ViewModelInject constructor(

    private val questionUseCaseImpl: QuestionUseCaseImpl,

    ): ViewModel(){
    val questionModel = MutableLiveData<QuestionModel>()
    private val compositeDisposable = CompositeDisposable()

    fun getData() {
        questionUseCaseImpl.execute()
            .subscribeOn(Schedulers.io())
            .subscribe({
                it?.let {
                    questionModel.postValue(it)
                }
            },{

            }).let {
                compositeDisposable.add(it)
            }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}