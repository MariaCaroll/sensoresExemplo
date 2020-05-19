package com.example.sensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestSensorActivity extends AppCompatActivity  implements SensorEventListener {
private TextView tvalor;
private SensorManager sensorManager;
private Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        int position = getIntent().getIntExtra("position", 0);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        tvalor = (TextView)findViewById(R.id.txtValor);
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < event.values.length; i++)
        {
            sb.append(i).append(": ").append(event.values[i]).append("\n");
        }
        tvalor.setText(sb.toString());


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
