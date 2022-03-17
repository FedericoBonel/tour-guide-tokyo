package com.example.android.tourguidetokyo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter {
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param attractions A List of word objects to display in a list.
     */
    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, int colorResourceId) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for Six TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link currentAttraction} object located at this position in the list
        Attraction currentAttraction = (Attraction) getItem(position);

        // Find the Layout that contains the text
        LinearLayout textContainer = listItemView.findViewById(R.id.text_container);

        //Returns a color associated with the color resource id of each category
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //Changes the color of the background to the desired color
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get the name for the current object and
        // set this text on the name TextView
        nameTextView.setText(currentAttraction.getName());

        // Find the TextView in the list_item.xml layout with the ID hours_text_view
        TextView hoursTextView = listItemView.findViewById(R.id.hours_text_view);
        // Get the default language translation for the current object and
        // set this text on the default TextView
        hoursTextView.setText(currentAttraction.getBusinessHours());

        //Only some items have a contact phone number.
        TextView contactTextView = listItemView.findViewById(R.id.phone_text_view);
        if (currentAttraction.hasContact()) {
            // If the current object has a contact linked to the attraction, get the contact's resource ID and
            //set it to the corresponding textview.
            contactTextView.setText(currentAttraction.getPhoneNumber());
            // Make sure the image is visible
            contactTextView.setVisibility(View.VISIBLE);
        } else {
            //Otherwise it hides the default textView.
            contactTextView.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the ID description_text_view
        TextView descriptionTextView = listItemView.findViewById(R.id.description_text_view);
        //Set this text on the description TextView
        descriptionTextView.setText(currentAttraction.getDescription());

        //Find the ImageView in the list_item.xml layout for the lower resolution version of the image
        ImageView image = listItemView.findViewById(R.id.image);
        //Sets that image as the icon
        image.setImageResource(currentAttraction.getIconImageId());

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;

    }
}
