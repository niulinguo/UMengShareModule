package com.niles.umeng_share;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.niles.umeng.UMengConfig;
import com.niles.umeng.UMengSharePlatform;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Niles
 * Date 2018/10/23 08:41
 * Email niulinguo@163.com
 */
public class UMengShareManager {

    private static final String TAG = "Niles_Share";

    public static void init(Application app, boolean debug, UMengConfig config) {
        HashMap<UMengSharePlatform, String[]> shareInfo = config.getShareInfo();
        for (Map.Entry<UMengSharePlatform, String[]> entry : shareInfo.entrySet()) {
            UMengSharePlatform platform = entry.getKey();
            String[] value = entry.getValue();
            switch (platform) {
                case WEI_XIN: {
                    PlatformConfig.setWeixin(value[0], value[1]);
                    break;
                }
                default: {
                    Log.e(TAG, "暂不支持" + platform.name() + "平台");
                }
            }
        }
    }

    public static void share(Activity activity, UMengShareConfig config) {
        new ShareAction(activity)
                .setPlatform(config.getPlatform())
                .withText(config.getText())
                .setCallback(config.getShareCallback())
                .share();
    }
}
