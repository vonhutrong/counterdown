package com.trongvn13.counterdown.presenter;

import com.trongvn13.counterdown.view.SettingViewInterface;

public interface SettingPresenterInterface {

    void startCounter(String stringTime, String message);
    AlertPresenterInterface getAlertPresenter();
    void setAlertPresenter(AlertPresenterInterface presenter);
    void setView(SettingViewInterface settingView);
    void showView();

}
