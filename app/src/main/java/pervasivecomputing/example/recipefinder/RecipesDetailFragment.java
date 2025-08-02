package pervasivecomputing.example.recipefinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecipesDetailFragment extends Fragment {

    private TextView tvRecipeDetails;
    private Button btnViewWebsite, btnViewVideo;

    private static final String ARG_RECIPE_ID = "recipeId";

    private String category;
    private String recipeName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recipes_detail, container, false);

        tvRecipeDetails = rootView.findViewById(R.id.tv_recipe_details);
        btnViewWebsite = rootView.findViewById(R.id.btn_view_website);
        btnViewVideo = rootView.findViewById(R.id.btn_view_video);

        if (getArguments() != null) {
            category = getArguments().getString("category");
            recipeName = getArguments().getString("recipeName");
        }

        loadRecipeDetails();

        return rootView;
    }

    private void loadRecipeDetails() {
        if (category == null || recipeName == null) return;

        DataRepository.Recipe recipe = DataRepository.getRecipeByName(category, recipeName);
        if (recipe == null) return;

        tvRecipeDetails.setText(recipe.details);

        btnViewWebsite.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.url));
            startActivity(browserIntent);
        });

        btnViewVideo.setOnClickListener(v -> {
            Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.videoUrl));
            startActivity(videoIntent);
        });
    }

    public static RecipesDetailFragment newInstance(String category, String recipeName) {
        RecipesDetailFragment fragment = new RecipesDetailFragment();
        Bundle args = new Bundle();
        args.putString("category", category);
        args.putString("recipeName", recipeName);
        fragment.setArguments(args);
        return fragment;
    }
}