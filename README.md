# Cosc 310 Assignment 4

The project is an Android app designed for Coffee shops to help manage their business. The app tracks inventory and sales information to help managers with their daily tasks and provide them with reports to make business decisions.

---

## Running the app

The app can be run in 2 different ways:  

1. Android Studio

    - Download, run, and update android studio. Open the entire app project inside Android studio to look at code, files, and layouts. You can run the app on an emulator inside the studio by clicking the "run app" button at the top right or through the dropdown menu (Run > Run App).  
    
1. Installed on an Android phone

    - Download the APK file to your android phone. Select the APK file and press open and then press install.


### Please note: As this app is designed to be used internally, there is no option to create a personal account. Accounts must be created by and given permission by admins.
### *App tested on Google Pixel 3a, may not look correct on all mobile devices or tablets.*

---

## Class Organization

Classes are organized in the java folder of the app project. These classes are then organized by android activities and include everything that activity needs. For example, all classes related to logging in are found in one folder. Images, fonts, and layouts are found in the res folder. The AndroidManifest is found in the manifest folder.

~~~

`-- javabucksim
    |-- MainActivity.java
    |-- StatisticsReport.java
    |-- listItems
    |   |-- Categories.java
    |   |-- Choices.java
    |   `-- Item.java
    |-- login
    |   |-- forgotPassword.java
    |   `-- loginActivity.java
    |-- orders
    |   |-- autoOrder.java
    |   |-- orderTile.java
    |   `-- order_RVAdapter.java
    |-- reportActivity.java
    `-- settings
        |-- User.java
        |-- UserRVAdapter.java
        |-- createAccount.java
        |-- editAccount.java
        |-- editUserAccounts.java
        |-- editUsers.java
        `-- settingsActivity.java

5 directories, 19 files
~~~


---

## Features Added for Assignment 4


1. Dynamic photos for items.
- Shows a photo of each specific item when it is chose from the "Select an item" page.
2. Search through items by name.
- Users can now search the categories and items by name to access them quicker.
3. Added an API to produce a joke upon login.
- Once logged in, users will recieve a "Dad Joke".
4. Added an API to show the temperature.
- Once logged in, users will see the temperature at their location.

