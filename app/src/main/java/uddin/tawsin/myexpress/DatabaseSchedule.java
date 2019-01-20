package uddin.tawsin.myexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseSchedule extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "sched.db";
    public static  final String TABLE_NAME = "schedule_table";
    public static  final String COL_1 = "ID";
    public static  final String COL_2 = "TRAIN";
    public static  final String COL_3= "STATION";
    public static  final String COL_4= "DESTINATION";
    public static  final String COL_5= "TIME";

    private static DatabaseSchedule mInstance = null;
    private Context mContext;

    public static DatabaseSchedule getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new DatabaseSchedule(context.getApplicationContext());
            mInstance.insertData();
        }
        return mInstance;
    }

    public DatabaseSchedule(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT,STATION TEXT,TRAIN TEXT,DESTINATION TEXT,TIME TEXT)");
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


       contentValues.put(COL_2,"TURNA");
        contentValues.put(COL_3,"AIRPORT RAILWAY STATION");
        contentValues.put(COL_4,"CHITTAGONG");
        contentValues.put(COL_5,"06:00AM");

        db.insert(TABLE_NAME,null,contentValues);




        contentValues.put(COL_2,"PROBHATI");
        contentValues.put(COL_3,"BOTTOLI RAILWAY STATION");
        contentValues.put(COL_4,"DHAKA");
        contentValues.put(COL_5,"07:00AM");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"TURNA");
        contentValues.put(COL_3,"BOTTOLI RAILWAY STATION");
        contentValues.put(COL_4,"DHAKA");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"RAJSHAHI EXPRESS");
        contentValues.put(COL_3,"RAJSHAHI RAILWAY STATION");
        contentValues.put(COL_4,"SYLHET");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"BORISAL EXPRESS");
        contentValues.put(COL_3,"BORISAL RAILWAY STATION");
        contentValues.put(COL_4,"KHULNA");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"DHAKA EXPRESS");
        contentValues.put(COL_3,"SHAHJALAL RAILWAY STATION");
        contentValues.put(COL_4,"CHITTAGONG");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);
        contentValues.put(COL_2,"KHULNA EXPRESS");
        contentValues.put(COL_3,"BAGERHAT RAILWAY STATION");
        contentValues.put(COL_4,"CHITTAGONG");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"SHUNDORBAN EXPRESS");
        contentValues.put(COL_3,"BAGERHAT RAILWAY STATION");
        contentValues.put(COL_4,"SYLHET");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);


        contentValues.put(COL_2,"GODHULI");
        contentValues.put(COL_3,"NEW MARKET RAILWAY STATION");
        contentValues.put(COL_4,"SYLHET");
        contentValues.put(COL_5,"05:00PM");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"RANGPUR EXPRESS");
        contentValues.put(COL_3,"NEW CASTLE RAILWAY STATION");
        contentValues.put(COL_4,"BORISAL");
        contentValues.put(COL_5,"05:00AM");
        db.insert(TABLE_NAME,null,contentValues);



        contentValues.put(COL_2,"GODHULY");
        contentValues.put(COL_3,"KAMALAPUR RAILWAY STATION");
        contentValues.put(COL_4,"CHITTAGONG");
        contentValues.put(COL_5,"03:00PM");

        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"TURNA");
        contentValues.put(COL_3,"KAMALAPUR RAILWAY STATION");
        contentValues.put(COL_4,"CHITTAGONG");
        contentValues.put(COL_5,"08:00AM");

        db.insert(TABLE_NAME,null,contentValues);

    }
    public Cursor getAllData(String location){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME +" where STATION ='"+location+"'",null);
        return  res;
    }

    public void kaka(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }
}
