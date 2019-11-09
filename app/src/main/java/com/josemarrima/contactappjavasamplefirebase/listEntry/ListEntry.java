package com.josemarrima.contactappjavasamplefirebase.listEntry;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.josemarrima.contactappjavasamplefirebase.databinding.ListEntryFragmentBinding;

public class ListEntry extends Fragment {

    private ListEntryViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ListEntryFragmentBinding binding = ListEntryFragmentBinding.inflate(inflater, container, false);

        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = ListEntryDirections.actionListEntryToAddEntry();
                Navigation.findNavController(view).navigate(action);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ListEntryViewModel.class);
        // TODO: Use the ViewModel

    }

}
