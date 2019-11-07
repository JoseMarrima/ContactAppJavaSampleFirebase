package com.josemarrima.contactappjavasamplefirebase.ListEntry;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josemarrima.contactappjavasamplefirebase.R;

public class ListEntry extends Fragment {

    private ListEntryViewModel mViewModel;

    public static ListEntry newInstance() {
        return new ListEntry();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_entry_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ListEntryViewModel.class);
        // TODO: Use the ViewModel
    }

}
