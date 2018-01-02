package cordova.plugin.baiduPush;

import org.apache.cordova.CallbackContext;

/**
 * Created by Administrator on 12/26/2017.
 */

public class MessageEvent {
  public static final int ACTION_ON_BIND = 0;
  private int errorCode;
  private String errorInfo;
  private int resultCode;
  private String resultInfo;
  public static CallbackContext callbackContext;

  public String getResultInfo() {
    return resultInfo;
  }

  public void setResultInfo(String resultInfo) {
    this.resultInfo = resultInfo;
  }

  public String getErrorInfo() {
    return errorInfo;
  }

  public void setErrorInfo(String errorInfo) {
    this.errorInfo = errorInfo;
  }


  public int getResultCode() {
    return resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }


}
