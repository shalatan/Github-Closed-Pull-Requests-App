package com.example.githubclosedpullrequestsapp.network

import com.example.githubclosedpullrequestsapp.model.GithubPullRequestResponse
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val githubApiService: GithubApiService) {

    fun getPullRequestDataAsync(): Deferred<GithubPullRequestResponse> {
        return githubApiService.getGitPullRequest()
    }
}


