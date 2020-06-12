package com.example.droidcafev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private ArrayList<Recipe> recipeData;
    private Context myContext;

    public RecipeAdapter(ArrayList<Recipe> recipeData, Context myContext) {
        this.recipeData = recipeData;
        this.myContext = myContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe currentRecipe = recipeData.get(position);
        
        holder.bindTo(currentRecipe);
    }

    @Override
    public int getItemCount() {
        return recipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            myRecipeImage = itemView.findViewById(R.id.recipe_image);
            myRecipeTitle = itemView.findViewById(R.id.recipe_title);
            myRecipeDescription = itemView.findViewById(R.id.recipe_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int desertPosition = getAdapterPosition();
                    Recipe currentDessert = recipeData.get(desertPosition);

                    if (desertPosition == 0) {
                        Intent balutIntent = new Intent(myContext, BalutActivity.class);
                        balutIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        balutIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        balutIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(balutIntent);
                    }
                    else {
                        Toast.makeText(myContext, "create an activity for the dessert", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bindTo(Recipe currentRecipe) {
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());

        }
    }
}
