# corodova-plugin-BaiduPush

This plugin is used to get the data from Baidu Push.Can't show the dialog on device;

## Installation

```shell
cordova plugin add https://github.com/SimarSima/corodova-plugin-BaiduPush.git --variable ANDROID_KEY="<API_KEY_ANDROID>"

# 此处的API_KEY_ANDROID来自于BaiduPush 项目配置，直接替换<API_KEY_XX>，也可以最后跟 --save 参数，将插件信息保存到config.xml中
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
* Ts
``` ts
     declare let cordova: any; //On the top of your ts file
     cordova.plugins.BaiduPushCordovaPlugin.startWork();//At the where you need

```
# Haven't been tested!!!!
