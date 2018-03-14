package login.loginactivity1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ishita on 3/9/2018.
 */

public class register_1 extends AppCompatActivity {
    TextView fname,lname,uname,email;
    Button bt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_1);
        bt = (Button) findViewById(R.id.login);
        fname = (TextView) findViewById(R.id.fname);
        lname = (TextView) findViewById(R.id.lname);
        uname = (TextView) findViewById(R.id.uname);
        email = (TextView) findViewById(R.id.email);
        SQLiteDatabase db = openOrCreateDatabase(SQLlitehelper.DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = db.rawQuery("SELECT * FROM " + SQLlitehelper.TABLE_NAME,null);
        cursor.moveToFirst();
        fname.setText(cursor.getString(0));
        lname.setText(cursor.getString(1));
        uname.setText(cursor.getString(3));
        email.setText(cursor.getString(2));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(register_1.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}
