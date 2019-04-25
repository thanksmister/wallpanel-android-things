# Wall Panel Android Things

An application for Android Things to display Home Automation Platform dashboard web pages.  The application not only loads web pages, it also allows two-way communication using MQTT.  

To use the application with [Home Assistant](https://home-assistant.io/getting-started/), you need to have the MQTT service setup and configured. In the application you enter your MQTT broker address, port number, and credentials if necessary. You can also use this application with any home automation system that supports MQTT. 

## Features
- Web Based Dashboards and Home Automation Platforms support.
- Streaming MJPEG server support using the RPi V2 camera.
- Motion dection to wake the screen using an PIR sensor.
- Google Text-to-Speech support to speak notification messages using MQTT.
- MQTT commands to remotely control device and application (url, brightness, wake, etc.).
- Sensor data reporting for the device (temperature, light, pressure, battery).

## Getting Started

This application is designed to be run as the main system app on [Android Things](https://developer.android.com/things). Google has decided not to support the RPi for Android Things other than for development. As a result, Android Things will not work on the new RPi 3 B+, it will only work on older RPi 3 devices.

* Flash Android Things onto a developer board (e.g. [flash onto a Raspberry Pi 3](https://developer.android.com/things/hardware/raspberrypi.html) with the [official Raspberry Pi touchscreen](https://www.raspberrypi.org/products/raspberry-pi-touch-display/) connected), boot it up and connect it to your local network via Ethernet or WiFi
* Clone this GitHub project onto a desktop computer and import the project into [Android Studio](https://developer.android.com/studio/index.html)
* Connect your desktop computer to the development board using `adb connect {ip address}` where `{ip address}` is the IP address displayed on the screen of your development board
* Click the "run" button to deploy the app to your development board over adb

## Support

For issues, feature requests, comments or questions, use the [Github issues tracker](https://github.com/thanksmister/wallpanel-android-things/issues). 

## Device Settings
To open the settings, there is a button when you first launch the application. You can also open the settings by opening the drawer from the dashbaord by sliding right from the left side of the screen.

Under the Device Settings in settings, you can change the screen timeout time, screen brightness, and the screen density (for the official screen use a DPI of 240).  Additionally you can set the time and timezone for the application. 

## MQTT Sensor and State Data
If MQTT is enabled in the settings and MQTT properly configured, the application can publish data and states for various device sensors, motion detection, and application states.

### Device Sensors
The application will post device sensors data per the API description and Sensor Reading Frequency. Currently device sensors for Pressure, Temperature, Light, and Battery Level are published. 

wake | false | ```{"wake": false}``` | Release screen wake (Note: screen will not turn off before Androids Display Timeout finished)
speak | data | ```{"speak": "Hello!"}``` | Uses the devices TTS to speak the message
brightness | data | ```{"brightness": 1}``` | Changes the screens brightness, value 1-255. 
camera | data | ```{"camera": true}``` | Turns on/off camera streaming, requires camera to be enabled.
volume | data | ```{"volume": 100}``` | Changes the audio volume, value 0-100 (in %. Does not effect TTS volume).

* The base topic value (default is "mywallpanel") should be unique to each device running the application unless you want all devices to receive the same command. The base topic and can be changed in the applications ```MQTT settings```.
* Commands are constructed via valid JSON. It is possible to string multiple commands together:
  * eg, ```{"clearCache":true, "relaunch":true}```
* MQTT
  * WallPanel subscribes to topic ```wallpanel/[baseTopic]/command```
    * Default Topic: ```wallpanel/mywallpanel/command```
  * Publish a JSON payload to this topic (be mindfula of quotes in JSON should be single quotes not double)

### Google Text-To-Speach Command
You can send a command using MQTT to have the device speak a message using Google's Text-To-Speach. 

Example format for the message topic and payload: 

```{"topic":"wallpanel/mywallpanel/command", "payload":"{'speak':'Hello!'}"}```

## Raspberry PI Screen

Make sure you properly setup the RPi3 with the 7" Touchscreen Display.  You won't need any special software setup if you use the The Raspberry Pi Foundation 7" Touchscreen as it's compatible with Android Things. Other compatible touch screens may require additional configuration for Android Things.

## PIR Sensor (Optional)

If you would like the alarm panel to awake when motion is detected then add a PIR sensor following the Fritzing diagram provided below.

## Raspberry PI Camera Module

For the camera, I recommend the official Raspberry Pi Found dation [Camera Module V2](https://www.raspberrypi.org/products/camera-module-v2/).  You only need to plug it in and then turn on the camera in the settings. 

## Raspberry Pi Fritzing Diagram

![pir_rpi3_bb](https://user-images.githubusercontent.com/142340/38437807-007ba368-39af-11e8-82ae-09e10959e743.png)

## Enclosure

Originally I 3D printed an enclosure: https://www.thingiverse.com/thing:1082431. However, I ended up buying a SmartPi Touch case which is a great option especially if you have the [Camera Module v2](https://www.raspberrypi.org/products/camera-module-v2/).
