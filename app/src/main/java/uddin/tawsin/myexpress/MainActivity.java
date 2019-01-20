package uddin.tawsin.myexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Database mydb;
    Button button2;
    Spinner spinner;
    String search;
    int flag=0;
    public static final String KEY_ID="search";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button)findViewById(R.id.button2);
        spinner=(Spinner)findViewById(R.id.spinner);
        mydb= Database.getInstance(this);
        if (flag == 0)
            mydb.kaka();
        flag = 1;
       mydb.insertData();
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
    public void kk(View view) {
         search = spinner.getSelectedItem().toString();

      /*  Cursor res = mydb.getAllData(search);
        if (res.getCount() == 0) {
            show("Error", "NOOOoooo");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while ((res.moveToNext())) {
                stringBuffer.append("STATION = " + res.getString(2) + "\n");
            }
           // show("DATA", stringBuffer.toString());*/
            Intent i = new Intent(this,list.class);

        i.putExtra(KEY_ID,search);

        startActivity(i);


        }
    }



   /* public void show(String tile,String mess){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tile);
        builder.setMessage(mess);
        builder.show();


    }*/



