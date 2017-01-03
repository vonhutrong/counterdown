package com.trongvn13.counterdown.view;

import com.trongvn13.counterdown.presenter.SettingPresenterInterface;

public interface SettingViewInterface {
    SettingPresenterInterface getPresenter();
    void setPresenter(SettingPresenterInterface presenter);
    void showView();
}
