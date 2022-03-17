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
 * The Restaurants list fragment
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.word_list, container, false);

        //ArrayList of Attractions
        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.sueyoshi_restaurant,
                R.string.ise_sueyoshi_description,
                R.string.sueyoshi_hours,
                R.drawable.ise_sueyoshi_restaurant,
                R.string.sueyoshi_phone,
                R.drawable.ise_sueyoshi_restaurant_ic,
                R.string.ise_url,
                R.string.ise_sueyoshi_location));
        attractions.add(new Attraction(R.string.miyazono_restaurant,
                R.string.miyazono_description,
                R.string.miyazono_hours,
                R.drawable.miyazono_restaurant,
                R.string.miyazono_phone,
                R.drawable.miyazono_restaurant_ic,
                R.string.miyazono_url,
                R.string.miyazono_location));
        attractions.add(new Attraction(R.string.kaneko_restaurant,
                R.string.kaneko_description,
                R.string.kanneko_hours,
                R.drawable.kanneko_hannosuke,
                R.string.kanneko_phone,
                R.drawable.kanneko_hannosuke_ic,
                R.string.kanneko_url,
                R.string.kanneko_location));
        attractions.add(new Attraction(R.string.izumoya_restaurant,
                R.string.izumoya_description,
                R.string.izumoya_hours,
                R.drawable.izumoya_restaurant,
                R.string.izumoya_phone,
                R.drawable.izumoya_restaurant_ic,
                R.string.izumoya_url,
                R.string.izumoya_location));
        attractions.add(new Attraction(R.string.honmura_soba_restaurant,
                R.string.honmura_description,
                R.string.honmura_hours,
                R.drawable.honmura_an_restaurant,
                R.string.honmura_phone,
                R.drawable.honmura_an_restaurant_ic,
                R.string.honmura_url,
                R.string.honmura_location));
        attractions.add(new Attraction(R.string.kanda_soba_restaurant,
                R.string.kanda_description,
                R.string.kanda_matsuya_hours,
                R.drawable.kanda_matsuya_restaurant,
                R.string.matsuya_phone,
                R.drawable.kanda_matsuya_restaurant_ic,
                R.string.kanda_matsuya_url,
                R.string.kanda_location));
        attractions.add(new Attraction(R.string.oniyanma_udon_restaurant,
                R.string.oniyanma_description,
                R.string.oniyanma_hours,
                R.drawable.oniyanma_restaurant,
                R.drawable.oniyanma_restaurant_ic,
                R.string.oniyanma_url,
                R.string.oniyanma_location));
        attractions.add(new Attraction(R.string.land_curry_restaurant,
                R.string.land_description,
                R.string.land_hours,
                R.drawable.land_curry_restaurant,
                R.string.land_curry_phone,
                R.drawable.land_curry_restaurant_ic,
                R.string.land_url,
                R.string.land_location));
        attractions.add(new Attraction(R.string.mouyan_curry_restaurant,
                R.string.mouyan_description,
                R.string.mouyan_hours,
                R.drawable.mouyan_curry_restaurant,
                R.string.mouyan_phone,
                R.drawable.mouyan_curry_restaurant_ic,
                R.string.mouyan_url,
                R.string.mouyan_location));
        attractions.add(new Attraction(R.string.ton_kyu_tonkatsu_restaurant,
                R.string.tonkyu_description,
                R.string.tonkyu_hours,
                R.drawable.tonkyu_restuarant,
                R.string.tonkyu_phone,
                R.drawable.tonkyu_restuarant_ic,
                R.string.tonkyu_url,
                R.string.tonkyu_location));
        attractions.add(new Attraction(R.string.yakiniku_karubiano,
                R.string.karubiano_description,
                R.string.karubiano_hours,
                R.drawable.karubiano_restuarant,
                R.string.karubiano_phone,
                R.drawable.karubiano_restuarant_ic,
                R.string.karubiano_url,
                R.string.karubiano_location));


        //Sets up a custom Array adapter of custom Words objects using the custom words list
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_restaurants);

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
                Intent openRestaurant = new Intent(getActivity(), ItemActivity.class);
                openRestaurant.putExtra("image", currentObject.getPicResourceId());
                openRestaurant.putExtra("name", currentObject.getName());
                openRestaurant.putExtra("hours", currentObject.getBusinessHours());
                openRestaurant.putExtra("contact", currentObject.getPhoneNumber());
                openRestaurant.putExtra("description", currentObject.getDescription());
                openRestaurant.putExtra("urlId", currentObject.getWebsiteURL());
                openRestaurant.putExtra("location", currentObject.getLocation());
                openRestaurant.putExtra("background", R.color.category_restaurants);
                startActivity(openRestaurant);
            }
        });
        return rootView;
    }
}