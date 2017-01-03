package com.trongvn13.counterdown.view;

import com.trongvn13.counterdown.presenter.AlertPresenterInterface;

public interface AlertViewInterface {

    void showAlert(String message);

    void setPresenter(AlertPresenterInterface alertPresenter);
    
}
