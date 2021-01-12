package com.example.learnandroid.mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.learnandroid.R
import com.example.learnandroid.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel : MainViewModel
    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // DataBinding UI 관련 로직 없음
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // DataBinding 과 viewModel 를 통해 줄인 코드
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // 방법 1
//        val count : LiveData<Int> = viewModel.getCount()
//
//        count.observe(this, Observer {
//            binding.tvCounter.text = it.toString()
//        })


        // 방법 2
//        viewModel.counter.observe(this, Observer {
//            binding.tvCounter.text = it.toString()
//        })


//        binding.fabAdd.setOnClickListener {
//            viewModel.increase()
//        }
//
//        binding.fabRemove.setOnClickListener {
//            viewModel.decrease()
//        }
    }
}