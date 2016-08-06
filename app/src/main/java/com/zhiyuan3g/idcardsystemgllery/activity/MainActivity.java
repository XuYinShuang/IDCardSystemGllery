package com.zhiyuan3g.idcardsystemgllery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhiyuan3g.idcardsystemgllery.R;
import com.zhiyuan3g.idcardsystemgllery.utils.Util;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtCountry, edtShenfen, edtAddress;
    Button btnOK;
    TextView txtBirth;
    RadioGroup radioGroup;
    RadioButton radioGirl, radioBoy;
    ImageView imageView;
    String sex;
    private int index = -1;
    private int pequest_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        edtCountry = (EditText) findViewById(R.id.edtCountry);
        edtShenfen = (EditText) findViewById(R.id.edtShenfen);
        edtName = (EditText) findViewById(R.id.edtName);
        btnOK = (Button) findViewById(R.id.btnOK);
        txtBirth = (TextView) findViewById(R.id.txtBirthday);
        radioBoy = (RadioButton) findViewById(R.id.radioBoy);
        radioGirl = (RadioButton) findViewById(R.id.radioGril);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        imageView = (ImageView) findViewById(R.id.imageView);

        btnOK.setOnClickListener(btnOKListener);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GllaryActivity.class);
                startActivityForResult(intent, pequest_code);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data == null) {
            Toast.makeText(MainActivity.this, "没东西", Toast.LENGTH_SHORT).show();
        } else {
            if (requestCode == pequest_code && resultCode == 2) {
                index = data.getIntExtra("imageView", R.drawable.dg);
                imageView.setImageResource(index);
            }
        }
    }

    View.OnClickListener btnOKListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String birth = edtShenfen.getText().toString();

            String name = edtName.getText().toString();
            String contry = edtCountry.getText().toString();
            String shenfen = edtShenfen.getText()
                    .toString();
            String address = edtAddress.getText().toString();

            if (edtName.length() > 0) {

                if (edtCountry.length() > 0) {

                    if (edtShenfen.length() == 18) {


                        if (edtAddress.length() > 0) {

                            String b = "";
                            String year = birth.substring(6, 10);
                            String month = birth.substring(11, 12);
                            String day = birth.substring(12, 14);

                            b = (year + "年" + month + "月" + day).trim();
                            txtBirth.setVisibility(View.VISIBLE);
                            txtBirth.setText(b);

                            if (radioBoy.isChecked()) {
                                sex = radioBoy.getText().toString();
                            } else {
                                sex = radioGirl.getText().toString();
                            }

                            if (index == -1) {
                                Toast.makeText(MainActivity.this, "赶紧去选头像", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            String allData = name + ";" + sex +";"+ contry + ";" + shenfen + ";" + address +";"+index;
                            boolean result = Util.WriteFile(allData);
                            if (result) {
                                Toast.makeText(MainActivity.this, "存储成功", Toast.LENGTH_SHORT).show();
                            }

                            try {
                                Thread.sleep(2000);

                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {

                                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "请输入详细地址，不能为空", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "身份证号不能为空，且只能是18位数字", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "民族不能为空", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            }
        }
    };


}
