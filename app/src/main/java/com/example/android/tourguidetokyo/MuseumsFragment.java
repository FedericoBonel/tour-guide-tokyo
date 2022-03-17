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
 * The Museums list fragment
 */
public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        //ArrayList of Attractions

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.edo_tokyo_museum,
                R.string.edo_tokyo_description,
                R.string.edo_museum_hours,
                R.drawable.edo_tokyo_museum,
                R.string.contact_tokyo_museum,
                R.drawable.edo_tokyo_museum_ic,
                R.string.edo_museum_url,
                R.string.edo_tokyo_location));
        attractions.add(new Attraction(R.string.samurai_museum,
                R.string.samurai_museum_description,
                R.string.samurai_museum_hours,
                R.drawable.samurai_museum,
                R.string.contact_samurai_museum,
                R.drawable.samurai_museum_ic,
                R.string.samurai_museum_url,
                R.string.samurai_museum_location));
        attractions.add(new Attraction(R.string.nature_science,
                R.string.nature_science_description,
                R.string.nature_science_museum_hours,
                R.drawable.natural_museum,
                R.string.contact_nature_science,
                R.drawable.natural_museum_ic,
                R.string.national_nature_museum_url,
                R.string.national_nature_science_location));
        attractions.add(new Attraction(R.string.national_museum,
                R.string.tokyo_national_description,
                R.string.national_museum_hours,
                R.drawable.national_museum,
                R.string.contact_national_museum,
                R.drawable.national_museum_ic,
                R.string.tokyo_national_museum_url,
                R.string.national_location));
        attractions.add(new Attraction(R.string.ghibli_museum,
                R.string.ghibli_description,
                R.string.ghibli_museum_hours,
                R.drawable.ghibli_museum,
                R.string.contact_ghibli_museum,
                R.drawable.ghibli_museum_ic,
                R.string.ghibli_museum_url,
                R.string.ghibli_location));
        attractions.add(new Attraction(R.string.western_art_museum,
                R.string.western_art_description,
                R.string.western_museum_hours,
                R.drawable.western_museum,
                R.string.contact_western_art_museum,
                R.drawable.western_museum_ic,
                R.string.western_art_museum_url,
                R.string.western_art_location));
        attractions.add(new Attraction(R.string.planets_teamLab,
                R.string.teamLab_description,
                R.string.teamLab_hours,
                R.drawable.teamlab,
                R.string.contact_planets_teamLab,
                R.drawable.teamlab_ic,
                R.string.teamLab_museum_url,
                R.string.teamLab_location));

        //Sets up a custom Array adapter of custom Words objects using the custom words list
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_museums);

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
                Intent openMuseums = new Intent(getActivity(), ItemActivity.class);
                openMuseums.putExtra("image", currentObject.getPicResourceId());
                openMuseums.putExtra("name", currentObject.getName());
                openMuseums.putExtra("hours", currentObject.getBusinessHours());
                openMuseums.putExtra("contact", currentObject.getPhoneNumber());
                openMuseums.putExtra("description", currentObject.getDescription());
                openMuseums.putExtra("urlId", currentObject.getWebsiteURL());
                openMuseums.putExtra("location", currentObject.getLocation());
                openMuseums.putExtra("background", R.color.category_museums);
                startActivity(openMuseums);
            }
        });

        return rootView;
    }
}