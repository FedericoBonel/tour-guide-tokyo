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
 * The Parks list fragment
 */
public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //ArrayList of Attractions

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.yoyogi_park,
                R.string.yoyogi_description,
                R.string.always_open_hours,
                R.drawable.yoyogi_park,
                R.drawable.yoyogi_park_ic,
                R.string.yoyogi_park_url,
                R.string.yoyogi_location));
        attractions.add(new Attraction(R.string.shiba_park,
                R.string.shiba_park_description,
                R.string.always_open_hours,
                R.drawable.shiba_park,
                R.drawable.shiba_park_ic,
                R.string.shiba_park_url,
                R.string.shiba_location));
        attractions.add(new Attraction(R.string.ueno_park,
                R.string.ueno_park_description,
                R.string.ueno_park_hours,
                R.drawable.ueno_park,
                R.drawable.ueno_park_ic,
                R.string.ueno_park_url,
                R.string.ueno_location));
        attractions.add(new Attraction(R.string.nature_study_park,
                R.string.nature_study_description,
                R.string.institute_nature_study_hours,
                R.drawable.institute_nature_park,
                R.drawable.institute_nature_park_ic,
                R.string.nature_park_url,
                R.string.nature_studies_location));
        attractions.add(new Attraction(R.string.shinjuku_national_park,
                R.string.shinjuku_gyoen_description,
                R.string.shinjuku_gyoen_hours,
                R.drawable.shinjuku_gyoen,
                R.drawable.shinjuku_gyoen_ic,
                R.string.shinjuku_national_park_url,
                R.string.shinjuku_gyoen_location));
        attractions.add(new Attraction(R.string.imperial_palace,
                R.string.imperial_garden_description,
                R.string.imperial_palace_hours,
                R.drawable.imperial_palace_garden,
                R.drawable.imperial_palace_garden_ic,
                R.string.imperial_palace_url,
                R.string.imperial_palace_location));
        attractions.add(new Attraction(R.string.rikyu_garden,
                R.string.rikyu_garden_description,
                R.string.hama_rikyu_hours,
                R.drawable.hama_rikyu_garden,
                R.drawable.hama_rikyu_garden_ic,
                R.string.rikyu_garden_url,
                R.string.rikyu_gardens_location));
        attractions.add(new Attraction(R.string.takao_mountain,
                R.string.mount_takao_description,
                R.string.mount_takao_hours,
                R.drawable.mount_takao,
                R.drawable.mount_takao_ic,
                R.string.mount_takao_url,
                R.string.mount_takao_location));
        attractions.add(new Attraction(R.string.nokogiri_mountain,
                R.string.nokogiri_mountain_description,
                R.string.mount_nokogiri_hours,
                R.drawable.mount_nokogiri,
                R.drawable.mount_nokogiri_ic,
                R.string.mount_nokogiri_url,
                R.string.mount_nokogiri_location));

        //Sets up a custom Array adapter of custom Words objects using the custom words list
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_parks);

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
                Intent openParks = new Intent(getActivity(), ItemActivity.class);
                openParks.putExtra("image", currentObject.getPicResourceId());
                openParks.putExtra("name", currentObject.getName());
                openParks.putExtra("hours", currentObject.getBusinessHours());
                openParks.putExtra("contact", currentObject.getPhoneNumber());
                openParks.putExtra("description", currentObject.getDescription());
                openParks.putExtra("urlId", currentObject.getWebsiteURL());
                openParks.putExtra("location", currentObject.getLocation());
                openParks.putExtra("background", R.color.category_parks);
                startActivity(openParks);
            }
        });

        return rootView;
    }
}