package lypop.com.lypopconstraintset;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

public class Layout02Activity extends AppCompatActivity {
    private ConstraintSet before;
    private ConstraintSet after;
    private ConstraintLayout constraintLayout;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout02);
        constraintLayout = findViewById(R.id.constraintLayout);
        before = new ConstraintSet();
        after = new ConstraintSet();
        before.clone(constraintLayout);
        after.clone(this, R.layout.activity_layout02_after);

        findViewById(R.id.btn_openAnim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                if(flag){
                    after.applyTo(constraintLayout);
                    flag = false;
                }else{
                    before.applyTo(constraintLayout);
                    flag = true;
                }
            }
        });
    }
}
