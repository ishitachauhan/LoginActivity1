package login.loginactivity1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2;
    EditText uname,pword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectactivity);
        bt1 = (Button) findViewById(R.id.registerbtn);
        bt2 = (Button) findViewById(R.id.login);
        uname = (EditText) findViewById(R.id.uname);
        pword = (EditText) findViewById(R.id.pword);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, register_2.class);
                startActivity(in);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            Cursor cursor;
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = openOrCreateDatabase(SQLlitehelper.DATABASE_NAME, MODE_PRIVATE, null, null);
                String username = uname.getText().toString();
                String password = pword.getText().toString();
                String u = cursor.getString(3);
                String p = cursor.getString(4);
                if (username == u && password == p) {
                    Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "username or password incorrect", Toast.LENGTH_LONG).show();
                    uname.setText("");
                    pword.setText("");
                }


            }
        });
    }
}


