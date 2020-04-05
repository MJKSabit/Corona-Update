package mjksabit.github.coronaupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Thread dataLoaderThread = null;
    public ApplicationDataProvider dataProvider = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
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
    }

    public void showCountryData(View v) {
        EditText in = (EditText) findViewById(R.id.txt_country_name);

        updateData(in.getText().toString());
    }
}
