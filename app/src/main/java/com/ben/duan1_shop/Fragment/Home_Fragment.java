package com.ben.duan1_shop.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ben.duan1_shop.Adapter.HienthiAdapter;
import com.ben.duan1_shop.Model.Hienthi;
import com.ben.duan1_shop.R;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {
    View v;
    ViewFlipper viewFlipper;
   private RecyclerView recyclerView;


   public Home_Fragment(){}

    int image[]=new int[]{R.drawable.hinh1,R.drawable.hinh2,R.drawable.hinh3,R.drawable.hinh4};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.home_fragment,container,false);

        viewFlipper = (ViewFlipper)view.findViewById(R.id.viewflip);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data fro recycler view
        Hienthi itemsData[] = {
                new Hienthi("Indigo", R.drawable.hinh1),
                new Hienthi("Red", R.drawable.hinh2),
                new Hienthi("Blue", R.drawable.hinh1),
                new Hienthi("Green", R.drawable.hinh1),
                new Hienthi("Green", R.drawable.hinh1),

                new Hienthi("Green", R.drawable.hinh1),

                new Hienthi("Green", R.drawable.hinh1)


        };


        // 3. create an adapter
        HienthiAdapter mAdapter = new HienthiAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        for(int i=0; i<image.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(image[i]);
        }


        return view;
    }

    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
