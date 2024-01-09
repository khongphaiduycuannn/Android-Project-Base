package com.example.projectbase.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.projectbase.base.BaseViewModel
import com.example.projectbase.base.DataState
import com.example.projectbase.data.model.User
import kotlinx.coroutines.delay

class HomeViewModel : BaseViewModel() {

    private var _content = MutableLiveData("Hello World!")
    val content: MutableLiveData<String> get() = _content

    private var _userList = MutableLiveData(mutableListOf<User>())
    val userList: MutableLiveData<MutableList<User>> get() = _userList

    fun getContent() {
        executeTask(
            request = {
                delay(2000)
                DataState.Success("Nguyen Duy Minh Quan")
            },
            onSuccess = {
                _content.value = it
            }
        )
    }

    fun getUserList() {
        executeTask(
            request = {
                DataState.Success(mutableListOf(
                    User("Duy Quân"),
                    User("Danh Nghĩa"),
                    User("Diệu Linh")
                ))
            },
            onSuccess = {
                _userList.value = it
            }
        )
    }
}