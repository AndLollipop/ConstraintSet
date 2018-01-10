package lypop.com.lypopconstraintset;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class LayoutActivity extends AppCompatActivity {
    private Button btn_apply;
    private Button btn_reset;
    private ConstraintLayout constraint_layout;
    ConstraintSet beforeSet;
    ConstraintSet afterSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.before);

        btn_apply = findViewById(R.id.btn_apply);
        constraint_layout = findViewById(R.id.constraint_layout);
        beforeSet = new ConstraintSet();
        afterSet = new ConstraintSet();
        beforeSet.clone(constraint_layout);
        afterSet.clone(this, R.layout.after);
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(constraint_layout);
                afterSet.applyTo(constraint_layout);
            }
        });

        btn_reset = findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(constraint_layout);
                beforeSet.applyTo(constraint_layout);
            }
        });

    }
}
