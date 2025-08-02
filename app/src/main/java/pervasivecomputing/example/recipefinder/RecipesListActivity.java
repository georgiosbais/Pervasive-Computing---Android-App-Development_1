package pervasivecomputing.example.recipefinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RecipesListActivity extends AppCompatActivity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);

        category = getIntent().getStringExtra("category");
        List<String> names = DataRepository.getRecipeNamesForCategory(category);

        ListView lv = findViewById(R.id.lv_recipes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, names);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((AdapterView<?> parent, View view, int pos, long id) -> {
            String name = names.get(pos);
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("category", category);
            i.putExtra("recipeName", name);
            startActivity(i);
        });
    }
}