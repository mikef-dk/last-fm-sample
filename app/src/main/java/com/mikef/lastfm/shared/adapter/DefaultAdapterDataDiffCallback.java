package com.mikef.lastfm.shared.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class DefaultAdapterDataDiffCallback extends DiffUtil.ItemCallback<AdapterData> {

    @Override
    public boolean areItemsTheSame(@NonNull AdapterData oldItem, @NonNull AdapterData newItem) {
        return newItem.getClass().equals(oldItem.getClass())
                && newItem.isItemTheSame(oldItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull AdapterData oldItem, @NonNull AdapterData newItem) {
        return Objects.equals(oldItem, newItem);
    }
}
