package uddin.tawsin.myexpress;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class scheduleList extends AppCompatActivity {
    DatabaseSchedule mydb;
    DatabaseTicket tic;
    ListView listView;
    String search;
    public String[] train2 = new String[10];
    int flag=0;
    int flag1=0;
    int cur=0;
    public  String train1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);
        listView = (ListView) findViewById(R.id.listt1);
        mydb = DatabaseSchedule.getInstance(this);
        tic = DatabaseTicket.getInstance(this);

       // mydb= new Database(this);
       if (flag == 0)
            mydb.kaka();
        flag = 1;
       mydb.insertData();
        //Bundle bundle = getIntent().getExtras();
        //String mama = bundle.getString(search);
        Intent intent = getIntent();
        search = intent.getStringExtra(selector_SchedOrDet.KEY_ID1);
      //  Toast.makeText(getApplicationContext(),search,Toast.LENGTH_LONG).show();
        //search = intent.getStringExtra(MainActivity.KEY_ID);

        // search="DHAKA";

        // ArrayList<String> theList = new ArrayList<>();
        final ArrayList<cus> theList = new ArrayList<cus>();
        Cursor data = mydb.getAllData(search);
        if (data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                // theList.add(data.getString(2));
                final String train = data.getString(2);
                train2[cur++] = train;
                final String des = "to " + data.getString(3);
                final String time = data.getString(4);
               // cus DD = cus.getInstance(train, des, time);
                cus DD = new cus(train,des,time);
                theList.add(DD);
                adapter1 ada = new adapter1(this, theList);
                //  ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(ada);
            }
        }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {

                        switch (position){
                            case 0:
                                if (flag1 == 0)
                                    tic.kaka();
                                flag1 = 1;
                                tic.insertData();
                                Cursor res = tic.getAllData(search,train2[0]);
                                if (res.getCount() == 0) {
                                    show("Error", "NOOOoooo");
                                } else {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while ((res.moveToNext())) {
                                        train1 = res.getString(1);
                                        stringBuffer.append("\n" + res.getString(3) + "\n\n");
                                        stringBuffer.append("Availability: " + res.getString(4) + "\n");
                                        break;
                                    }
                                    // res.moveToFirst();
                                    show(train1, stringBuffer.toString());
                                }
                                //Toast.makeText(list.this,train[0],Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                if (flag1 == 0)
                                    tic.kaka();
                                flag1 = 1;
                                tic.insertData();
                                Cursor ees = tic.getAllData(search,train2[1]);
                                if (ees.getCount() == 0) {
                                    show("Error", "NOOOoooo");
                                } else {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while ((ees.moveToNext())) {
                                        train1=ees.getString(1);
                                        stringBuffer.append("\n" + ees.getString(3) + "\n\n");
                                        stringBuffer.append("Availability: " + ees.getString(4) + "\n");
                                        break;
                                    }
                                    // res.moveToFirst();
                                    show(train1, stringBuffer.toString());}
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                if (flag1 == 0)
                                    tic.kaka();
                                flag1 = 1;
                                tic.insertData();
                                Cursor ses = tic.getAllData(search,train2[2]);
                                if (ses.getCount() == 0) {
                                    show("Error", "NOOOoooo");
                                } else {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while ((ses.moveToNext())) {
                                        train1 = ses.getString(1);
                                        stringBuffer.append("\n" + ses.getString(3) + "\n\n");
                                        stringBuffer.append("Availability: " + ses.getString(4) + "\n");
                                        break;
                                    }
                                    // res.moveToFirst();
                                    show(train1, stringBuffer.toString());
                                }
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                if (flag1 == 0)
                                    tic.kaka();
                                flag1 = 1;
                                tic.insertData();
                                Cursor ues = tic.getAllData(search,train2[3]);
                                if (ues.getCount() == 0) {
                                    show("Error", "NOOOoooo");
                                } else {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while ((ues.moveToNext())) {
                                        train1 = ues.getString(1);
                                        stringBuffer.append("\n" + ues.getString(3) + "\n\n");
                                        stringBuffer.append("Availability: " + ues.getString(4) + "\n");
                                        break;
                                    }
                                    // res.moveToFirst();
                                    show(train1, stringBuffer.toString());
                                }
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                if (flag1 == 0)
                                    tic.kaka();
                                flag1 = 1;
                                tic.insertData();
                                Cursor ves = tic.getAllData(search,train2[4]);
                                if (ves.getCount() == 0) {
                                    show("Error", "NOOOoooo");
                                } else {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while ((ves.moveToNext())) {
                                        train1 = ves.getString(1);
                                        stringBuffer.append("\n" + ves.getString(3) + "\n\n");
                                        stringBuffer.append("Availability: " + ves.getString(4) + "\n");
                                        break;
                                    }
                                    // res.moveToFirst();
                                    show(train1, stringBuffer.toString());
                                }
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            default:
                                Toast.makeText(getApplicationContext(),train2[0],Toast.LENGTH_LONG).show();


                           // stringBuffer.delete(0,stringBuffer.length());

                        // When clicked, show a toast with the TextView text
                        // Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        //       Toast.LENGTH_SHORT).show();
                        //Toast.makeText(scheduleList.this,mama,
                                //Toast.LENGTH_SHORT).show();






                    }
                }

            });
            }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public void show(String tile,String mess) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tile);
        builder.setMessage(mess);
        builder.show();
    }

    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"About Us",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Contact Us",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Rating Us",Toast.LENGTH_LONG).show();
                return true;
        }
        return true;
    }
}
