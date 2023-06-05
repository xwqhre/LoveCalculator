package com

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        clickHistory()

    }
    private fun clickHistory(){
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyActivity)
        }
    }
    private fun initClicker() {
        with(binding) {
            btnCalc.setOnClickListener {
                if (edYou.text.isNotEmpty() && edMe.text.isNotEmpty()) {
                    viewModel.getLiveLove(edYou.text.toString(), edMe.text.toString())
                        .observe(viewLifecycleOwner) { loveModel ->
                            Log.d("ololo", "initClicker: $loveModel")
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf("result" to loveModel)
                            )
                            App.appDatabase.getDao().insert(loveModel)
                        }
                }
            }
        }
    }
}
