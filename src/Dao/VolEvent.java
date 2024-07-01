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
                new Types();
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
                new Dimension();
            }
            if ("per".equals(button.getName())) {
                new Own();
            }

            if ("first2".equals(button.getName())) {
                new SchoolNews();
            }
            if ("xw".equals(button.getName())) {
                new SchoolNews();
            }
            if ("baom".equals(button.getName())) {
                // 弹出提示框
                JOptionPane.showMessageDialog(null, "报名成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            if ("my".equals(button.getName())) {
                new EditInfoDialog();
            }
           /*
          if ("shou".equals(button.getName())) {
                //单条查找
                String num = Time.acttext.getText();
                boolean allt = Info.allt.isSelected();
                boolean one = Info.one.isSelected();
                if (!one&&!allt) {
                    Info.allt.setSelected(true);
                }
                String nc = Info.nctext.getText();
                String rtime = Info.rtimetext.getText();
                String apply = Info.applytext.getText();
                String stime = Info.stimetext.getText();
                String demand = Info.demandtext.getText();
                String detail = Info.detailtext.getText();
                if (num.equals("")) {
                    if (nc.equals("") && stime.equals("") && apply.equals("") && demand.equals("")&&rtime.equals("")&&detail.equals("")) {
                        Mysqld.findAllApply();
                        //信息框是否有数据 查看所以数据
                        System.out.println("正在查找所有消息");
                    } else {
                        if (nc.equals("")) {
                            nc = ".*?";
                        }
                        if (stime.equals("")) {
                            stime = ".*?";
                        }
                        if (apply.equals("")) {
                            apply = ".*?";
                        }
                        if (demand.equals("")) {
                            demand = ".*?";
                        }
                        if (rtime.equals("")) {
                            rtime = ".*?";
                        }
                        if (detail.equals("")) {
                            detail = ".*?";
                        }
                        Mysqld.findConApply(nc,stime,apply,demand,rtime,detail);
                    }
                } else if (!num.equals("")) {
                    //查找单条消息
                    Mysqld.findOneApply(num);
                }
            }
          */
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        }
    }

}