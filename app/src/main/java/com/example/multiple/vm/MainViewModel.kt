package com.example.multiple.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.QuestionModel
import com.example.domain.usecases.QuestionUseCaseImpl
import com.example.multiple.rx.SchedulersProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainViewModel @ViewModelInject constructor(
    private val questionUseCaseImpl: QuestionUseCaseImpl,
    private val schedulers: SchedulersProvider
): ViewModel() {

    private val questionModel = MutableLiveData<QuestionModel>()
    private val compositeDisposable = CompositeDisposable()

    fun getData() {
        questionUseCaseImpl.execute()
            .subscribeOn(schedulers.io())
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