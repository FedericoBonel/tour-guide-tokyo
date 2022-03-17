package com.example.android.tourguidetokyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * The historical places list fragment
 */
public class SitesFragment extends Fragment {

    public SitesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //ArrayList of Attractions
        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.meiji_jingu,
                R.string.meiji_jingu_description,
                R.string.meiji_jingu_hours,
                R.drawable.meiji_jingu,
                R.drawable.meiji_jingu_ic,
                R.string.meiji_url,
                R.string.meiji_location));
        attractions.add(new Attraction(R.string.nezu_shrine,
                R.string.nezu_shrine_description,
                R.string.nezu_hours,
                R.drawable.nezu_shrine,
                R.drawable.nezu_shrine_ic,
                R.string.nezu_url,
                R.string.nezu_shrine_location));
        attractions.add(new Attraction(R.string.asakusa,
                R.string.asakusa_description,
                R.string.always_open_hours,
                R.drawable.asakusa_gate,
                R.drawable.asakusa_gate_ic,
                R.string.asakusa_url,
                R.string.asakusa_location));
        attractions.add(new Attraction(R.string.camii,
                R.string.camii_description,
                R.string.camii_hours,
                R.drawable.tokyo_mosque,
                R.drawable.tokyo_mosque_ic,
                R.string.camii_url,
                R.string.mosque_location));
        attractions.add(new Attraction(R.string.akasaka,
                R.string.akasaka_description,
                R.string.akasaka_hours,
                R.drawable.akasaka_palace,
                R.drawable.akasaka_palace_ic,
                R.string.akasaka_url,
                R.string.akasaka_location));
        attractions.add(new Attraction(R.string.tokyo_skytree,
                R.string.tokyo_skytree_description,
                R.string.skytree_hours,
                R.drawable.tokyo_skytree,
                R.drawable.tokyo_skytree_ic,
                R.string.skytree_url,
                R.string.tokyo_skytree_location));
        attractions.add(new Attraction(R.string.tokyo_tower,
                R.string.tokyo_tower_description,
                R.string.tokyo_tower_hours,
                R.drawable.tokyo_tower,
                R.drawable.tokyo_tower_ic,
                R.string.tokyo_tower_url,
                R.string.tokyo_tower_location));
        attractions.add(new Attraction(R.string.ginza,
                R.string.ginza_description,
                R.string.always_open_hours,
                R.drawable.ginza,
                R.drawable.ginza_ic,
                R.string.ginza_url,
                R.string.ginza_location));
        attractions.add(new Attraction(R.string.tokyo_station,
                R.string.tokyo_station_description,
                R.string.tokyo_station_hours,
                R.drawable.tokyo_station,
                R.drawable.tokyo_station_ic,
                R.string.tokyo_station_url,
                R.string.tokyo_station_location));


        //Sets up a custom Array adapter of custom Words objects using the custom words list
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_historical);

        //Finds the list view of the word_list.xml layout (this is UI)
        ListView listView = rootView.findViewById(R.id.list);

        //Implements the adapter in the listview that we found (This uses an UI method to link the both of the things that we created)
        listView.setAdapter(adapter);

        //Sets an onclick listener in each item of the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //Defines what to do when clicked, the int position, returns the index for the position of each word element
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //gets the current attraction object
                Attraction currentObject = attractions.get(position);

                //Opens an activity for the item clicked and passes all the object data
                Intent openSites = new Intent(getActivity(), ItemActivity.class);
                openSites.putExtra("image", currentObject.getPicResourceId());
                openSites.putExtra("name", currentObject.getName());
                openSites.putExtra("hours", currentObject.getBusinessHours());
                openSites.putExtra("contact", currentObject.getPhoneNumber());
                openSites.putExtra("description", currentObject.getDescription());
                openSites.putExtra("urlId", currentObject.getWebsiteURL());
                openSites.putExtra("location", currentObject.getLocation());
                openSites.putExtra("background", R.color.category_historical);
                startActivity(openSites);
            }
        });

        return rootView;
    }
}