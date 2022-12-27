package com.dicoding.picodiploma.aplikasgithubusert_subm1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    var name: String,
    var following: String,
    var follower: String,
    var avatar: Int,
    var company: String,
    var location: String,
    var repository: String,
    var username: String
) : Parcelable