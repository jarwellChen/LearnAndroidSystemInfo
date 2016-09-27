package com.jarwell.learnandroidsysteminfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;



public class Utils {
    public static final int ALL_APP=0;
    public static final int SYSTEM_APP=1;
    public static final int THIRD_APP=2;
    public static final int SDCARD_APP=3;
    static PackageManager pm=null;
    public static List<PMAppInfo> getAppInfo(Context context,int flag){
        pm=context.getPackageManager();
        //get app info
        List<ApplicationInfo> applicationInfoList=pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        ArrayList<PMAppInfo> appInfos=new ArrayList<>();
        //judge app's type
        switch (flag){
            case ALL_APP:
                appInfos.clear();
                for (ApplicationInfo app:applicationInfoList){
                    appInfos.add(makeAppInfo(app));
                }
                break;
            case SYSTEM_APP:
                appInfos.clear();
                for (ApplicationInfo app:applicationInfoList){
                    if ((app.flags&ApplicationInfo.FLAG_SYSTEM)!=0){
                        appInfos.add(makeAppInfo(app));
                    }
                }
                break;
            case THIRD_APP:
                appInfos.clear();
                for(ApplicationInfo app:applicationInfoList){
                    if ((app.flags&ApplicationInfo.FLAG_SYSTEM)<=0){
                        appInfos.add(makeAppInfo(app));
                    }
                }
                break;
            case SDCARD_APP:
                appInfos.clear();
                for(ApplicationInfo app:applicationInfoList){
                    if ((app.flags&ApplicationInfo.FLAG_EXTERNAL_STORAGE)!=0){
                        appInfos.add(makeAppInfo(app));
                    }
                }
                break;
            default:
                return null;
        }
        return appInfos;
    }

    private static PMAppInfo makeAppInfo(ApplicationInfo app) {
        PMAppInfo appInfo=new PMAppInfo();
        appInfo.setAppLabel((String)app.loadLabel(pm));
        appInfo.setAppIcon(app.loadIcon(pm));
        appInfo.setPkgName(app.packageName);
        return appInfo;
    }
}
