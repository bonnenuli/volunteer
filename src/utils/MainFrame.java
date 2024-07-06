package utils;

import View.VolunteerSign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

    public class MainFrame extends JFrame {

        private Component panel;

        public MainFrame()
        {
            Session.init();
            addListener();
            setSize(640*2,480*2);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            Toolkit tool =Toolkit.getDefaultToolkit();
            Dimension d = tool.getScreenSize();
            setLocation((d.width - getWidth())/2,(d.height-getHeight())/2);
        }

        private void addListener()
        {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int closeCode = JOptionPane.showConfirmDialog(MainFrame.this, "是否退出程序？", "提示！",
                            JOptionPane.YES_NO_OPTION);
                    if (closeCode == JOptionPane.YES_OPTION) {
                        Session.dispose();
                        System.exit(0);
                    }
                }
            });
        }

        public void setPanel(JPanel panel)
        {
            Container c = getContentPane();
            c.removeAll();
            c.add(panel);
            c.validate();
        }
    }
