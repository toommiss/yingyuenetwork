package mypower.example.com.yingyuenetwork.network.model;

import android.util.Log;

public class YingyueException extends java.lang.Exception {
    /**
     * 判断是否是null的异常
     */
    public static boolean isNULL(Object obj) {
        if (obj == null) {
            Log.e("Exception yingyue", "输入内容NULL"+obj.getClass());
            return true;
        } else {
            return false;
        }
    }

}
