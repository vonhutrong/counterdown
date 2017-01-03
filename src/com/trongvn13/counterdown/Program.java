package com.trongvn13.counterdown;

import com.trongvn13.counterdown.presenter.AlertPresenter;
import com.trongvn13.counterdown.presenter.AlertPresenterInterface;
import com.trongvn13.counterdown.presenter.SettingPresenter;
import com.trongvn13.counterdown.presenter.SettingPresenterInterface;
import com.trongvn13.counterdown.view.AlertView;
import com.trongvn13.counterdown.view.AlertViewInterface;
import com.trongvn13.counterdown.view.SettingView;
import com.trongvn13.counterdown.view.SettingViewInterface;

public class Program {

    public static void main(String[] args) {

        SettingPresenterInterface settingPresenter = new SettingPresenter();
        SettingViewInterface settingView = new SettingView();
        AlertPresenterInterface alertPresenter = new AlertPresenter();
        AlertViewInterface alertView = new AlertView();
        
        settingPresenter.setView(settingView);
        settingPresenter.setAlertPresenter(alertPresenter);
        
        settingView.setPresenter(settingPresenter);
        alertPresenter.setAlertView(alertView);
        alertView.setPresenter(alertPresenter);
        
        settingPresenter.showView();
    }

}
