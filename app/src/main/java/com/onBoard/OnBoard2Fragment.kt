package com.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.LoveViewModel
import com.Pref
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoard2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoard2Fragment : Fragment() {

    private lateinit var binding: FragmentOnBoard2Binding
    private lateinit var adapter: OnBoardAdapter
    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoard2Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = OnBoardAdapter(this::onClick)

        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        if (pref.isUserSeen()) {
            findNavController().navigate(R.id.firstFragment)
        }

    }

    private fun onClick() {
        pref.isUserSeenOnBoard()
        findNavController().navigate(R.id.onBoardFragment)

    }
}