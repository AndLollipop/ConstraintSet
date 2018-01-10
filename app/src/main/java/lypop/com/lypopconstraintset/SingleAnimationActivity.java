package lypop.com.lypopconstraintset;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class SingleAnimationActivity extends AppCompatActivity {
    private ImageView ivCenter;
    private ConstraintLayout constraintlayout;

    private ImageView ivLT;
    private ImageView ivLB;
    private ImageView ivRT;
    private ImageView ivRB;

    private int number = -300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_animation);

        ivCenter = findViewById(R.id.iv_center);
        ivLT = findViewById(R.id.iv_tw);
        ivLB = findViewById(R.id.iv_qq);
        ivRT = findViewById(R.id.iv_wechat);
        ivRB = findViewById(R.id.iv_kongjian);
        constraintlayout = findViewById(R.id.constraintlayout);
        ivCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 加入加速器
                /*Minimum API Level should be 19 for this effect*/
                Transition changeBounds = new ChangeBounds();
                changeBounds.setDuration(1000);
                changeBounds.setInterpolator(new BounceInterpolator());
                TransitionManager.beginDelayedTransition(constraintlayout, changeBounds);

                //TransitionManager.beginDelayedTransition(constraintayout);
                ConstraintSet set = new ConstraintSet();

                changeImageView();

                set.applyTo(constraintlayout);  // 将约束设置到ConstraintLayout
            }
        });
    }

    private void changeImageView() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) ivLT.getLayoutParams();
        number = -1 * number;
        params.circleRadius = params.circleRadius + number;
        ivLT.setLayoutParams(params);

        params = (ConstraintLayout.LayoutParams) ivLB.getLayoutParams();
        params.circleRadius = params.circleRadius + number;
        ivLB.setLayoutParams(params);

        params = (ConstraintLayout.LayoutParams) ivRT.getLayoutParams();
        params.circleRadius = params.circleRadius + number;
        ivRT.setLayoutParams(params);

        params = (ConstraintLayout.LayoutParams) ivRB.getLayoutParams();
        params.circleRadius = params.circleRadius + number;
        ivRB.setLayoutParams(params);
    }
}
