package com.trongvn13.counterdown.presenter;

import com.trongvn13.counterdown.view.AlertViewInterface;

public class AlertPresenter implements AlertPresenterInterface {
    private AlertViewInterface alertView = null;

    @Override
    public void showAlert(String message) {
        getAlertView().showAlert(message);
    }

    @Override
    public AlertViewInterface getAlertView() {
        return alertView;
    }

    @Override
    public void setAlertView(AlertViewInterface view) {
        alertView = view;
    }

}
