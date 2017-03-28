package com.example.jh.sharedprefercnce;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName,etPass;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//		//进入界面显示用户信息
//		String name = shared.getString("name", null);
//		String pass = shared.getString("pass", null);
//		Toast.makeText(this, name +"\n" + pass, Toast.LENGTH_SHORT).show();


        findViewById(R.id.button1).setOnClickListener(this);
        etName = (EditText) findViewById(R.id.editText1);
        etPass = (EditText) findViewById(R.id.editText2);
        cb = (CheckBox) findViewById(R.id.checkBox1);

        boolean isSave = this.getSharedPreferences("用户信息", Context.MODE_PRIVATE)
                .getBoolean("isSave", false);
        if (isSave) {
            // 读取数据
            String name = this.getSharedPreferences("用户信息", Context.MODE_PRIVATE)
                    .getString("name", "");
            String pass = this.getSharedPreferences("用户信息", Context.MODE_PRIVATE)
                    .getString("pass", "");

            etName.setText(name);
            etPass.setText(pass);
            cb.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        boolean isSave = cb.isChecked();

        // 保存数据
        String name = etName.getText().toString();
        String pass = etPass.getText().toString();

        this.getSharedPreferences("用户信息", Context.MODE_PRIVATE).edit()
                .putString("name", name)
                .putString("pass", pass)
                .putBoolean("isSave", isSave)
                .commit();

        finish();


    }

}
