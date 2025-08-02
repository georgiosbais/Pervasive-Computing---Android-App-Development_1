package pervasivecomputing.example.recipefinder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.List;

public class RecipesListFragment extends ListFragment {

    private static final String ARG_CATEGORY = "category";
    private String category;
    private OnRecipeSelectedListener listener;

    public interface OnRecipeSelectedListener {
        void onRecipeSelected(String recipeName);
    }

    public static RecipesListFragment newInstance(String category) {
        RecipesListFragment fragment = new RecipesListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnRecipeSelectedListener) {
            listener = (OnRecipeSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement OnRecipeSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getString(ARG_CATEGORY);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> recipes = DataRepository.getRecipeNamesForCategory(category);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                recipes
        );
        setListAdapter(adapter);

        getListView().setOnItemClickListener((AdapterView<?> parent, View v, int position, long id) -> {
            String recipeName = getListAdapter().getItem(position).toString();
            listener.onRecipeSelected(recipeName);
        });
    }
}
