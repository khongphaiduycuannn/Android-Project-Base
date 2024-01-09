package com.example.projectbase.ui.home

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectbase.base.BaseFragment
import com.example.projectbase.data.model.User
import com.example.projectbase.databinding.FragmentHomeBinding

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    private val listUserAdapter by lazy {
        ListUserAdapter {
            onUserItemClick(it)
        }
    }

    override val viewModel: HomeViewModel
        get() = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

    override fun initData() {
        viewModel.getContent()
        viewModel.getUserList()
    }

    override fun setView() {
        binding.rvListUser.layoutManager = LinearLayoutManager(requireContext())
        binding.rvListUser.adapter = listUserAdapter
    }

    override fun observeData() {
        viewModel.content.observe(viewLifecycleOwner) {
            binding.tvContent.text = it
        }
        viewModel.userList.observe(viewLifecycleOwner) {
            listUserAdapter.setDataList(it)
        }
    }

    override fun setOnClick() {

    }

    private fun onUserItemClick(user: User) {
        Toast.makeText(requireContext(), user.username, Toast.LENGTH_LONG).show()
    }
}