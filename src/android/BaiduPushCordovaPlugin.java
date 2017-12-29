package cordova.plugin.baiduPush;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class BaiduPushCordovaPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws
    JSONException {
    if (action.equals("startWork")) {
      MyPushMessageReceiver receiver = new MyPushMessageReceiver();
      receiver.setCallbackContext(callbackContext);
      PushManager.startWork(cordova.getActivity(), PushConstants.LOGIN_TYPE_API_KEY, Utils
        .getMetaValue(cordova.getActivity(), "api_key")
      );

      return true;
    }
    return false;
  }

  private void coolMethod(String message, CallbackContext callbackContext) {
    if (message != null && message.length() > 0) {
      callbackContext.success(message);
    } else {
      callbackContext.error("Expected one non-empty string argument.");
    }
  }
}
