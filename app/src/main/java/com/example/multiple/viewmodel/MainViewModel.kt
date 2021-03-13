package com.example.multiple.viewmodel

import androidx.lifecycle.*
import com.example.domain.entity.Result
import com.example.domain.models.QuestionModel
import com.example.domain.usecases.QuestionUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val questionUseCaseImpl: QuestionUseCaseImpl

    ): ViewModel() {

    private val _questionModel = MutableLiveData<Result<List<QuestionModel>>>()
    val questionModel: LiveData<Result<List<QuestionModel>>>
        get() = _questionModel

    private val handler = CoroutineExceptionHandler {
        _, exception ->
        _questionModel.postValue(exception.message?.let { Result.Error(it) })
    }

     fun getData() {

        viewModelScope.launch(Dispatchers.IO+handler) {

            _questionModel.postValue(Result.Loading)

                 questionUseCaseImpl.execute().let {

                    _questionModel.postValue(Result.Success(it))

            }

        }

    }

}





