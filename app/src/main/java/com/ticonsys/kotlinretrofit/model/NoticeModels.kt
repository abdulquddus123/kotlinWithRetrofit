package com.ticonsys.kotlinretrofit.model

data class NoticeModels(
    val message: String,
    val noticeboardData: List<NoticeboardDataX>,
    val status: Int
)