package com.josemarrima.contactappjavasamplefirebase.detailEntry;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josemarrima.contactappjavasamplefirebase.R;

public class DetailEntry extends Fragment {

    private DetailEntryViewModel mViewModel;

    public static DetailEntry newInstance() {
        return new DetailEntry();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_entry_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DetailEntryViewModel.class);
        // TODO: Use the ViewModel
    }

}
