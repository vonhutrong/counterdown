package com.trongvn13.counterdown.view;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public abstract class MinimizeableView extends JFrame {

    private static final long serialVersionUID = 1L;

    private SystemTray tray = null;
    private TrayIcon trayIcon = null;

    public MinimizeableView() {
        tray = SystemTray.getSystemTray();
        addWindowStateListener((e) -> onWindowStateChanged(e));
    }

    private void onWindowStateChanged(WindowEvent e) {
        try {
            switch (e.getNewState()) {
            case ICONIFIED: // on minimized
                tray.add(trayIcon);
                setVisible(false);
                break;
            case 7: // mini from max
                tray.add(trayIcon);
                setVisible(false);
                break;
            case MAXIMIZED_BOTH: // on maximized
                tray.remove(trayIcon);
                setVisible(true);
                break;
            case NORMAL: // on restored
                tray.remove(trayIcon);
                setVisible(true);
                break;
            }
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }

    public void setTrayIcon(Image image, String tooltip, PopupMenu popup) {
        trayIcon = new TrayIcon(image, tooltip, popup);
        trayIcon.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                int state = getExtendedState();
                state &= ~Frame.ICONIFIED;
                setExtendedState(state);
            }
        });
    }
}
