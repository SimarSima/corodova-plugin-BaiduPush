package cordova.plugin.baiduPush;

/**
 * Created by Administrator on 12/26/2017.
 */

public class MessageEvent {
  public static final int ACTION_ON_BIND = 0;
  private int errorCode;
  private int action;

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public int getAction() {
    return action;
  }

  public void setAction(int action) {
    this.action = action;
  }
}
