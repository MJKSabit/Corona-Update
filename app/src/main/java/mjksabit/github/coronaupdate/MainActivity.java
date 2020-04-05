package mjksabit.github.coronaupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Thread dataLoaderThread = null;
    public ApplicationDataProvider dataProvider = null;

    public void messageConnecting() {
        messageShower(R.id.msg_connecting);
    }

    public void messageError() {
        messageShower(R.id.msg_error_reload);
    }

    public void messageLive() {
        messageShower(R.id.msg_live);
    }

    private void messageShower(int ResourceID) {
        LinearLayout live = (LinearLayout) findViewById(R.id.msg_live);
        LinearLayout connecting = (LinearLayout) findViewById(R.id.msg_connecting);
        LinearLayout retry = (LinearLayout) findViewById(R.id.msg_error_reload);

        LinearLayout temp = (LinearLayout) findViewById(ResourceID);

        live.setVisibility(View.INVISIBLE);
        connecting.setVisibility(View.INVISIBLE);
        retry.setVisibility(View.INVISIBLE);

        temp.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        // Internet Thread
        dataLoaderThread = new Thread( (Runnable) () -> dataProvider = new ApplicationDataProvider());
        dataLoaderThread.start();

//        dataProvider = new ApplicationDataProvider();
        //updateData("bangladesh");

    }



    private void textViewUpdater(int ResourceId, String data) {
        TextView temp = (TextView) findViewById(ResourceId);
        temp.setText(data);
    }

    private void updateData(String key) {
        if(dataProvider != null && !dataLoaderThread.isAlive()) {
            if(dataProvider.dataMap.containsKey(key.toLowerCase())) {
                CountryData temp = dataProvider.dataMap.get(key.toLowerCase());

                textViewUpdater(R.id.txt_country_out, temp.getName());
                textViewUpdater(R.id.txt_identified_cases, temp.getTotalCases());
                textViewUpdater(R.id.txt_active, temp.getActiveCases());
                textViewUpdater(R.id.txt_recovered, temp.getTotalRecovered());
                textViewUpdater(R.id.txt_death, temp.getTotalDeath());
            }
            else {
                Toast.makeText(getApplicationContext(), "Country Not Found!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Couldn\'t Connect to Internet", Toast.LENGTH_LONG).show();
        }
    }

    public void showCountryData(View v) {
        EditText in = (EditText) findViewById(R.id.txt_country_name);

        updateData(in.getText().toString());
    }

    public void showCountryList(View v) {
        Intent country = new Intent(MainActivity.this, CountryList.class);

//        if(dataProvider.dataMap!=null) country.putExtra("list", dataProvider.dataMap.keySet().toArray());
//        else country.putExtra("list", dataProvider.dataMap.keySet().toArray();
        startActivity(country);

        String allCities = "";

        for(Object cities : dataProvider.dataMap.keySet().toArray()) {
            allCities += (String) cities + "\", \"";
        }

        Log.v("CITIES", allCities);

    }
}
