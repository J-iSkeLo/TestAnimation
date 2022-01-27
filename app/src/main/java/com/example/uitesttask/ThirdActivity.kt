package com.example.uitesttask

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uitesttask.databinding.BSceneBinding
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationEndContainer

class ThirdActivity : Fragment(R.layout.b_scene) {

    private val binding by viewBinding(BSceneBinding::bind)
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = arguments?.getParcelable<TransformationLayout.Params>("TransformationParams")
        onTransformationEndContainer(params)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transformLayout.transitionName = "myTransitionName"
        setupRecycler()

        binding.root.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun setupRecycler() {
        adapter = Adapter()
        val list = listOf(Data("AirPods Pro (Александр)", "Connected"), Data("MI Band 2", "Connected"))
        binding.recycler.adapter = adapter
        adapter.updateData(list)
    }


}