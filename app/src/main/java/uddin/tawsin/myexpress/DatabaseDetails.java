package uddin.tawsin.myexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseDetails extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "details.db";
    public static  final String TABLE_NAME = "Details_table";
    public static  final String COL_1 = "ID";
    public static  final String COL_2= "STATION";
    public static  final String COL_3= "STATION_Details";
    public static  final String COL_4= "Contact";

    private static DatabaseDetails mInstance = null;
    private Context mContext;

    public static DatabaseDetails getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new DatabaseDetails(context.getApplicationContext());
            mInstance.insertData();
        }
        return mInstance;
    }

    public DatabaseDetails(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }


   /* private DatabaseDetails(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }*/



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT,STATION TEXT,STATION_Details TEXT,Contact TEXT)");
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

        contentValues.put(COL_2,"AIRPORT RAILWAY STATION");
        contentValues.put(COL_3,"Airport railway station or Biman Bondor railway station is a railway station in Dhaka, the capital of Bangladesh. Situated opposite to Shahjalal International Airport, it can be accessed from the Airport Road.");
        contentValues.put(COL_4,"+8801819564471");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"KAMALAPUR RAILWAY STATION");
        contentValues.put(COL_3,"Kamalapur Railway Station is the central railway station in Dhaka, Bangladesh. The station is the largest in the country and the most important terminal for transportation between Dhaka and the rest of Bangladesh. It is also one of the most modern and striking buildings in Dhaka designed by American architect Robert Boughey. The railway station situated in the north-east side of Motijheel, was established in the early 1960s and started its operation from 1969");
        contentValues.put(COL_4,"+8801819564371");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"BOTTOLI RAILWAY STATION");
        contentValues.put(COL_3,"Bottoli railway station is a railway junction in Bangladesh, situated in the district of chittagong, in the division of chittagong");
        contentValues.put(COL_4,"+8801834555438");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"NEW MARKET RAILWAY STATION");
        contentValues.put(COL_3,"This is also called the new railway station established in 2006,it is situated beside the bottoli railway station");
        contentValues.put(COL_4,"+8801819544935");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"RAJSHAHI RAILWAY STATION");
        contentValues.put(COL_3,"Ishwardi is a railway junction in Bangladesh, situated in the district of Pabna, in the division of Rajshahi");
        contentValues.put(COL_4,"+8801854773865");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"BORISAL RAILWAY STATION");
        contentValues.put(COL_3,"The train connected the Indian city of Kolkata (then Calcutta) with the city of Khulna in Bangladesh");
        contentValues.put(COL_4,"+8801839544835");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"SHAHJALAL RAILWAY STATION");
        contentValues.put(COL_3,"The train station is on the south side of town. There are four daily express trains for Dhaka (1st berth/1st seat/shuvon Tk 595/395/295, between seven and nine hours, 8.40am, 3pm, 8pm and 10pm). The night trains also have air-con berths (Tk 1018).");
        contentValues.put(COL_4,"+8801964833756");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"BAGERHAT RAILWAY STATION");
        contentValues.put(COL_3,"Bagerhat railway station is a railway station in Khulna, Bangladesh. The railway station is the main station of the city, and links to Jessore railway station via the Jessore-Khulna Rail Line.");
        contentValues.put(COL_4,"+8801837455647");
        db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL_2,"NEW CASTLE RAILWAY STATION");
        contentValues.put(COL_3,"Rangpur Railway Station is next to Rangpur and is located in Rangpur Division, Bangladesh");
        contentValues.put(COL_4,"+8801736558748");
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
