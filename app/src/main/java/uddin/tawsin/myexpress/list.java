package uddin.tawsin.myexpress;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class list extends AppCompatActivity {
    Database mydb;
    ListView listView;
    String search;
    public String[] train = new String[10];
    int i=0;
    int flag =0;
    public static  final String KEY_ID2="mama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
         listView = (ListView) findViewById(R.id.listt);
        mydb =Database.getInstance(this);
        if (flag == 0)
            mydb.kaka();
        flag = 1;
        mydb.insertData();
        //Bundle bundle = getIntent().getExtras();
        //String mama = bundle.getString(search);
        Intent intent = getIntent();

        search = intent.getStringExtra(MainActivity.KEY_ID);
      //  train = new String[10];

       // search="DHAKA";

       // ArrayList<String> theList = new ArrayList<>();
        final ArrayList<custom> theList = new ArrayList<custom>();
        Cursor data = mydb.getAllData(search);
        if (data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
               // theList.add(data.getString(2));
                final String mama = data.getString(2);
                //final StringBuffer stringBuffer= new StringBuffer();
               // stringBuffer.append(mama);


                train[i]=mama;
                i++;


                custom DD = new custom(mama);
                theList.add(DD);
                adapter kaka = new adapter(this, theList);
              // ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(kaka);}
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                        // When clicked, show a toast with the TextView text
                       // Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                         //       Toast.LENGTH_SHORT).show();
                        //Toast.makeText(list.this,mama,
                                //Toast.LENGTH_SHORT).show();
                      //  Toast.makeText(getApplicationContext(),mama,Toast.LENGTH_LONG).show();

                        switch (position){
                            case 0:
                                Intent i = new Intent(list.this,selector_SchedOrDet.class);
                                i.putExtra(KEY_ID2,train[0]);
                                startActivity(i);
                                //Toast.makeText(list.this,train[0],Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Intent k = new Intent(list.this,selector_SchedOrDet.class);
                                k.putExtra(KEY_ID2,train[1]);
                                startActivity(k);
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Intent l = new Intent(list.this,selector_SchedOrDet.class);
                                l.putExtra(KEY_ID2,train[2]);
                                startActivity(l);
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                Intent m = new Intent(list.this,selector_SchedOrDet.class);
                                m.putExtra(KEY_ID2,train[3]);
                                startActivity(m);
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                Intent o = new Intent(list.this,selector_SchedOrDet.class);
                                o.putExtra(KEY_ID2,train[4]);
                                startActivity(o);
                                //Toast.makeText(list.this,train[1],Toast.LENGTH_LONG).show();
                                break;
                            default:
                                Toast.makeText(getApplicationContext(),train[0],Toast.LENGTH_LONG).show();
                        }

                     /*   Intent i = new Intent(list.this,selector_SchedOrDet.class);

                        i.putExtra(KEY_ID2,);

                        startActivity(i);*/
                    }
                });

        }
    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
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
