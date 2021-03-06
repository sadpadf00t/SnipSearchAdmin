package com.example.vibrantzz3.snipsearchadmin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vibrantzz3 on 2/5/2018.
 */

public class CancelledFragment extends Fragment {
    View view;
    List<Appointments> aData;
    AppointmentRecyclerViewAdapter myAdapter;
    RecyclerView myrv;
    private static final String url_appt = "http://test.epoqueapparels.com/Salon/Salon_App/cancelledlist.php";
    JSONObject jsonObject;
    private static final String TAG_PROFILE = "data";
    private static final String TAG_ID = "id";
    private static final String TAG_SID = "sid";
    private static final String TAG_NAME = "name";
    private static final String TAG_LOCATION = "location";
    private static final String TAG_REQUEST = "request";
    private static final String TAG_PIC = "profilepic";
    private static final String TAG_DATE = "date";
    private static final String TAG_TIME = "time";
    String id;

    public CancelledFragment() {


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cancelled, container, false);

        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        id = args.getString("idholder");

        aData = new ArrayList<>();
        new WelcomeAsyncTask().execute();
        return view;

    }
    private class WelcomeAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Display progress bar

        }

        @Override
        protected String doInBackground(String... params) {
            HttpJsonParser httpJsonParser = new HttpJsonParser();
            Map<String, String> httpParams = new HashMap<>();
            httpParams.put(TAG_ID, id);
            jsonObject = httpJsonParser.makeHttpRequest(
                    url_appt , "GET", httpParams);

            return null;
        }

        protected void onPostExecute(final String result) {



            try {
                JSONArray jArray = jsonObject.getJSONArray(TAG_PROFILE);


                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    //Parse the JSON response
                    aData.add(new Appointments( id,json_data.getString(TAG_SID),json_data.getString(TAG_NAME),json_data.getString(TAG_LOCATION),json_data.getString(TAG_PIC),json_data.getString(TAG_DATE), json_data.getString(TAG_TIME),json_data.getString(TAG_REQUEST)));

                }


                myrv=(RecyclerView) view.findViewById(R.id.cancelled_recycler);
                myAdapter=new AppointmentRecyclerViewAdapter(getContext(),aData);
                myrv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                myrv.setAdapter(myAdapter);



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }



}










