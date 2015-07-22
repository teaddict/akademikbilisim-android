package com.schwappkopf.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorListener {

    private TextView txtX,txtY,txtZ;
    private SensorManager sm;


    private void init()
    {
        txtX = (TextView)findViewById(R.id.txtX);
        txtY = (TextView)findViewById(R.id.txtY);
        txtZ = (TextView)findViewById(R.id.txtZ);

        sm=(SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
    }

    public void EMP()
    {
        sm.registerListener(this,Sensor.TYPE_MAGNETIC_FIELD);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //Sensörler sistem servisleri altında
        //manifeste izin ekle
        Vibrator titresken = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        titresken.vibrate(1000);

        //tüm sensörler getir
       /*
        List<Sensor> sensorler = sm.getSensorList(Sensor.TYPE_ALL);

        String str ="";

        for(Sensor s : sensorler)
        {
            str+=s.getName() + "\n\r";
        }


        ((TextView)findViewById(R.id.txtSensor)).setText(str);
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSensorChanged(int i, float[] floats) {

        txtX.setText(String.format("%f",floats(0)));

    }

    @Override
    public void onAccuracyChanged(int i, int i2) {

    }
}
