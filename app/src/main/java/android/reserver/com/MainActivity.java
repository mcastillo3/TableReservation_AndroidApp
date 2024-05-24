package android.reserver.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

    public void submitButton(View view) {
        EditText et=(EditText)findViewById(R.id.editText);
        try {
            Toast toast;
            int numGuests = Integer.parseInt(et.getText().toString());
            if(numGuests>6) {
                toast=Toast.makeText(this,"please call 123-456-7890 to make a reservation for parties larger than 6",
                        Toast.LENGTH_LONG);
            }
            else {
                if(numGuests>0 && numGuests<5) {
                    toast=Toast.makeText(this,"thank you for the reservation", Toast.LENGTH_LONG);
                    Intent intent=new Intent(this,Floor_plan.class);
                    startActivity(intent);
                }
                else if(numGuests> 0){
                    toast=Toast.makeText(this,"thank you for the reservation", Toast.LENGTH_LONG);
                    Intent intent=new Intent(this,Floor_plan_six.class);
                    startActivity(intent);
                }
                else  toast=Toast.makeText(this,"the number of guests must be greater than 0", Toast.LENGTH_LONG);
            }
            toast.show();
        }
        catch (Exception e){
            e.printStackTrace();  }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getItemId() == R.id.help) {
            // User chose the "Favorite" action, mark the current item
            // as a favorite..
            Intent intent2=new Intent(this,Help.class);
            this.startActivity(intent2);
            return true;
        } else if (item.getItemId() == R.id.about) {
            // User chose the "Settings" item, show the app settings UI...
            Intent intent=new Intent(this, About.class);
            this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
