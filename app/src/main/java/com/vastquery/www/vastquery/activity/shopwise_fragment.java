package com.vastquery.www.vastquery.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.vastquery.www.vastquery.DatabaseConnection.GetResources;
import com.vastquery.www.vastquery.R;
import com.vastquery.www.vastquery.helper.GridAdapter;
import com.vastquery.www.vastquery.helper.GridSpacingItemDecoration;
import com.vastquery.www.vastquery.helper.MyAdapter;


public class shopwise_fragment  extends Fragment{

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    String[] names={"Automobile","Bakeries","Beauty salon","Book shop","Butcher shop","Computers showroom",
            "Fruit & vegetables","Furniture Shop","Gift shop", "Jewelry Shop","Mobile showroom","Pet shop","Printing shop",
            "Utensils shop"};

    int[] images={R.drawable.automobileshop,
            R.drawable.bakeryshop,
            R.drawable.beautysalon,
            R.drawable.bookshop,
            R.drawable.butchershop,
            R.drawable.computers,
            R.drawable.fruitshop,
            R.drawable.furniture,
            R.drawable.gift,
            R.drawable.jewelry,
            R.drawable.mobiles,
            R.drawable.petshop,
            R.drawable.printingshop,
            R.drawable.utensils};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_activity, container, false);

        Context context = view.getContext();
        recyclerView = view.findViewById(R.id.recyler_view);
        gridLayoutManager = new GridLayoutManager(context,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        GetResources getResources = new GetResources(context,recyclerView,"G_1");
        getResources.execute();

        return view;

    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
