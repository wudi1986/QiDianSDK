package demo.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.news.yazhidao.pages.MainAty;

public class MainActivity extends AppCompatActivity {
    RelativeLayout newsLayout;
    MainView mainView;
    private TextView mFirstAndTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity 跳转
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MainAty.class);
                MainActivity.this.startActivity(in);
            }
        });
        mFirstAndTop = (TextView)findViewById(R.id.mFirstAndTop);
        mFirstAndTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainView.backFirstItemAndRefreshData();
            }
        });
        //添加View
        newsLayout = (RelativeLayout)findViewById(R.id.newsLayout);
        mainView = new MainView(this); //传入的activity是FragmentActivity
        newsLayout.addView(mainView.getNewsView());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //设置频道的回调
        mainView.onActivityResult(requestCode, resultCode, data);
    }
}
