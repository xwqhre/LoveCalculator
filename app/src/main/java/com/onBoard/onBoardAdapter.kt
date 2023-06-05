package com.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnboardBinding

    class OnBoardAdapter(private val onClick: () -> Unit) :
        Adapter<OnBoardAdapter.OnBoardViewHolder>() {

        private val data = arrayListOf(
            onBoardModel(
                "Have a good time!",
                "You should take the time to help those \n" +
                        " who who need you",
                R.drawable.img_onboard_first
            ),
            onBoardModel(
                "Cherishing love",
                "It is now no longer possible for\nyou to cherish love",
                R.drawable.img_onboard_second
            ),
            onBoardModel(
                "Have a breakup?",
                "We have made the correction for you\n" +
                        " don't worry\n" +
                        " Maybe someone is waiting for you!",
                R.drawable.img_onboard_hird
            ),
            onBoardModel(
                "It's Funs and Many more",
                " ",
                R.drawable.love_person
            )
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
            return OnBoardViewHolder(
                ItemOnboardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
            holder.onBind(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }

        inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
            ViewHolder(binding.root) {

            fun onBind(onBoardModel: onBoardModel) {
                binding.btnStart.setOnClickListener {
                    onClick()
                }
                binding.btnStart.isVisible = adapterPosition == data.lastIndex
                binding.tvBoard.text = onBoardModel.title
                binding.tvDesc.text = onBoardModel.desc
                onBoardModel.img?.let { binding.imgBoard.setImageResource(it) }
            }
        }
    }
