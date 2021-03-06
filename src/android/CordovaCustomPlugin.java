package info.androidabcd.plugins.custom;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.operations.Operations;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaCustomPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("sum")) {
            double num1 = args.getDouble(0);
            double num2 = args.getDouble(1);
            this.sum(num1, num2, callbackContext);
            return true;
        }
        return false;
    }

    private void sum(Double num1, Double num2, CallbackContext callbackContext) {
        if (num1 != null && num2 != null) {
            double res = Operations.sum(num1, num2);
            String sRes = String.valueOf(res);
            callbackContext.success(sRes);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
