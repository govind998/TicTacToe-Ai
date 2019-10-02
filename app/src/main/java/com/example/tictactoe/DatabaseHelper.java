package com.example.tictactoe;
import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String Database_Name="TicTacToe.db";
    public static final String Table_Name="Game_History";
    public static final String COL_1="MOVES";
    public static final String COL_2="STATUS";


    public DatabaseHelper(Context context){
        super(context,Database_Name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL("create table "+Table_Name+"(MOVES TEXT,STATUS TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS " + Table_Name);
        onCreate(db);
    }

    public boolean insertData(String moves,String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
            contentValues.put(COL_1,moves);
            contentValues.put(COL_2,status);
            long result=db.insert(Table_Name,null,contentValues);
            if(result==-1)
                return  false;
            else
                return true;
    }
}
