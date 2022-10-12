package com.example.githubclosedpullrequestsapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubclosedpullrequestsapp.model.GithubPullRequestResponse
import com.example.githubclosedpullrequestsapp.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NetworkRepository) : ViewModel() {

    private val _pullResponse = MutableLiveData<GithubPullRequestResponse>()
    val pullResponse: LiveData<GithubPullRequestResponse>
        get() = _pullResponse

    init {
        fetchData()
    }

    private fun fetchData() {
        Log.e("ABC", "Starting")
        viewModelScope.launch {
            val deferredResponse = repository.getPullRequestDataAsync()
            try {
                _pullResponse.value = deferredResponse.await()
                Log.e("ABC", _pullResponse.value.toString())
            } catch (t: Throwable) {
                Log.e("ABC", "${t.message}")
            }
        }
    }
}