package com.example.githubclosedpullrequestsapp.network

import com.example.githubclosedpullrequestsapp.model.GithubPullRequestResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface GithubApiService {

    @GET("repos/shalatan/EntertainmentApp/pulls?state=closed")
    fun getGitPullRequest(): Deferred<GithubPullRequestResponse>

}