package com

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.remote.LoveModel

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val result = arguments?.getSerializable("result") as LoveModel
            tvFirst.text = result.percentage + "%"
            tvSecond.text = result.secondName
            tvPercentage.text = result.percentage
            tvResult.text = result.result

            btnAgain.setOnClickListener {
                val bundle = Bundle().apply {
                    putBoolean("clearText", true)
                }
                findNavController().navigateUp()
            }
        }
    }
}