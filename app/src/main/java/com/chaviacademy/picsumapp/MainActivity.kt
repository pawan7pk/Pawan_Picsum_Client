package com.chaviacademy.picsumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.chaviacademy.picsumapp.adapters.AuthorAdapter
import com.chaviacademy.picsumapp.databinding.ActivityMainBinding
import com.chaviacademy.picsumapp.model.AuthorDetails
import com.chaviacademy.picsumapp.viewmodels.AuthorViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var authorViewModel: AuthorViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var authorAdapter: AuthorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        authorViewModel = ViewModelProvider(this).get(AuthorViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = authorViewModel

        authorViewModel.callPicsumApi()
        authorViewModel.liveDataAuthorList.observe(this, Observer {
            setUpRecyclerView(it)
        })
    }

    private fun setUpRecyclerView(list : ArrayList<AuthorDetails>){
        rvAuthors.setHasFixedSize(true)
        rvAuthors.layoutManager = GridLayoutManager(this, 2)
        authorAdapter = AuthorAdapter(list)
        rvAuthors.adapter = authorAdapter
    }
}