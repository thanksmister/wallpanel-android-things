# Wall Panel Android Things

An application for Android Things to display Home Automation Platform dashboards.

## Getting Started

This application is designed to be run as the main system app on [Android Things](https://developer.android.com/things).

* Flash Android Things onto a developer board (e.g. [flash onto a Raspberry Pi 3](https://developer.android.com/things/hardware/raspberrypi.html) with the [official Raspberry Pi touchscreen](https://www.raspberrypi.org/products/raspberry-pi-touch-display/) connected), boot it up and connect it to your local network via Ethernet or WiFi
* Clone this GitHub project onto a desktop computer and import the project into [Android Studio](https://developer.android.com/studio/index.html)
* Change the `HOME_PAGE` constant in `app/src/main/java/org/mozilla/iot/thingscontroller/MainActivity.java` to the URL of your Things Gateway, or some other web page of your choice
* Connect your desktop computer to the development board using `adb connect {ip address}` where `{ip address}` is the IP address displayed on the screen of your development board
* Click the "run" button to deploy the app to your development board over adb

