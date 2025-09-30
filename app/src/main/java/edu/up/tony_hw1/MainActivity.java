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
        setContentView(R.layout.activity_main);

        DrawingSurface drawingSurface = findViewById(R.id.drawingSurface);
        TextView elementName = findViewById(R.id.nameText);

        SeekBar redSeek = findViewById(R.id.seekBar);
        SeekBar greenSeek = findViewById(R.id.seekBar2);
        SeekBar blueSeek = findViewById(R.id.seekBar2);

        // Setting up model
        DrawingModel model = new DrawingModel(drawingSurface.getModel());
        model.elementName = elementName;
        model.redSeek = redSeek;
        model.greenSeek = greenSeek;
        model.blueSeek = blueSeek;

        // Setting up controller
        DrawingController controller = new DrawingController(drawingSurface, model);

        // Hooking up listeners/Functionality
        drawingSurface.setOnTouchListener(controller);
        redSeek.setOnSeekBarChangeListener(controller);
        greenSeek.setOnSeekBarChangeListener(controller);
        blueSeek.setOnSeekBarChangeListener(controller);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}