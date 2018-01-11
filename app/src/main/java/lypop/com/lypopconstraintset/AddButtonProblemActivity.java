package lypop.com.lypopconstraintset;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddButtonProblemActivity extends AppCompatActivity {
    private ConstraintLayout constraintlayout;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button_problem);

        constraintlayout = findViewById(R.id.constraintlayout);
        findViewById(R.id.btn_addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 0) {
                    ConstraintSet set1 = new ConstraintSet();
                    Button button1 = new Button(AddButtonProblemActivity.this);
                    button1.setId(R.id.button1);
                    button1.setText("111111");
                    constraintlayout.addView(button1);
                    set1.constrainWidth(button1.getId(), ConstraintSet.WRAP_CONTENT);
                    set1.constrainHeight(button1.getId(), ConstraintSet.WRAP_CONTENT);
                    set1.connect(button1.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
                    set1.connect(button1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 100);
                    set1.connect(button1.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
                    set1.connect(button1.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
                    set1.applyTo(constraintlayout);
                    num = 1;
                } else if (num == 1) {
                    ConstraintSet set2 = new ConstraintSet();
                    Button button2 = new Button(AddButtonProblemActivity.this);
                    button2.setId(R.id.button2);
                    button2.setText("22222222");
                    constraintlayout.addView(button2);
                    set2.constrainWidth(button2.getId(), ConstraintSet.WRAP_CONTENT);
                    set2.constrainHeight(button2.getId(), ConstraintSet.WRAP_CONTENT);
                    set2.connect(button2.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
                    set2.connect(button2.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
                    set2.connect(button2.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
                    set2.connect(button2.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
                    set2.applyTo(constraintlayout);
                }
            }
        });
    }
}
