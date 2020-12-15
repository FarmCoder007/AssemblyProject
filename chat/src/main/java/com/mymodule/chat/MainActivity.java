package com.mymodule.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.appcompat.app.AppCompatActivity;

/**
 * author : xu
 * date : 2020/12/10 19:23
 * description :
 */
@Route(path = "/chat/MainActivity")
public class MainActivity extends AppCompatActivity {
    private TextView text;

    @Autowired
    public String key3;
    @Autowired
    public long key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, "收到传送过来的数据：" + key3+key1, Toast.LENGTH_LONG).show();
        text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
