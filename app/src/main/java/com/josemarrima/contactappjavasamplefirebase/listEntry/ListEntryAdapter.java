package com.josemarrima.contactappjavasamplefirebase.listEntry;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.josemarrima.contactappjavasamplefirebase.data.Entry;
import com.josemarrima.contactappjavasamplefirebase.databinding.ListItemEntryBinding;

import java.util.List;

public class ListEntryAdapter extends RecyclerView.Adapter<ListEntryAdapter.ListEntryViewHolder> {

    private List<Entry> entries;

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListEntryAdapter.ListEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemEntryBinding binding = ListItemEntryBinding.inflate(layoutInflater, parent, false);
        return new ListEntryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListEntryAdapter.ListEntryViewHolder holder, int position) {
        holder.bind(entries.get(position));
    }

    @Override
    public int getItemCount() {
        if(entries != null) {
            return entries.size();
        }
        return 0;
    }


    public class ListEntryViewHolder extends RecyclerView.ViewHolder {

        ListItemEntryBinding binding;
        public ListEntryViewHolder(@NonNull ListItemEntryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Entry entry) {
            binding.setEntry(entry);
            binding.executePendingBindings();
        }
    }
}
