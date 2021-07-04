package com.mikef.lastfm.shared.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import java.util.*

abstract class BaseDelegateAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val asyncListDiffer =
        AsyncListDiffer<AdapterData<*>>(
            this,
            DefaultAdapterDataDiffCallback()
        )

    protected var delegatesManager = AdapterDelegatesManager<List<AdapterData<*>>>()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder =
        delegatesManager.onCreateViewHolder(viewGroup, viewType)

    override fun onBindViewHolder(
        viewHolder: RecyclerView.ViewHolder,
        position: Int
    ) {
        delegatesManager.onBindViewHolder(asyncListDiffer.currentList, position, viewHolder)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    override fun getItemViewType(position: Int): Int =
        delegatesManager.getItemViewType(asyncListDiffer.currentList, position)

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewDetachedFromWindow(holder)
    }

    fun submitList(newList: List<AdapterData<*>>) {
        asyncListDiffer.submitList(newList)
    }

    fun getItems(): List<AdapterData<*>> {
        return asyncListDiffer.currentList
    }

    fun onItemMove(fromPosition: Int, toPosition: Int) {
        val currentList = getItems().toMutableList()
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(currentList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(currentList, i, i - 1)
            }
        }
        submitList(currentList)
    }

}