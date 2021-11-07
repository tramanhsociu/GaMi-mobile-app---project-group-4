package com.example.SettingTitle;

public class Section {
    private String settingTitle;
    private int settingNext;

    public Section(String settingTitle, int settingNext) {
        this.settingTitle = settingTitle;
        this.settingNext = settingNext;
    }

    public String getSettingTitle() {
        return settingTitle;
    }

    public void setSettingTitle(String settingTitle) {
        this.settingTitle = settingTitle;
    }

    public int getSettingNext() {
        return settingNext;
    }

    public void setSettingNext(int settingNext) {
        this.settingNext = settingNext;
    }
}
