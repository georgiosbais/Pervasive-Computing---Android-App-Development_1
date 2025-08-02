package pervasivecomputing.example.recipefinder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecipesCategoryFragment extends Fragment {

    public interface OnCategorySelectedListener {
        void onCategorySelected(String category);
    }

    private OnCategorySelectedListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnCategorySelectedListener) {
            listener = (OnCategorySelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement OnCategorySelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipes_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioGroup radioGroup = view.findViewById(R.id.category_group);
        Button btnContinue = view.findViewById(R.id.btn_select_category);

        btnContinue.setOnClickListener(v -> {
            int checkedId = radioGroup.getCheckedRadioButtonId();
            if (checkedId != -1) {
                RadioButton rb = view.findViewById(checkedId);
                String category = rb.getText().toString();
                listener.onCategorySelected(category);
            }
        });
    }
}