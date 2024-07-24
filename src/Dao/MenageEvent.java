package Dao;

import Jframe.ManageUtl.*;
import View.Manage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenageEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {//按钮监听器
        try {
            button = (JButton) e.getSource();//强制转换类型
            // 当点击按钮时，关闭当前窗口

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button);
            frame.dispose();// 关闭当前窗口
            //if语句检查按钮的name属性是否等于字符串"zhu"。
            //如果是，它将创建一个Manage类的实例。这通常用于根据按钮的不同标识执行不同的操作。

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
            if ("acts".equals(button.getName())) {
                new ActivityInfo();
            }
            if ("per".equals(button.getName())) {
                new Myself();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }}