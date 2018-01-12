package lypop.com.lypopconstraintset.apidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

        /*
            这个类用来管理场景变化所引起的转换集，其中调用对象setTransition(Scene, Transition) 或setTransition(Scene, Scene, Transition)
            场景变化的相应转化是不需要的，默认情况下使用autotransition,如果希望有不同的转换行为，只需要指定特定场景更改的其他转换。

            TransitionManagers可以在XML资源文件里面的res目录声明，transitionManager标签里面包含transition标签，描述从一个场景到另一个场景的转化
        */


        relativelayout = findViewById(R.id.container);

        Button scene01 = findViewById(R.id.scene01);
        scene01.setOnClickListener(this);
        Button scene02 = findViewById(R.id.scene02);
        scene02.setOnClickListener(this);
        Button scene03 = findViewById(R.id.scene03);
        scene03.setOnClickListener(this);
        Button scene04 = findViewById(R.id.scene04);
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
                //这种形式不是一个真正的场景，通过调用TransitionManager的beginDelayedTransition的方法来告诉TransitionManager在下一帧进行过渡变换
                TransitionManager.beginDelayedTransition(relativelayout);
                setNewSize(R.id.iv_kongjian, 30, 30);
                setNewSize(R.id.iv_qq, 30, 30);
                setNewSize(R.id.iv_wechat, 30, 30);
                setNewSize(R.id.iv_tw, 30, 30);
                break;
        }
    }

    private void setNewSize(int id, final int width, final int height) {
        final ImageView view = findViewById(id);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);

    }
}
