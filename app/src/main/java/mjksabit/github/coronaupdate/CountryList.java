package mjksabit.github.coronaupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryList extends AppCompatActivity {

    private void sendAndExit(String cityName) {

        Intent send = new Intent();
        send.putExtra("cityname", cityName);
        setResult(RESULT_OK, send);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_list_layout);

        ArrayList<String> list = new ArrayList<>();
        String cities[] = {"belarus", "japan", "south africa", "guinea", "gambia", "saint kitts and nevis", "san marino", "estonia", "dominican republic", "philippines", "channel islands", "cuba", "mauritius", "mali", "switzerland", "hong kong", "armenia", "vietnam", "australia", "laos", "aruba", "turkey", "ukraine", "austria", "western sahara", "cambodia", "congo", "monaco", "hungary", "kenya", "greenland", "greece", "paraguay", "cyprus", "s. korea", "colombia", "azerbaijan", "syria", "rwanda", "caribbean netherlands", "libya", "burkina faso", "norway", "afghanistan", "diamond princess", "dominica", "bulgaria", "bahrain", "guatemala", "ghana", "somalia", "jamaica", "togo", "uk", "liechtenstein", "thailand", "france", "serbia", "senegal", "montserrat", "zambia", "namibia", "curaçao", "taiwan", "palestine", "canada", "french polynesia", "honduras", "réunion", "maldives", "chile", "oman", "vatican city", "timor-leste", "brazil", "guyana", "germany", "india", "malaysia", "peru", "trinidad and tobago", "denmark", "sri lanka", "belize", "slovenia", "kuwait", "haiti", "zimbabwe", "el salvador", "saint lucia", "ivory coast", "bolivia", "china", "brunei", "antigua and barbuda", "israel", "bangladesh", "czechia", "ireland", "st. vincent grenadines", "albania", "poland", "eswatini", "botswana", "andorra", "venezuela", "moldova", "malawi", "russia", "sweden", "madagascar", "iran", "iraq", "seychelles", "falkland islands", "indonesia", "nicaragua", "gibraltar", "ethiopia", "equatorial guinea", "turks and caicos", "ecuador", "guinea-bissau", "saudi arabia", "spain", "mauritania", "algeria", "mozambique", "portugal", "cameroon", "lithuania", "costa rica", "panama", "world", "luxembourg", "uae", "lebanon", "mongolia", "italy", "finland", "bosnia and herzegovina", "nigeria", "benin", "sudan", "chad", "liberia", "djibouti", "fiji", "singapore", "isle of man", "mexico", "tunisia", "bahamas", "bhutan", "uruguay", "uganda", "gabon", "british virgin islands", "usa", "niger", "st. barth", "kyrgyzstan", "pakistan", "cabo verde", "martinique", "macao", "mayotte", "georgia", "cayman islands", "argentina", "drc", "jordan", "anguilla", "burundi", "slovakia", "belgium", "uzbekistan", "tanzania", "grenada", "netherlands", "eritrea", "croatia", "nepal", "morocco", "bermuda", "saint martin", "guadeloupe", "suriname", "french guiana", "romania", "angola", "new zealand", "sierra leone", "car", "latvia", "kazakhstan", "sint maarten", "egypt", "faeroe islands", "north macedonia", "malta", "iceland", "myanmar", "montenegro", "papua new guinea", "qatar", "ms zaandam", "barbados", "new caledonia"};
        for (String str : cities) list.add(str);
        Collections.sort(list);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendAndExit(list.get(position));
            }
        });
    }
}
