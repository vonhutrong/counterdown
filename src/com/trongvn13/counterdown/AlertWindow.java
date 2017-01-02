package com.trongvn13.counterdown;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class AlertWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    public AlertWindow(String message) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(598, 404);
        setType(Type.POPUP);
        setTitle("Message");
        setFont(new Font("Dialog", Font.PLAIN, 16));
        setAlwaysOnTop(true);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JLabel lblMessgae = new JLabel(message);
        lblMessgae.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblMessgae, BorderLayout.CENTER);
    }

}
