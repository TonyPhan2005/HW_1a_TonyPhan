// Tony Phan
// CS301 - Object Oriented Design
// 9/18/2025

package edu.up.tony_hw1;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DrawingModel model = new DrawingModel();
        DrawingSurface drawingSurface = new DrawingSurface(this, model);
        setContentView(drawingSurface);

        // Linking all of the IDs
        TextView nameElement = findViewById(R.id.nameText);
        SeekBar redSeek = findViewById(R.id.seekBar);
        SeekBar greenSeek = findViewById(R.id.seekBar2);
        SeekBar blueSeek = findViewById(R.id.seekBar3);

        DrawingController controller = new DrawingController(model, drawingSurface, nameElement, redSeek, greenSeek, blueSeek);

        // Linking functions to controller
        drawingSurface.setController(controller);
//        drawingSurface.setOnTouchListener(controller);
//        redSeek.setOnSeekBarChangeListener(controller);
//        greenSeek.setOnSeekBarChangeListener(controller);
//        blueSeek.setOnSeekBarChangeListener(controller);
    }
}