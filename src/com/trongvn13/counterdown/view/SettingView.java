package com.trongvn13.counterdown.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.trongvn13.counterdown.presenter.SettingPresenterInterface;
import com.trongvn13.counterdown.util.ResourceManager;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class SettingView extends MinimizeableView implements SettingViewInterface {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private SettingPresenterInterface settingPresenter = null;

    public SettingView() {
        setResizable(false);
        setTitle("Counterdown");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(359, 185);
        getContentPane().setLayout(null);

        JLabel lblTime = new JLabel("Time (second):");
        lblTime.setBounds(20, 11, 106, 14);
        getContentPane().add(lblTime);

        textField = new JTextField();
        textField.setBounds(171, 11, 161, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblMessage = new JLabel("Message:");
        lblMessage.setBounds(20, 36, 106, 14);
        getContentPane().add(lblMessage);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(170, 39, 162, 65);
        getContentPane().add(textArea);

        JButton btnStart = new JButton("Start");

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String time = textField.getText();
                String message = textArea.getText();
                settingPresenter.startCounter(time, message);
            }
        });
        btnStart.setBounds(132, 123, 89, 23);
        getContentPane().add(btnStart);
        
        Image image = ResourceManager.getInstance().getImageFromPath("images/icon.png");
        setTrayIcon(image , "Counterdown", null);
    }

    @Override
    public SettingPresenterInterface getPresenter() {
        return settingPresenter;
    }

    @Override
    public void setPresenter(SettingPresenterInterface presenter) {
        this.settingPresenter = presenter;
    }
    
    public void showView() {
        setVisible(true);
    }
}
