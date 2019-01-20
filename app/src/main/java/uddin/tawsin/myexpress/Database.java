package uddin.tawsin.myexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Database extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "train.db";
    public static  final String TABLE_NAME = "location_table";
    public static  final String COL_1 = "ID";
    public static  final String COL_2 = "DIVISION";
    public static  final String COL_3= "STATION";

    private static Database mInstance = null;
    private Context mContext;

    public static Database getInstance(Context context) {

        if (mInstance == null) {

            mInstance = new Database(context.getApplicationContext());
            mInstance.insertData();
        }
        return mInstance;
    }

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE "+ TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT,DIVISION  TEXT,STATION TEXT)");
       // insertData();
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void insertData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,"DHAKA");
        contentValues.put(COL_3,"AIRPORT RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"DHAKA");
        contentValues.put(COL_3,"KAMALAPUR RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);

      contentValues.put(COL_2,"CHITTAGONG");
        contentValues.put(COL_3,"BOTTOLI RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"CHITTAGONG");
        contentValues.put(COL_3,"NEW MARKET RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"RAJSHAHI");
        contentValues.put(COL_3,"RAJSHAHI RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"BORISAL");
        contentValues.put(COL_3,"BORISAL RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"SYLHET");
        contentValues.put(COL_3,"SHAHJALAL RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"KHULNA");
        contentValues.put(COL_3,"BAGERHAT RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"RANGPUR");
        contentValues.put(COL_3,"NEW CASTLE RAILWAY STATION");
        db.insert(TABLE_NAME,null,contentValues);

    }
    public Cursor getAllData(String location){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME +" where DIVISION ='"+location+"'",null);
        return  res;
    }

    public void kaka(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }
}
