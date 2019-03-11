package com.example.worck.databasedemosql;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase myDataBase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
            myDataBase.execSQL("INSERT INTO users(name, age) VALUES('Rob', 34)");
            myDataBase.execSQL("INSERT INTO users(name, age) VALUES('Nick', 28)");
            Cursor c = myDataBase.rawQuery("SELECT * FROM users ", null);
            int nameINDEX = c.getColumnIndex("name");
            int ageINDEX = c.getColumnIndex("age");
            c.moveToNext();
            while(c != null){
                Log.i ("name", c.getString(nameINDEX));
                Log.i ("age", c.getString(ageINDEX));
                c.moveToNext();            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            SQLiteDatabase eventsDataBase = this.openOrCreateDatabase("Events", MODE_PRIVATE,null);
            eventsDataBase.execSQL("CREATE TABLE IF NOT EXISTS events(event VARCHAR, date INT(4))");
            eventsDataBase.execSQL("INSERT INTO events(event, date)VALUES('My wifw birthday', 1986)");
            eventsDataBase.execSQL("INSERT INTO events(event, date)VALUES('My birthday', 1983)");
            Cursor c = eventsDataBase.rawQuery("SELECT * FROM events",null);
            int eventINDEX = c.getColumnIndex("event");
            int dateINDEX  = c.getColumnIndex("date");
            c.moveToNext();
            while (c != null){
                Log.i("event", c.getString(eventINDEX));
                Log.i("date",c.getString(dateINDEX));
                c.moveToNext();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
