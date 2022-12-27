package com.dicoding.picodiploma.aplikasgithubusert_subm1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MoveDetailUsers : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_detail_users)

        val detailUsers = intent.getParcelableExtra<Users>(EXTRA_USER) as Users


        var imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvUsername:TextView = findViewById(R.id.text_username)
        val tvName:TextView = findViewById(R.id.text_name)
        val tvCompany:TextView = findViewById(R.id.text_company)
        val tvLocation:TextView = findViewById(R.id.text_location)
        val tvFollowing:TextView = findViewById(R.id.tv_item_following)
        val tvFollower:TextView = findViewById(R.id.tv_item_follower)
        val tvRepository:TextView = findViewById(R.id.text_repository)

        val dataPhoto = detailUsers.avatar
        val textUsername = "@${detailUsers.username.toString()}"
        val textName = detailUsers.name.toString()
        val textCompany = "Company : ${detailUsers.company.toString()}"
        val textLocation = "Location : ${detailUsers.location.toString()}"
        val textFollowing = "Following\n ${detailUsers.following.toString()}"
        val textFollower = "Follower\n ${detailUsers.follower.toString()}"
        val textRepository = "Jumlah Repository : ${detailUsers.repository.toString()}"


        imgPhoto.setImageResource(dataPhoto)
        tvUsername.text = textUsername
        tvName.text = textName
        tvCompany.text = textCompany
        tvLocation.text = textLocation
        tvFollowing.text = textFollowing
        tvFollower.text = textFollower
        tvRepository.text = textRepository


    }



}