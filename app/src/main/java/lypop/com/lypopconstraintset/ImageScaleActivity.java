package lypop.com.lypopconstraintset;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ImageScaleActivity extends AppCompatActivity {
    private ConstraintLayout constraintlayout;
    private ImageView iv_img;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);

        iv_img = findViewById(R.id.iv_img);
        constraintlayout = findViewById(R.id.constraintlayout);

        iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintSet set = new ConstraintSet();
                set.clear(R.id.iv_img);
                if(flag){
                    set.connect(R.id.iv_img, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
                    set.connect(R.id.iv_img, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
                    set.connect(R.id.iv_img, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
                    set.connect(R.id.iv_img, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
                    set.constrainHeight(R.id.iv_img, 0);
                    set.constrainWidth(R.id.iv_img, 0);
                    set.setDimensionRatio(R.id.iv_img, "W,1:1");
                    flag = false;
                }else{
                    flag = true;
                }
                set.applyTo(constraintlayout);
            }
        });
    }
}
