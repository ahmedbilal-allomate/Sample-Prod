package com.example.myapplication.viewModels
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.DummyData
import com.example.myapplication.model.User
import com.example.myapplication.repositories.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataViewModel(private val repo : DataRepository) :ViewModel(){
    private val _data = MutableLiveData<DummyData>()
    val data : LiveData<DummyData> get() = _data

    fun getData(){
        viewModelScope.launch {
            val user = repo.getData()
            _data.value = user
        }
    }
}