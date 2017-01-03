package com.trongvn13.counterdown.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import com.trongvn13.counterdown.presenter.AlertPresenterInterface;

import java.awt.Font;

public class AlertView extends JFrame implements AlertViewInterface {
    private static final long serialVersionUID = 1L;
    private JLabel lblMessgae = null;
    private AlertPresenterInterface alertPresenter = null;

    public AlertView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(598, 404);
        setType(Type.POPUP);
        setTitle("Message");
        setFont(new Font("Dialog", Font.PLAIN, 16));
        setAlwaysOnTop(true);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        lblMessgae = new JLabel("");
        lblMessgae.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblMessgae, BorderLayout.CENTER);
    }

    @Override
    public void showAlert(String message) {
        lblMessgae.setText(message);
        setVisible(true);
    }

    @Override
    public void setPresenter(AlertPresenterInterface alertPresenter) {
        this.alertPresenter  = alertPresenter;
    }

}
