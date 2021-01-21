package com.example.home_task_l15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_l15.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        var adapter = MyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBinding()
        setupListeners()
        textWatcherFun()
        setupAdapter()
    }

    private lateinit var binding: ActivityMainBinding

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnAdder.setOnClickListener {
            addUser()
        }
    }

    private fun textWatcherFun() {
        binding.editText1.error = "You need enter first name"
        binding.editText2.error = "You need enter second name"
        val textWatcherA = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val firstNameUserInput = binding.editText1.text.toString()
                val secondNameUserInput = binding.editText2.text.toString()
                binding.btnAdder.isEnabled = firstNameUserInput.length in 4..10 &&
                        secondNameUserInput.length in 2..10 &&
                        firstNameUserInput.toCharArray()[0].isUpperCase() &&
                        secondNameUserInput.toCharArray()[0].isUpperCase()
            }
        }
        binding.editText1.addTextChangedListener(textWatcherA)
        binding.editText2.addTextChangedListener(textWatcherA)

    }

    private fun setupAdapter(){
        val recyclerView: RecyclerView = binding.listrecyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun addUser() {
        adapter.addItemToList(
            User(
                editText1.text.toString(),
                editText2.text.toString()
            )
        )
        editText1.text = null
        editText2.text = null
        binding.btnAdder.isEnabled = false

    }

}