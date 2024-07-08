package Dao;

import Jframe.ManageUtl.*;
import View.Manage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenageEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
            // 当点击按钮时，关闭当前窗口
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button);
            frame.dispose();
            if ("zhu".equals(button.getName())) {
                new Manage();
            }
            if ("vol".equals(button.getName())) {
                new Volunteers();
            }
            if ("apply".equals(button.getName())) {
                new ActivityRegist();
            }
            if ("time".equals(button.getName())) {
                new Acttime();
            }
            if ("type".equals(button.getName())) {
                new Actsign();
            }
            if ("acts".equals(button.getName())) {
                new ActivityInfo();
            }
            if ("per".equals(button.getName())) {
                new Myself();
            }
            /*if ("my".equals(button.getName())) {
                new EditInfoDialog();
            }

             */
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }}