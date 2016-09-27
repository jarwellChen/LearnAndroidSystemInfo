package com.jarwell.learnandroidsysteminfo;

import android.graphics.drawable.Drawable;

/**
 * Created by jarwell on 2016/9/27.
 */

public class PMAppInfo {
    private String appLabel;
    private Drawable appIcon;
    private String pkgName;

    public PMAppInfo(){}

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }
}
