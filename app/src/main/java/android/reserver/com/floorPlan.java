package android.reserver.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class floorPlan extends AppCompatActivity {

    public static final String EXTRA_SEATS = "android.reserver.com.floor_plan";
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get number of sears from MainActivity
        Intent intent = getIntent();
        int seats = intent.getIntExtra(EXTRA_SEATS, 0);

        if (seats >= 5) {
            setContentView(R.layout.activity_floor_plan_over5);
        } else {
            setContentView(R.layout.activity_floor_plan);
        }

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}