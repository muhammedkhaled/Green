package com.muhammad.green.views.home.response


data class Notifications(
    val data: ArrayList<NotificationData>,
    val status: Int
)

data class NotificationData(
    val account_id: String,
    val article_id: String,
    val content: String,
    val created_at: String,
    val id: Int,
    val photo_id: Int,
    val pivot: Pivot,
    val title: String,
    val updated_at: String
)

data class Pivot(
    val notification_id: Int,
    val user_id: Int
)