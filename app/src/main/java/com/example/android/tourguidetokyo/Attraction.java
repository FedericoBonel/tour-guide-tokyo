package com.example.android.tourguidetokyo;

/**
 * @link represents an attraction, with a name for the object, short description,
 * Business hours, websites url, pictures, and in some cases only Contact phone numbers.
 */
public class Attraction {
    //Variables definition:

    //Constant for the optional data
    //We use a -2 instead of -1 because in some cases it overlapped possible values.
    public static final int NO_DATA_PROVIDED = -2;
    //Attraction name id
    private int mName;
    //Short description id
    private int mDescription;
    //Business hours id
    private int mBusinessHours;
    //Main Picture resource id
    private int mPicResourceId;
    //Small version of the main picture resource id, this is for the AttractionAdapter
    private int mIconImageId;
    //Contact Phone Number id
    private int mPhoneNumber = NO_DATA_PROVIDED;
    //Website's Url id
    private int mWebsiteURL;
    //Attraction's address as a google maps link's id.
    private int mLocation;

    //Constructors:

    /**
     * Constructs a new Attraction object with url but without Contact Phone Number
     *
     * @param name          is the name of the attraction.
     * @param description   is a short description of the attraction.
     * @param businessHours is the bussiness hours of the attraction.
     * @param picResourceId is the id of the image to use for the attraction
     * @param iconImageId   Id of the main pic's small version icon
     * @param urlId         Url of the attraction's website
     */
    public Attraction(int name, int description, int businessHours, int picResourceId, int iconImageId, int urlId, int location) {
        mName = name;
        mDescription = description;
        mBusinessHours = businessHours;
        mPicResourceId = picResourceId;
        mIconImageId = iconImageId;
        mWebsiteURL = urlId;
        mLocation = location;
    }

    /**
     * Constructs a new Attraction object including a Contact Phone Number
     *
     * @param name          is the name of the attraction.
     * @param description   is a short description of the attraction.
     * @param businessHours is the bussiness hours of the attraction.
     * @param picResourceId is the id of the image to use for the attraction.
     * @param phoneNumber   is the contact phone number for the business.
     * @param iconImageId   Id of the main pic's small version icon
     * @param urlId         Id of the attraction's URL
     */
    public Attraction(int name, int description, int businessHours, int picResourceId, int phoneNumber, int iconImageId, int urlId, int location) {
        mName = name;
        mDescription = description;
        mBusinessHours = businessHours;
        mPicResourceId = picResourceId;
        mPhoneNumber = phoneNumber;
        mIconImageId = iconImageId;
        mWebsiteURL = urlId;
        mLocation = location;
    }

    //Methods

    /**
     * @returns the name of attraction
     */
    public int getName() {
        return mName;
    }

    /**
     * @returns the description of attraction
     */
    public int getDescription() {
        return mDescription;
    }

    /**
     * @returns the Business's hours
     */
    public int getBusinessHours() {
        return mBusinessHours;
    }

    /**
     * @returns the resource Id for the attraction's image
     */
    public int getPicResourceId() {
        return mPicResourceId;
    }

    /**
     * @returns the contact phone number
     */
    public int getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * @returns the category icon ID
     */
    public int getIconImageId() {
        return mIconImageId;
    }

    /**
     * @returns the website url
     */
    public int getWebsiteURL() {
        return mWebsiteURL;
    }

    /**
     * @returns the google maps link for the attraction's location
     */
    public int getLocation() {
        return mLocation;
    }

    /**
     * @returns true if the attraction has a phone number
     */
    public boolean hasContact() {
        return mPhoneNumber != NO_DATA_PROVIDED;
    }

    /**
     * @returns a string with all the variables  for debugging
     */
    @Override
    public String toString() {
        return "Attraction{" +
                "mName=" + mName +
                ", mDescription=" + mDescription +
                ", mBusinessHours=" + mBusinessHours +
                ", mPicResourceId=" + mPicResourceId +
                ", mIconImageId=" + mIconImageId +
                ", mPhoneNumber=" + mPhoneNumber +
                ", mWebsiteURL=" + mWebsiteURL +
                ", mLocation=" + mLocation +
                '}';
    }
}
