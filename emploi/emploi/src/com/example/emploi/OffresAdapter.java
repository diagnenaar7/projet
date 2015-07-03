package com.example.emploi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class OffresAdapter
 {

public static final String KEY_ROWID = "_id ";
public static final String KEY_filieres = "filieres";
public static final String KEY_entreprise = "entreprise";
public static final String KEY_description = "description";

public   String of= JobActivity.offre;
private static final String TAG = "OffresAdapter";
private DatabaseHelper mDbHelper;
private SQLiteDatabase mDb;

private static final String DATABASE_NAME = "esmt";
private static final String SQLITE_TABLE = "offres";
private static final int DATABASE_VERSION = 1;

private final Context mCtx;

private static final String DATABASE_CREATE =
 "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
 KEY_ROWID + " integer PRIMARY KEY autoincrement," +
 KEY_filieres + "," +
 KEY_entreprise + "," +
 KEY_description + "," +
 
 " UNIQUE (" + KEY_ROWID +"));";

private static class DatabaseHelper extends SQLiteOpenHelper {

 DatabaseHelper(Context context) {
  super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }


 @Override
 public void onCreate(SQLiteDatabase db) {
  Log.w(TAG, DATABASE_CREATE);
  db.execSQL(DATABASE_CREATE);
 }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
    + newVersion + ", which will destroy all old data");
  db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
  onCreate(db);
 }
}

public OffresAdapter(Context ctx) {
 this.mCtx = ctx;
}

public OffresAdapter open() throws SQLException {
 mDbHelper = new DatabaseHelper(mCtx);
 mDb = mDbHelper.getWritableDatabase();
 return this;
}

public void close() {
 if (mDbHelper != null) {
  mDbHelper.close();
 }
}

public long createOffre( int id,String filieres, String entreprise, 
  String description) {

 ContentValues initialValues = new ContentValues();
 
 initialValues.put(KEY_ROWID, id);
 initialValues.put(KEY_filieres, filieres);
 initialValues.put(KEY_entreprise, entreprise);
 initialValues.put(KEY_description, description);

 return mDb.insert(SQLITE_TABLE, null, initialValues);
}

public boolean deleteAllCountries() {

 int doneDelete = 0;
 doneDelete = mDb.delete(SQLITE_TABLE, null , null);
 Log.w(TAG, Integer.toString(doneDelete));
 return doneDelete > 0;

}



public Cursor fetchOffres() {

 Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
   KEY_filieres, KEY_entreprise, KEY_description}, KEY_filieres + " like '%" + of + "%'", 
   null, null, null, null, null);

 if (mCursor != null) {
  mCursor.moveToFirst();
 }
 return mCursor;
}

public void insertSomeCountries() {

 createOffre(0,"Télécommunications","Orange","informaticien bac +3 au moins et 2 ans d'expérience");
 createOffre(1,"Agroalimentaire","Sedima"," ingenieur bac +5");
 createOffre(2,"Administration","UBA","comptable avec un niveau bac +2");
 createOffre(3,"Agroalimentaire","Nestlé","bac +5 avec 4 ans d'expérience");
}

}
