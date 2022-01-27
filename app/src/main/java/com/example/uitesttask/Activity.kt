package com.example.uitesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uitesttask.databinding.ActivityBinding
import com.skydoves.transformationlayout.onTransformationStartContainer

class Activity : AppCompatActivity(R.layout.activity) {

    private val binding by viewBinding(ActivityBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, MainActivity())
            .commit()
    }

}