package com.example.tiktoklayout.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tiktoklayout.MainActivity;
import com.example.tiktoklayout.R;

public class HomeFragment extends Fragment {

    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_home, container, false);
        VideoAdapter adapter  = new VideoAdapter();

        viewPager2 = view.findViewById(R.id.home_fragment_viewpager);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroy() {
        viewPager2.setAdapter(null);
        super.onDestroy();
    }
}
