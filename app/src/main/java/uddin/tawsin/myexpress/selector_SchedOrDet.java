package uddin.tawsin.myexpress;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static uddin.tawsin.myexpress.list.KEY_ID2;

public class selector_SchedOrDet extends AppCompatActivity {
    public static final String KEY_ID1 = "station";
    public String station;
    DatabaseDetails mydb;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector__sched_or_det);
      //  mydb = new DatabaseDetails(this);

      /*  Button buttonSc = (Button) findViewById(R.id.buttonSCHED);
        Button buttonDe = (Button) findViewById(R.id.buttonDET);*/


        Intent intent = getIntent();

         station = intent.getStringExtra(KEY_ID2);
    }
    public void gotosched(View view) {
        //search = spinner.getSelectedItem().toString();

      /*  Cursor res = mydb.getAllData(search);
        if (res.getCount() == 0) {
            show("Error", "NOOOoooo");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while ((res.moveToNext())) {
                stringBuffer.append("STATION = " + res.getString(2) + "\n");
            }
           // show("DATA", stringBuffer.toString());*/
        Intent i = new Intent(this,scheduleList.class);

        i.putExtra(KEY_ID1,station);

        startActivity(i);


    }

    public void gotodet(View view) {

        mydb = DatabaseDetails.getInstance(this);

        if (flag == 0)
            mydb.kaka();
        flag = 1;
        mydb.insertData();
        Cursor res = mydb.getAllData(station);
        if (res.getCount() == 0) {
            show("Error", "NOOOoooo");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while ((res.moveToNext())) {
                stringBuffer.append("\n" + res.getString(2) + "\n\n");
                stringBuffer.append("Contact No: " + res.getString(3) + "\n");
                break;
            }
            show(station, stringBuffer.toString());


        }
    }

    public void show(String tile,String mess){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tile);
        builder.setMessage(mess);
        builder.show();


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

