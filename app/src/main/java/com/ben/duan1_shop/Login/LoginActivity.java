package com.ben.duan1_shop.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ben.duan1_shop.AdminActivity;
import com.ben.duan1_shop.DAO.AdminDAO;
import com.ben.duan1_shop.DAO.UserDAO;
import com.ben.duan1_shop.R;
import com.ben.duan1_shop.TrangchuActivity;

public class LoginActivity extends AppCompatActivity {

    EditText Uname, Pword;
    Button btnLogin;
    TextView tvRrgister;
    UserDAO userDAO;
    AdminDAO adminDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userDAO = new UserDAO(LoginActivity.this);
        adminDAO = new AdminDAO(LoginActivity.this);
        tvRrgister = findViewById(R.id.tvRegister);
        tvRrgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        Uname = findViewById(R.id.UserName);
        Pword = findViewById(R.id.PassWord);
        btnLogin = findViewById(R.id.bntLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Uname.getText().toString();
                String pass = Pword.getText().toString();
                boolean checklogin = userDAO.checklogin(name,pass);
                boolean checkadmin = adminDAO.checkadmin(name,pass);

                if(checklogin==true){
                    Intent intent = new Intent(LoginActivity.this, TrangchuActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    finish();
                }                 else{

                    if (checkadmin==true){
                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Đăng nhập Admin",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{

                        Toast.makeText(getApplicationContext(),"Tên Đăng nhập hoặc mật khẩu không đúng",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
