package login.loginactivity1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class register_2 extends AppCompatActivity {
    SQLlitehelper sqlInvoke = new SQLlitehelper(this);
    EditText et_fnameEditText,et_lnameEditText,et_emailEditText,et_usernameEditText,et_password_et;
    Button bt_Register,bt_back;
    String fname,lname,email,uname,pword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);
        et_fnameEditText = (EditText) findViewById(R.id.fname);

        et_lnameEditText = (EditText) findViewById(R.id.lname);

        et_emailEditText = (EditText) findViewById(R.id.email);

        et_usernameEditText = (EditText) findViewById(R.id.uname);

        et_password_et = (EditText) findViewById(R.id.pword);

        bt_Register =(Button) findViewById(R.id.register);
        bt_back = (Button) findViewById(R.id.bktologin);
        bt_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = et_fnameEditText.getText().toString();
                lname = et_lnameEditText.getText().toString();
                email = et_emailEditText.getText().toString();
                uname= et_usernameEditText.getText().toString();
                pword = et_password_et.getText().toString();
                SQLiteDatabase db = openOrCreateDatabase(SQLlitehelper.DATABASE_NAME,MODE_PRIVATE,null);
                db.execSQL("CREATE TABLE IF NOT EXISTS " + SQLlitehelper.TABLE_NAME + "(" +
                        SQLlitehelper.FIRST_NAME + " TEXT," +
                        SQLlitehelper.LAST_NAME + " TEXT," +
                        SQLlitehelper.EMAIL + " TEXT," + SQLlitehelper.USER_NAME + " TEXT," + SQLlitehelper.PASSWORD + " TEXT);");
                db.execSQL("INSERT INTO " +SQLlitehelper.TABLE_NAME+" ("+SQLlitehelper.FIRST_NAME+ ","+SQLlitehelper.LAST_NAME+","+SQLlitehelper.EMAIL+","+SQLlitehelper.USER_NAME
                        +","+SQLlitehelper.PASSWORD+") "+"VALUES('"+fname+"','"+lname+"','"+email+"','"+uname+"','"+pword+"');");
                Intent in = new Intent(register_2.this, register_1.class);
                startActivity(in);
                db.close();
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(register_2.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}
