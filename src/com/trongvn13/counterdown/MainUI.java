package com.trongvn13.counterdown;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;

    public MainUI() {
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
                String stringTime = textField.getText();
                String message = textArea.getText();

                long time = Long.parseLong(stringTime);

                Counter counter = new Counter(time);
                counter.addListener(new CounterListener() {
                    @Override
                    public void onTimed() {
                        new AlertWindow(message).setVisible(true);
                    }
                });
                counter.start();
            }
        });
        btnStart.setBounds(132, 123, 89, 23);
        getContentPane().add(btnStart);
    }

    public static void main(String[] args) {
        new MainUI().setVisible(true);
    }
}
