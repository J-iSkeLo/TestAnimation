package com.example.uitesttask

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uitesttask.databinding.ActivityMainBinding
import com.skydoves.transformationlayout.addTransformation
import com.skydoves.transformationlayout.onTransformationStartContainer


class MainActivity : Fragment(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onTransformationStartContainer()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transformLayout.transitionName = "myTransitionName"
        binding.initButtonClick()
    }

    private fun ActivityMainBinding.initButtonClick() {
        card.setOnClickListener {
            val fragment = SecondActivity()
            val bundle = binding.transformLayout.getBundle("TransformationParams")
            fragment.arguments = bundle

            requireActivity().supportFragmentManager
                .beginTransaction()
                .addTransformation(binding.transformLayout)
                .replace(R.id.container, fragment, SecondActivity().tag)
                .addToBackStack(SecondActivity().tag)
                .commit()

        }
    }


}