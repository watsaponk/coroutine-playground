package me.watsaponk.coroutineplayground.explorelist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.watsaponk.coroutineplayground.databinding.ItemExploreSubjectBinding
import me.watsaponk.coroutineplayground.explorelist.presentation.model.ExploreSubjectUiModel

class ExploreSubjectAdapter : ListAdapter<ExploreSubjectUiModel, ExploreSubjectAdapter.ViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExploreSubjectBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemExploreSubjectBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(uiModel: ExploreSubjectUiModel) {
            binding.textviewDisplay.text = uiModel.display
        }

    }

    companion object {

        val DIFF_UTIL = object : DiffUtil.ItemCallback<ExploreSubjectUiModel>() {

            override fun areItemsTheSame(oldItem: ExploreSubjectUiModel, newItem: ExploreSubjectUiModel): Boolean {
                return oldItem.display == newItem.display
            }

            override fun areContentsTheSame(oldItem: ExploreSubjectUiModel, newItem: ExploreSubjectUiModel): Boolean {
                return oldItem == newItem
            }

        }

    }

}