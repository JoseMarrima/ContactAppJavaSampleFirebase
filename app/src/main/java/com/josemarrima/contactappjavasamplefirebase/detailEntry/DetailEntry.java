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
import com.josemarrima.contactappjavasamplefirebase.databinding.DetailEntryFragmentBinding;

public class DetailEntry extends Fragment {

    private DetailEntryViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        DetailEntryFragmentBinding binding = DetailEntryFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DetailEntryViewModel.class);
    }

}
