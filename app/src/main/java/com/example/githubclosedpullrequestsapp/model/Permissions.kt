package com.example.githubclosedpullrequestsapp.model

data class Permissions(
    val admin: Boolean,
    val pull: Boolean,
    val push: Boolean
)