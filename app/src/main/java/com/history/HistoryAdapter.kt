package com.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.remote.LoveModel

class HistoryAdapter(): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val data = arrayListOf<LoveModel>()

    fun addTasks(list:List<LoveModel>){
        data.clear()
        data.addAll(list)
        data.sortByDescending { it.id }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.
        from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(loveModel: LoveModel) {
            binding.tvFFirstName.text = loveModel.firstName
            binding.tvFSecondName.text = loveModel.secondName
            binding.tvPercentage.text = loveModel.percentage
        }
    }
}
