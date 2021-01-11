package com.example.learnandroid.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.learnandroid.R
import com.example.learnandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel : MainViewModel
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.tvCounter.text = viewModel.counter.toString()

        binding.fabAdd.setOnClickListener(){
            viewModel.counter++
            binding.tvCounter.text = viewModel.counter.toString()
        }

        binding.fabRemove.setOnClickListener(){
            viewModel.counter--
            binding.tvCounter.text = viewModel.counter.toString()
        }
    }
}