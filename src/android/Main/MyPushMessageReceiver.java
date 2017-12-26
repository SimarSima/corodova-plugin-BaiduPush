package cordova.plugin.baiduPush;

import android.content.Context;
import android.text.TextUtils;

import com.baidu.android.pushservice.PushMessageReceiver;

import org.apache.cordova.LOG;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class MyPushMessageReceiver extends PushMessageReceiver {

  public static final String TAG = "BaiduPushCodovaPlugin";

  /**
   * 调用PushManager.startWork后，sdk将对push
   * server发起绑定请求，这个过程是异步的。绑定请求的结果通过onBind返回。 如果您需要用单播推送，需要把这里获取的channel
   * id和user id上传到应用server中，再调用server接口用channel id和user id给单个手机或者用户推送。
   *
   * @param context   BroadcastReceiver的执行Context
   * @param errorCode 绑定接口返回值，0 - 成功
   * @param appid     应用id。errorCode非0时为null
   * @param userId    应用user id。errorCode非0时为null
   * @param channelId 应用channel id。errorCode非0时为null
   * @param requestId 向服务端发起的请求id。在追查问题时有用；
   * @return none
   */
  @Override
  public void onBind(Context context, int errorCode, String appid, String userId, String channelId,
                     String requestId) {
    String responseString = "onBind errorCode=" + errorCode + " appid=" + appid + " userId=" +
      userId
      + " channelId=" + channelId + " requestId=" + requestId;
    LOG.d(TAG, responseString);
    EventBus.getDefault().register(this);
    MessageEvent event=new MessageEvent();
    event.setErrorCode(errorCode);
    event.setAction(event.ACTION_ON_BIND);
    if (errorCode == 0) {
      // 绑定成功
      LOG.d(TAG, TAG + "On Bind OK");
    } else {
      LOG.e(TAG, TAG + "On Bind Error" + errorCode);
    }
    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(event);

  }

  /**
   * 接收透传消息的函数。
   *
   * @param context             上下文
   * @param message             推送的消息
   * @param customContentString 自定义内容,为空或者json字符串
   */
  @Override
  public void onMessage(Context context, String message, String customContentString) {
    String messageString = "透传消息 onMessage=\"" + message + "\" customContentString=" +
      customContentString;

    LOG.d(TAG, "ForTest" + messageString);

    // 自定义内容获取方式，mykey和myvalue对应透传消息推送时自定义内容中设置的键和值
    if (!TextUtils.isEmpty(customContentString)) {
      JSONObject customJson = null;
      try {
        customJson = new JSONObject(customContentString);
        String myvalue = null;
        if (!customJson.isNull("mykey")) {
          myvalue = customJson.getString("mykey");
        }
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }

    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(context, messageString);
  }

  /**
   * 接收通知到达的函数。
   *
   * @param context             上下文
   * @param title               推送的通知的标题
   * @param description         推送的通知的描述
   * @param customContentString 自定义内容，为空或者json字符串
   */

  @Override
  public void onNotificationArrived(Context context, String title, String description, String
    customContentString) {

    String notifyString = "通知到达 onNotificationArrived  title=\"" + title + "\" description=\"" +
      description
      + "\" customContent=" + customContentString;
    LOG.d(TAG, notifyString);

    // 自定义内容获取方式，mykey和myvalue对应通知推送时自定义内容中设置的键和值
    if (!TextUtils.isEmpty(customContentString)) {
      JSONObject customJson = null;
      try {
        customJson = new JSONObject(customContentString);
        String myvalue = null;
        if (!customJson.isNull("mykey")) {
          myvalue = customJson.getString("mykey");
        }
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    // 你可以參考 onNotificationClicked中的提示从自定义内容获取具体值
    updateContent(context, notifyString);
  }

  /**
   * 接收通知点击的函数。
   *
   * @param context             上下文
   * @param title               推送的通知的标题
   * @param description         推送的通知的描述
   * @param customContentString 自定义内容，为空或者json字符串
   */
  @Override
  public void onNotificationClicked(Context context, String title, String description, String
    customContentString) {
    String notifyString = "通知点击 onNotificationClicked title=\"" + title + "\" description=\"" +
      description
      + "\" customContent=" + customContentString;
    LOG.d(TAG, notifyString);

    // 自定义内容获取方式，mykey和myvalue对应通知推送时自定义内容中设置的键和值
    if (!TextUtils.isEmpty(customContentString)) {
      JSONObject customJson = null;
      try {
        customJson = new JSONObject(customContentString);
        String myvalue = null;
        if (!customJson.isNull("mykey")) {
          myvalue = customJson.getString("mykey");
        }
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(context, notifyString);
  }

  /**
   * setTags() 的回调函数。
   *
   * @param context     上下文
   * @param errorCode   错误码。0表示某些tag已经设置成功；非0表示所有tag的设置均失败。
   * @param successTags 设置成功的tag
   * @param failTags    设置失败的tag
   * @param requestId   分配给对云推送的请求的id
   */
  @Override
  public void onSetTags(Context context, int errorCode, List<String> successTags, List<String>
    failTags,
                        String requestId) {
    String responseString = "onSetTags errorCode=" + errorCode + " successTags=" + successTags +
      " failTags="
      + failTags + " requestId=" + requestId;
    LOG.d(TAG, responseString);

    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(context, responseString);
  }

  /**
   * delTags() 的回调函数。
   *
   * @param context     上下文
   * @param errorCode   错误码。0表示某些tag已经删除成功；非0表示所有tag均删除失败。
   * @param successTags 成功删除的tag
   * @param failTags    删除失败的tag
   * @param requestId   分配给对云推送的请求的id
   */
  @Override
  public void onDelTags(Context context, int errorCode, List<String> successTags, List<String>
    failTags,
                        String requestId) {
    String responseString = "onDelTags errorCode=" + errorCode + " successTags=" + successTags +
      " failTags="
      + failTags + " requestId=" + requestId;
    LOG.d(TAG, responseString);

    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(context, responseString);
  }

  /**
   * listTags() 的回调函数。
   *
   * @param context   上下文
   * @param errorCode 错误码。0表示列举tag成功；非0表示失败。
   * @param tags      当前应用设置的所有tag。
   * @param requestId 分配给对云推送的请求的id
   */
  @Override
  public void onListTags(Context context, int errorCode, List<String> tags, String requestId) {
    String responseString = "onListTags errorCode=" + errorCode + " tags=" + tags;
    LOG.d(TAG, responseString);

    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(context, responseString);
  }

  /**
   * PushManager.stopWork() 的回调函数。
   *
   * @param context   上下文
   * @param errorCode 错误码。0表示从云推送解绑定成功；非0表示失败。
   * @param requestId 分配给对云推送的请求的id
   */
  @Override
  public void onUnbind(Context context, int errorCode, String requestId) {
    String responseString = "onUnbind errorCode=" + errorCode + " requestId = " + requestId;
    LOG.d(TAG, responseString);
    EventBus.getDefault().unregister(this);
    if (errorCode == 0) {
      // 解绑定成功
      LOG.d(TAG, "onUnbind OK");
    }
    // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
    updateContent(context, responseString);
  }

  private void updateContent(MessageEvent event) {
    EventBus.getDefault().post(event);
  }
  private void updateContent(Context context, String content) {
    LOG.d(TAG, "updateContent");
    LOG.d(TAG, "ForTest Message" + content);
  }
}
