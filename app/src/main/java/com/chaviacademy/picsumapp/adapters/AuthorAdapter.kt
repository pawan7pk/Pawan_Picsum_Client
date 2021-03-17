package com.chaviacademy.picsumapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chaviacademy.picsumapp.R
import com.chaviacademy.picsumapp.databinding.ItemAuthorBinding
import com.chaviacademy.picsumapp.model.AuthorDetails

class AuthorAdapter(authorList: ArrayList<AuthorDetails>) : RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>() {

    private var authorList: ArrayList<AuthorDetails>? = authorList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val binding: ItemAuthorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_author,
            parent,
            false
        )
        return AuthorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        holder.itemAuthorBinding.author = authorList?.get(position)
    }
    override fun getItemCount(): Int {
        return authorList?.size ?: 0
    }

    class AuthorViewHolder(val itemAuthorBinding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(itemAuthorBinding.root)


}