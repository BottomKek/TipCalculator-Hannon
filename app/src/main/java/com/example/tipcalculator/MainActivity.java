package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeBar();
    }
    DecimalFormat df = new DecimalFormat("$#,##0.00");
    public void calcTip(View v){

    }
    public void changeBar(){
        SeekBar seekBar = (SeekBar) findViewById(R.id.qualitySeekBar);
        TextView textView = (TextView) findViewById(R.id.seekBarTextView);
        textView.setText("Quality: ");

        seekBar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int progressValue;
                    TextView textView = (TextView) findViewById(R.id.seekBarTextView);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progressValue = i;
                        if (i <= 16){
                            textView.setText("Quality: Terrible");
                        }
                        else if(i > 16 && i <= 33){
                            textView.setText("Quality: Poor");
                        }
                        else if (i > 33 && i <= 50){
                            textView.setText("Quality: Average");
                        }
                        else if (i > 50 && i <= 67){
                            textView.setText("Quality: Okay");
                        }
                        else if (i > 67 && i <= 83){
                            textView.setText("Quality: Good");
                        }
                        else {
                            textView.setText("Quality: Great");
                        }
                        Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar in startTracking", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
