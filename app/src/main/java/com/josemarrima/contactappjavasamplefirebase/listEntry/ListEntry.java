package com.josemarrima.contactappjavasamplefirebase.listEntry;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.josemarrima.contactappjavasamplefirebase.data.Entry;
import com.josemarrima.contactappjavasamplefirebase.databinding.ListEntryFragmentBinding;
import java.util.List;

public class ListEntry extends Fragment {

    private static final String TAG = "ListEntry";
    private ListEntryViewModel mViewModel;
    private ListEntryAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //View view = inflater.inflate(R.layout.list_entry_fragment, container, false);

        ListEntryFragmentBinding binding = ListEntryFragmentBinding.inflate(inflater, container, false);

        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = ListEntryDirections.actionListEntryToAddEntry();
                Navigation.findNavController(view).navigate(action);
            }
        });

        adapter = new ListEntryAdapter();

        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ListEntryViewModel.class);


        if(mViewModel.getEntry() != null) {
            mViewModel.getEntry().observe(this, new Observer<List<Entry>>() {
                @Override
                public void onChanged(List<Entry> entries) {
                    Log.d(TAG, "onChanged: " + entries.toString());
                    adapter.setEntries(entries);
                }
            });
        }
    }

}
