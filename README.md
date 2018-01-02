# corodova-plugin-BaiduPush

This plugin is used to get the data from Baidu Push.Can't show the notification on device;

## Dependence
* libs/galaxy.jar
* pushservice-6.0.0.64.jar
* ufosdk-android-1.7.13.jar
* org.greenrobot:eventbus:3.1.1

## Installation

```shell
cordova plugin add https://github.com/SimarSima/corodova-plugin-BaiduPush.git --variable ANDROID_KEY="<API_KEY_ANDROID>"

# 此处的API_KEY_ANDROID来自于BaiduPush 项目配置，直接替换<API_KEY_XX>，也可以最后跟 --save 参数，将插件信息保存到config.xml中
```
Or
```shell
cordova plugin add git://github.com/SimarSima/corodova-plugin-BaiduPush.git --variable ANDROID_KEY="<API_KEY_ANDROID>"
```
## Uninstallation
```shell
cordova plugin remove simar.android.BaiduPushCordovaPlugin
```
## Usage
* JS
```js
    BaiduPushCordovaPlugin.startWork();
```
* TS
``` ts
     declare let cordova: any; //On the top of your ts file
     cordova.plugins.BaiduPushCordovaPlugin.startWork();//At the where you need

```

* The bind has been test OK!
