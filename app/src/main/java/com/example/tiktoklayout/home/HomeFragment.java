package com.example.tiktoklayout.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tiktoklayout.MainActivity;
import com.example.tiktoklayout.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_home, container, false);
        ViewPager2 viewPager2 = view.findViewById(R.id.home_fragment_viewpager);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        VideoAdapter adapter  = new VideoAdapter();
        viewPager2.setAdapter(adapter);

        //String packageName = ((MainActivity) getActivity()).getPackageName();
        //Log.e("TAG", packageName);

        return view;
    }
}
