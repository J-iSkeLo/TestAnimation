package com.example.uitesttask

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uitesttask.databinding.ASceneBinding
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.addTransformation
import com.skydoves.transformationlayout.onTransformationEndContainer

class SecondActivity : Fragment(R.layout.a_scene) {

    private val binding by viewBinding(ASceneBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = arguments?.getParcelable<TransformationLayout.Params>("TransformationParams")
        onTransformationEndContainer(params)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transformLayout.transitionName = "myTransitionName"
        binding.root.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.radio3.setOnClickListener {
            val fragment = ThirdActivity()
            val bundle = binding.transformLayout.getBundle("TransformationParams")
            fragment.arguments = bundle

            requireActivity().supportFragmentManager
                .beginTransaction()
                .addTransformation(binding.transformLayout)
                .replace(R.id.container, fragment, ThirdActivity().tag)
                .addToBackStack(ThirdActivity().tag)
                .commit()
        }
    }


}