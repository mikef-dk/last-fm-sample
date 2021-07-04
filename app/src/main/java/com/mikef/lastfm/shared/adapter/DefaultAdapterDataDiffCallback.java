package com.mikef.lastfm.shared.adapter;

import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class DefaultAdapterDataDiffCallback extends DiffUtil.ItemCallback<AdapterData> {

    @Override
    public boolean areItemsTheSame(AdapterData oldItem, AdapterData newItem) {
        return newItem.getClass().equals(oldItem.getClass())
                && newItem.isItemTheSame(oldItem);
    }

    @Override
    public boolean areContentsTheSame(AdapterData oldItem, AdapterData newItem) {
        return Objects.equals(oldItem, newItem);
    }
}
