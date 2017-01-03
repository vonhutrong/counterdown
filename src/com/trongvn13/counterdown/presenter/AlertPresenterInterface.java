package com.trongvn13.counterdown.presenter;

import com.trongvn13.counterdown.view.AlertViewInterface;

public interface AlertPresenterInterface {

    void showAlert(String message);
    AlertViewInterface getAlertView();
    void setAlertView(AlertViewInterface view);
}
