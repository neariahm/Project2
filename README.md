# Project2
![](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

Dog History App

## Description

This project demonstrates how to make web API requests using network calls, how to parse API responses, and how to load images from a network location and display them.

The completed app should:
* Display a random dog image
* Have a button that lets the user generate a new image


## Getting Started

### Dependencies

* [Retrofit with Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi?msclkid=56381962b2d111eca8064cdbfe36035f)
* [Coil](https://github.com/coil-kt/coil)

### API

* Main endpoint: https://dog.ceo/api/breeds/image/random 
* The API response from that endpoint looks like:
```
{
    "message": "https://images.dog.ceo/breeds/briard/n02105251_7738.jpg",
    "status": "success"
}
```
* You can read more about the specific endpoint here: https://dog.ceo/dog-api/documentation/random 


## App Preview

![](https://media.giphy.com/media/beEoUT2NXLawT0g2DW/giphy.gif)

## Extra Challenges

* Instead of saving only the previous dog image, save a complete history of all the dog image URLs that were retrieved from the dog-image web service in a Room database.Over time, your Room DB will have a long history of dog images (url strings).  Alternatively, you could save “favorite” dog images, but we’ll leave that up to you.
* Allow the user to see their current dog image history with a “History…” button on the main screen.  This button should display a secondary Activity (or Fragment) that shows the history list using a RecyclerView.  Of course the user should have the ability to return back to the main screen.  Every time the second Activity (or Fragment) is shown, you would select all the images in your database and display them in the RecyclerView.
* Since the history list is stored in a database, confirm the history data survives the life of the app.  
Shutdown the app and then restart it.  Your history list should still be there after you restart the app, if your storage code is correct.
* Build on the Challenge above and add a Button click-handler (actually 1 per list item)  to the RecyclerView in the “History” Activity/Fragment.  Using this click-handler, allow the user to click on any image URL to retrieve that specific image.  Display that image in the main screen as the current image.



## Helpful Resources
* Android Basics Pathway:
    *  [Introduction to SQL, Room, and Flow](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-5-pathway-1)
    * [Use Room for Data Persistence](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-5-pathway-2)




