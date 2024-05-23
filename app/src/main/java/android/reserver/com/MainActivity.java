package android.reserver.com;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.my_purple)));
        }

        EditText editTextNumber = findViewById(R.id.editTextNumber);

        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.isEmpty()) {
                    try {
                        int number = Integer.parseInt(input);
                        if (number < 1) {
                            editTextNumber.setError("Please enter a number between 1 and 6");
                        } else if (number > 6 ) {
                            Toast.makeText(MainActivity.this, "Please call 555-444-2222" +
                                    "to make a reservation for parties larger than 6.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            editTextNumber.setError(null);
                        }
                    } catch (NumberFormatException e) {
                        editTextNumber.setError("Invalid number");
                    }
                }
            }
        });
    }
}*/

public class MainActivity extends AppCompatActivity {

    private Menu mMenu;
    private final String NUMBER_OF_SEATS = "numberOfSeats";
    private int mNumberOfSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mNumberOfSeats = savedInstanceState.getInt(NUMBER_OF_SEATS);
            Log.d("CREATION", "number of seats saved");
        }
    }

    public void submitButton(View view) {
        EditText et=(EditText)findViewById(R.id.editText);
        int numGuests = Integer.parseInt(et.getText().toString());
        try {
            Toast toast;

            if(numGuests>6) {
                toast=Toast.makeText(this,R.string.lessThanSix ,Toast.LENGTH_LONG);
            }
            else {
                if(numGuests>0) {
                    mNumberOfSeats = numGuests;
                    /*toast=Toast.makeText(this,"thank you for the reservation", Toast.LENGTH_LONG);*/
                    toast=Toast.makeText(this, R.string.thank, Toast.LENGTH_LONG);
                    onSubmitClick(view);
                }
                else  toast=Toast.makeText(this,R.string.greaterThanZero, Toast.LENGTH_LONG);
            }
            toast.show();
        }
        catch (Exception e){
            e.printStackTrace();  }
    }

    public void onSubmitClick(View view) {
        Intent intent = new Intent(this, floorPlan.class);
        intent.putExtra(floorPlan.EXTRA_SEATS, mNumberOfSeats);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER_OF_SEATS, mNumberOfSeats);
    }

    public void onHelpClick(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getItemId() == R.id.help) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.about) {
            // go to about activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
