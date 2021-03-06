package com.example.tiktoklayout.discover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tiktoklayout.R;

public class DiscoverFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_discover, container, false);
        RecyclerView recyclerViewOne = view.findViewById(R.id.recyclerViewOne);
        RecyclerView recyclerViewTwo = view.findViewById(R.id.recyclerViewTwo);
        ViewPager2 viewPager2 = view.findViewById(R.id.discover_viewpager2);

        DiscoverAdapter adapter = new DiscoverAdapter();
        DiscoverTopAdapter topAdapter = new DiscoverTopAdapter();
        LinearLayoutManager linearLayoutManagerTop = new LinearLayoutManager(getActivity());
        LinearLayoutManager linearLayoutManagerOne = new LinearLayoutManager(getActivity());
        LinearLayoutManager linearLayoutManagerTwo = new LinearLayoutManager(getActivity());
        linearLayoutManagerTop.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManagerOne.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManagerTwo.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewOne.setAdapter(adapter);
        recyclerViewTwo.setAdapter(adapter);
        viewPager2.setAdapter(topAdapter);
        recyclerViewOne.setLayoutManager(linearLayoutManagerOne);
        recyclerViewTwo.setLayoutManager(linearLayoutManagerTwo);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        return view;
    }
}
