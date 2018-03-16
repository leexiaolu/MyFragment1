package com.example.leesnriud.myfragment1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android fragment
 *
 * 使用linearlayout textview 实现了fragment
 * 
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_channel)
    TextView txtChannel;
    @BindView(R.id.txt_message)
    TextView txtMessage;
    @BindView(R.id.txt_better)
    TextView txtBetter;
    @BindView(R.id.txt_setting)
    TextView txtSetting;
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;

    @BindView(R.id.ly_content)
    FrameLayout lyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //隐藏顶部导航栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fManager = getFragmentManager();
        txtChannel.performClick();//模拟一次点击

    }

    //重置所有文本的选中状态
    private void setSelected() {
        txtChannel.setSelected(false);
        txtMessage.setSelected(false);
        txtBetter.setSelected(false);
        txtSetting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }

    @OnClick({R.id.txt_channel, R.id.txt_message, R.id.txt_better, R.id.txt_setting})
    public void onViewClicked(View view) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()) {
            case R.id.txt_channel:
                setSelected();
                txtChannel.setSelected(true);
                if(fg1 == null){
                    fg1 = new MyFragment("提醒");
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.txt_message:
                setSelected();
                txtMessage.setSelected(true);
                if(fg2 == null){
                    fg2 = new MyFragment("信息");
                    fTransaction.add(R.id.ly_content,fg2);
                }else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.txt_better:
                setSelected();
                txtBetter.setSelected(true);
                if(fg3 == null){
                    fg3 = new MyFragment("我的");
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;
            case R.id.txt_setting:
                setSelected();
                txtSetting.setSelected(true);
                if(fg4 == null){
                    fg4 = new MyFragment("设置");
                    fTransaction.add(R.id.ly_content,fg4);
                }else{
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }
}
