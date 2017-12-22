var exec = require('cordova/exec');

var BaiduPushCordovaPlugin = {
    startWork: function (arg0, success, error) {
        exec(success, error, "BaiduPushCordovaPlugin", "startWork", [arg0]);
    }
}
module.exports = BaiduPushCordovaPlugin;