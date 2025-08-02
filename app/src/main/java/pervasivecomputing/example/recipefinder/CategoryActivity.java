package pervasivecomputing.example.recipefinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class CategoryActivity extends AppCompatActivity
        implements RecipesCategoryFragment.OnCategorySelectedListener,
        RecipesListFragment.OnRecipeSelectedListener {

    private boolean isLandscape;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isLandscape = getResources().getBoolean(R.bool.is_landscape);

        if (isLandscape) {
            setContentView(R.layout.activity_category);

            FragmentManager fm = getSupportFragmentManager();

            fm.beginTransaction()
                    .replace(R.id.category_fragment_container, new RecipesCategoryFragment())
                    .commit();
        } else {
            setContentView(R.layout.activity_category_portrait);

            RadioGroup rg = findViewById(R.id.category_group);
            Button btn = findViewById(R.id.btn_select_category);

            btn.setOnClickListener(v -> {
                int id = rg.getCheckedRadioButtonId();
                if (id != -1) {
                    String category = ((RadioButton) findViewById(id)).getText().toString();
                    Intent i = new Intent(this, RecipesListActivity.class);
                    i.putExtra("category", category);
                    startActivity(i);
                }
            });
        }
    }

    @Override
    public void onCategorySelected(String selectedCategory) {
        this.category = selectedCategory;

        RecipesListFragment listFragment = RecipesListFragment.newInstance(category);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recipe_list_fragment_container, listFragment)
                .commit();
    }

    @Override
    public void onRecipeSelected(String recipeName) {
        RecipesDetailFragment detail = RecipesDetailFragment.newInstance(category, recipeName);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recipe_detail_fragment_container, detail)
                .commit();
    }
}