package com.ben.duan1_shop.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ben.duan1_shop.DAO.UserDAO;
import com.ben.duan1_shop.Database.DatabaseHelper;
import com.ben.duan1_shop.R;

public class RegisterActivity extends AppCompatActivity {

    EditText Uname, Pass, Cpass;
    Button btnRegister;
    DatabaseHelper db;
    UserDAO userDAO;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //db = new DatabaseHelper(this);
        userDAO = new UserDAO(this);
        Uname = findViewById(R.id.UserName);
        Pass = findViewById(R.id.PassWord);
        Cpass = findViewById(R.id.Confirm);
        btnRegister = findViewById(R.id.bntRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Uname.getText().toString();
                String pass = Pass.getText().toString();
                String cpass = Cpass.getText().toString();
                if (name.equals("")|| pass.equals("")||cpass.equals("")){
                    Toast.makeText(getApplicationContext(),"Không được để trống",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(cpass)){
                        boolean checkuser = userDAO.checkuser(name);
                        if (checkuser==true){
                            boolean insert = userDAO.insert(name,pass);
                            if(insert==true){
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(getApplicationContext(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            }
                        }else {Toast.makeText(getApplicationContext(),"User đã tồn tại",Toast.LENGTH_LONG).show();}

                    }else {Toast.makeText(getApplicationContext(),"Nhập lại mật khẩu không đúng",Toast.LENGTH_LONG).show();}
                }

            }
        });
    }
}
