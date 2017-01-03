package com.trongvn13.counterdown.presenter;

import com.trongvn13.counterdown.model.Counter;
import com.trongvn13.counterdown.model.CounterListener;
import com.trongvn13.counterdown.view.SettingViewInterface;

public class SettingPresenter implements SettingPresenterInterface {
    private AlertPresenterInterface alertPresenter = null;
    private SettingViewInterface settingView = null;
    
    @Override
    public void startCounter(String stringTime, String message) {
        long time = Long.parseLong(stringTime);

        Counter counter = new Counter(time);
        counter.addListener(new CounterListener() {
            @Override
            public void onTimed() {
                getAlertPresenter().showAlert(message);
            }
        });
        counter.start();
    }

    @Override
    public AlertPresenterInterface getAlertPresenter() {
        return this.alertPresenter;
    }

    @Override
    public void setAlertPresenter(AlertPresenterInterface presenter) {
        alertPresenter = presenter;
    }

    public SettingViewInterface getSettingView() {
        return settingView;
    }

    @Override
    public void setView(SettingViewInterface settingView) {
        this.settingView  = settingView;
    }

    @Override
    public void showView() {
        getSettingView().showView();
    }

}
