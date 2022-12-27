package com.dicoding.picodiploma.aplikasgithubusert_subm1

import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.aplikasgithubusert_subm1.R
import com.dicoding.picodiploma.aplikasgithubusert_subm1.Users
import java.util.*

class ListUsersAdapter(private val listUsers: ArrayList<Users>) : RecyclerView.Adapter<ListUsersAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, following, follower, avatar) = listUsers[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvFollowing.text = "Following : ${following}"
        holder.tvFollower.text = "Followers : ${follower}"
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUsers[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUsers.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFollowing: TextView = itemView.findViewById(R.id.tv_item_following)
        var tvFollower: TextView = itemView.findViewById(R.id.tv_item_follower)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Users)
    }


}
