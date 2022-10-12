package com.example.githubclosedpullrequestsapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclosedpullrequestsapp.databinding.ItemPullResponseBinding
import com.example.githubclosedpullrequestsapp.model.GithubPullRequestResponseItem

class PullResponseAdapter :
    ListAdapter<GithubPullRequestResponseItem, PullResponseAdapter.PullResponseViewHolder>(DiffCallBack) {

    class PullResponseViewHolder(private val binding: ItemPullResponseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(githubPullRequestResponseItem: GithubPullRequestResponseItem) {
            binding.pullResponseItem = githubPullRequestResponseItem
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<GithubPullRequestResponseItem>() {
        override fun areItemsTheSame(oldItem: GithubPullRequestResponseItem, newItem: GithubPullRequestResponseItem): Boolean {
            return newItem === oldItem
        }

        override fun areContentsTheSame(oldItem: GithubPullRequestResponseItem, newItem: GithubPullRequestResponseItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PullResponseViewHolder {
        return PullResponseViewHolder(ItemPullResponseBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PullResponseViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}