package Dao;

import Jframe.ManageUtl.EditInfoDialog;
import View.Volunteer;
import Jframe.VolunteerUtl.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
            // 当点击按钮时，关闭当前窗口
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button);
            frame.dispose();
            if ("first".equals(button.getName())) {
                new Volunteer();
            }
            if ("type".equals(button.getName())) {
                new Moments();
            }
            if ("act".equals(button.getName())) {
                new Info();
            }
            if ("form".equals(button.getName())) {
                new Apply();
            }
            if ("notic".equals(button.getName())) {
                new Notice();
            }
            if ("new".equals(button.getName())) {
                new SchoolNews();
            }
            if ("message".equals(button.getName())) {
                new Discussion();
            }
            if ("per".equals(button.getName())) {
                new Own();
            }
            if ("sin".equals(button.getName())) {
                new sign();
            }
            if ("first2".equals(button.getName())) {
                new SchoolNews();
            }


        } catch (HeadlessException ex) {
            ex.printStackTrace();
        }
    }

}