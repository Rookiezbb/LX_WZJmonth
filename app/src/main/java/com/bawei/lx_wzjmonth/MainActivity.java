package com.bawei.lx_wzjmonth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lx_wzjmonth.Goods.view.GoodActivity;
import com.bawei.lx_wzjmonth.login.LoginBean;
import com.bawei.lx_wzjmonth.login.LoginConstract;
import com.bawei.lx_wzjmonth.login.LoginPresenter;
import com.bawei.lx_wzjmonth.utils.Api;
import com.bawei.lx_wzjmonth.utils.Toasts;
import com.bawei.lx_wzjmonth.zhuce.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginConstract.ILoginView {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.login_user)
    EditText loginUser;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_tv_Sign_up)
    TextView loginTvSignUp;
    @BindView(R.id.login_tv_retrieve_password)
    TextView loginTvRetrievePassword;
    private LoginPresenter loginPresenter;
    private long firstTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick({R.id.login_back, R.id.login_btn, R.id.login_tv_Sign_up, R.id.login_tv_retrieve_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                //finish();
                break;
            case R.id.login_btn:
                String mobile = loginUser.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                loginPresenter.onSignUp(Api.UserURL, mobile, pwd);
                break;
            case R.id.login_tv_Sign_up:
                Intent in = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(in);
                break;
            case R.id.login_tv_retrieve_password:
                break;
        }
    }

    @Override
    public void showLogin(LoginBean.DataBean db) {

        Toasts.showLong(this, "登录成功");
        if(db!=null){
            startActivity(new Intent(MainActivity.this, GoodActivity.class));
        }
        //finish();
    }

    @Override
    public void showerroe(String e) {
        Toasts.showLong(this, e);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
