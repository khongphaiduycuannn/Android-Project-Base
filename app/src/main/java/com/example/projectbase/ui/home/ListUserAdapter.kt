package com.example.projectbase.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.projectbase.base.BaseAdapter
import com.example.projectbase.data.model.User
import com.example.projectbase.databinding.ItemUserBinding

class ListUserAdapter(
    private val onClick: (User) -> Unit
) : BaseAdapter<User, ItemUserBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup): ItemUserBinding {
        return ItemUserBinding.inflate(inflater)
    }

    override fun bindData(binding: ItemUserBinding, item: User, position: Int) {
        binding.tvUsername.text = item.username
    }

    override fun onClickItem(item: User, position: Int) {
        onClick.invoke(item)
    }
}