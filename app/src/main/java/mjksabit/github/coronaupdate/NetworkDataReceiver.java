package mjksabit.github.coronaupdate;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkDataReceiver {
    URL dataUrl;
    URLConnection connection;

    public NetworkDataReceiver() {
        try {
            dataUrl = new URL("https://coronavirus-19-api.herokuapp.com/countries");
            connection = dataUrl.openConnection();
        } catch (IOException e) {

        }
    }

    public String getJSON(){
        String jsonString = "";
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lineInput;

            while ((lineInput = in.readLine()) != null)
                jsonString += lineInput + "\n";
            in.close();
        }
        catch (IOException e) {
            Log.v("getJSON", e.getMessage());
        }


        return jsonString;
    }
}
