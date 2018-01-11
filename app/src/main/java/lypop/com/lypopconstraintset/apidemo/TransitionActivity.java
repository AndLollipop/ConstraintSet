package lypop.com.lypopconstraintset.apidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import lypop.com.lypopconstraintset.R;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {
    private TransitionManager transitionManager;
    private Scene mScene1, mScene2, mScene3;
    private ViewGroup relativelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        relativelayout = findViewById(R.id.container);

        Button scene01 = findViewById(R.id.scene01);
        scene01.setOnClickListener(this);
        Button scene02 = findViewById(R.id.scene02);
        scene02.setOnClickListener(this);
        Button scene03 = findViewById(R.id.scene03);
        scene03.setOnClickListener(this);
        Button scene04 = findViewById(R.id.scene03);
        scene04.setOnClickListener(this);
        mScene1 = Scene.getSceneForLayout(relativelayout, R.layout.transition_scene1, this);
        mScene2 = Scene.getSceneForLayout(relativelayout, R.layout.transition_scene2, this);
        mScene3 = Scene.getSceneForLayout(relativelayout, R.layout.transition_scene3, this);

        TransitionInflater inflater = TransitionInflater.from(this);
        transitionManager = inflater.inflateTransitionManager(R.transition.activity_transition_mgr, relativelayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene01:
                transitionManager.transitionTo(mScene1);
                break;
            case R.id.scene02:
                transitionManager.transitionTo(mScene2);
                break;
            case R.id.scene03:
                transitionManager.transitionTo(mScene3);
                break;
            case R.id.scene04:
                TransitionManager.beginDelayedTransition(relativelayout);
                setNewSize(R.id.iv_kongjian, 30, 30);
                setNewSize(R.id.iv_qq, 30, 30);
                setNewSize(R.id.iv_wechat, 30, 30);
                setNewSize(R.id.iv_tw, 30, 30);
                break;
        }
    }

    private void setNewSize(int id, int width, int height) {
        View view = findViewById(id);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }
}
