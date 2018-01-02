var exec = require('cordova/exec');

var BaiduPushCordovaPlugin = {
    startWork: function (success, error) {
        exec(success, error, "BaiduPushCordovaPlugin", "startWork", []);
    }
}
module.exports = BaiduPushCordovaPlugin;