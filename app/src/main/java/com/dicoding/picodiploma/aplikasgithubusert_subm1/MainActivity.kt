package com.dicoding.picodiploma.aplikasgithubusert_subm1


import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<Users>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation= resources.getStringArray(R.array.location)
            val dataRepository= resources.getStringArray(R.array.repository)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)

            val listUsers = ArrayList<Users>()
            for (i in dataName.indices) {
                val users = Users(
                        dataName[i],
                        dataFollowing[i],
                        dataFollowers[i],
                        dataPhoto.getResourceId(i, -1),
                        dataCompany[i],
                        dataLocation[i],
                        dataRepository[i],
                        dataUsername[i]
                )
                listUsers.add(users)
            }
            return listUsers
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)

        }
        val listUserAdapter = ListUsersAdapter(list)
        rvUsers.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUsersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Users) {
                val moveDetailUsersIntent = Intent(this@MainActivity, MoveDetailUsers::class.java)
                moveDetailUsersIntent.putExtra(MoveDetailUsers.EXTRA_USER, data)
                startActivity(moveDetailUsersIntent)
            }
        })
    }


}

