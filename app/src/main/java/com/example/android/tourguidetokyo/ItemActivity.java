package com.example.android.tourguidetokyo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        /**Gets all the variables passed by the item clicked.
         * @link imageId The attraction's image.
         * @link nameId The attraction's name.
         * @link hoursId The attraction's business hours.
         * @link contactId The attraction's contact phone number (As the contact is accessed in a listener it needs to be final).
         * @link descriptionId The attraction's description.
         * @link backgroundColor The category's color.
         * @link urlId The url of the attraction's website (As the urlId is accessed in a listener it needs to be final).
         * @link locationId the attraction's location (As the location is accessed in a listener it needs to be final).
         */

        Intent myIntent = getIntent();
        int imageId = myIntent.getIntExtra("image", Attraction.NO_DATA_PROVIDED);
        int nameId = myIntent.getIntExtra("name", Attraction.NO_DATA_PROVIDED);
        int hoursId = myIntent.getIntExtra("hours", Attraction.NO_DATA_PROVIDED);
        final int contactId = myIntent.getIntExtra("contact", Attraction.NO_DATA_PROVIDED);
        int descriptionId = myIntent.getIntExtra("description", Attraction.NO_DATA_PROVIDED);
        int backgroundColor = myIntent.getIntExtra("background", Attraction.NO_DATA_PROVIDED);
        final int urlId = myIntent.getIntExtra("urlId", Attraction.NO_DATA_PROVIDED);
        final int locationId = myIntent.getIntExtra("location", Attraction.NO_DATA_PROVIDED);

        //Finds the view of the image and replaces it
        ImageView imageAttractionView = findViewById(R.id.imageAttraction);
        imageAttractionView.setImageResource(imageId);

        //Finds the view of the title and replaces it
        TextView attractionTitleView = findViewById(R.id.attractionTitle);
        attractionTitleView.setText(nameId);
        attractionTitleView.setBackgroundColor(ContextCompat.getColor(this, backgroundColor));

        //Finds the view of the hours and replaces it
        TextView attractionHoursView = findViewById(R.id.hours_text_view_activity);
        attractionHoursView.setText(hoursId);

        //Finds the view of the address and adds a listener to it so when clicked it opens a browser or app with the location.
        ImageView attractionLocationView = findViewById(R.id.location_button);
        attractionLocationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMap = new Intent(Intent.ACTION_VIEW);
                //The location needs to always have the google's address at the beginning to start the maps app.
                openMap.setData(Uri.parse(getString(R.string.google_maps_url) + getString(locationId)));
                startActivity(openMap);
            }
        });


        //Finds the view of the website and adds a listener to it so when clicked it opens a browser with the website.
        ImageView attractionWebsiteView = findViewById(R.id.website_button);
        attractionWebsiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openUrl = new Intent(Intent.ACTION_VIEW);
                openUrl.setData(Uri.parse(getString(urlId)));
                startActivity(openUrl);
            }
        });

        //Finds the view of the contact and adds a dialer to it, only if the contact is provided
        //If not provided then it will hide the imageView
        ImageView attractionContactView = findViewById(R.id.contact_button);
        if (contactId != Attraction.NO_DATA_PROVIDED) {
            attractionContactView.setVisibility(View.VISIBLE);
            attractionContactView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Creates an intent to dial the contact phone
                    Intent openDialer = new Intent(Intent.ACTION_DIAL);
                    //Parses the resource id for the phone
                    openDialer.setData(Uri.parse("tel:" + getString(contactId)));
                    startActivity(openDialer);
                }
            });
        } else {
            LinearLayout frameContactView = findViewById(R.id.contact_button_frame);
            frameContactView.setVisibility(View.GONE);
        }

        //Finds the view of the description and replaces it
        TextView attractionDescriptionView = findViewById(R.id.description_text_view);
        attractionDescriptionView.setText(descriptionId);

    }
}