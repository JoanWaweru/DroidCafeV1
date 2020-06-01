package com.example.droidcafev1;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DessertRecipeFragment extends Fragment {
    private RecyclerView dessertsRecyclerView;
    private ArrayList<Recipe> dessertRecipeData;
    private RecipeAdapter dessertAdapter;

    public DessertRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dessert_recipe, container, false);

        dessertsRecyclerView = rootView.findViewById(R.id.recycler_desert);
        dessertsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dessertRecipeData = new ArrayList<>();
        dessertAdapter = new RecipeAdapter(dessertRecipeData, getContext());
        dessertsRecyclerView.setAdapter(dessertAdapter);
        initializeData();
        return rootView;
    }

    private void initializeData() {
        String[] dessertTitles = getResources().getStringArray(R.array.desserts_titles);
        String[] dessertDescriptions = getResources().getStringArray(R.array.desserts_descritions);
        TypedArray dessertImages = getResources().obtainTypedArray(R.array.desserts_images);

        dessertRecipeData.clear();

        for (int i = 0; i < dessertTitles.length; i++) {
            dessertRecipeData.add(new Recipe(dessertImages.getResourceId(i,0), dessertTitles[i], dessertDescriptions[i]));
        }

        dessertImages.recycle();
        dessertAdapter.notifyDataSetChanged();
    }
}
