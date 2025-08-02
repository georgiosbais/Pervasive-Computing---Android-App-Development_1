package pervasivecomputing.example.recipefinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    TextView tvCategoryTitle, tvRecipeDetails;
    LinearLayout recipeButtonsContainer;
    Button btnViewWebsite, btnViewVideo;

    String selectedCategory;
    String selectedRecipeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        tvCategoryTitle = findViewById(R.id.tv_recipe_title);
        tvRecipeDetails = findViewById(R.id.tv_recipe_details);
        recipeButtonsContainer = findViewById(R.id.recipe_buttons_container);
        btnViewWebsite = findViewById(R.id.btn_view_website);
        btnViewVideo = findViewById(R.id.btn_view_video);

        selectedCategory = getIntent().getStringExtra("category");
        selectedRecipeName = getIntent().getStringExtra("recipeName");

        tvCategoryTitle.setText(selectedRecipeName);

        List<DataRepository.Recipe> recipes = DataRepository.CATEGORY_MAP.get(selectedCategory);

        if (selectedRecipeName != null) {
            DataRepository.Recipe selectedRecipe = DataRepository.getRecipeByName(selectedCategory, selectedRecipeName);
            if (selectedRecipe != null) {
                showRecipe(selectedRecipe);
            } else {
                showRecipeList(recipes);
            }
        } else {
            showRecipeList(recipes);
        }
    }

    private void showRecipeList(List<DataRepository.Recipe> recipes) {
        recipeButtonsContainer.removeAllViews();
        if (recipes != null) {
            for (DataRepository.Recipe recipe : recipes) {
                Button btn = new Button(this);
                btn.setText(recipe.name);
                btn.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_purple));
                btn.setTextColor(getResources().getColor(android.R.color.white));
                btn.setOnClickListener(v -> showRecipe(recipe));
                recipeButtonsContainer.addView(btn);
            }
        }
    }

    private void showRecipe(DataRepository.Recipe recipe) {
        tvRecipeDetails.setVisibility(View.VISIBLE);
        tvRecipeDetails.setText(recipe.details);

        btnViewWebsite.setVisibility(View.VISIBLE);
        btnViewVideo.setVisibility(View.VISIBLE);

        btnViewWebsite.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.url));
            startActivity(browserIntent);
        });

        btnViewVideo.setOnClickListener(v -> {
            Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.videoUrl));
            startActivity(videoIntent);
        });
    }
}