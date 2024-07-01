package Dao;

import Jframe.ManageUtl.Acttime;
import utils.Mysqld;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActtimeEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
            if ("search".equals(button.getName())) {
                //单条查找
                String num = Acttime.acttext.getText();
                boolean allt = Acttime.allt.isSelected();
                boolean one = Acttime.one.isSelected();
                if (!one&&!allt) {
                    Acttime.allt.setSelected(true);
                }
                String name = Acttime.nametext.getText();
                String nc = Acttime.nctext.getText();
                String time = Acttime.timetext.getText();
                String classs = Acttime.classstext.getText();
                String act = Acttime.acttext.getText();
                if (act.equals("")) {
                    if (num.equals("") && name.equals("") && nc.equals("") && time.equals("")) {
                        Mysqld.findAllTime();
                        //信息框是否有数据 查看所以数据
                        System.out.println("正在查找所有消息");
                    } else {
                        if (name.equals("")) {
                            name = ".*?";
                        }
                        if (nc.equals("")) {
                            nc = ".*?";
                        }
                        if (time.equals("")) {
                            time = ".*?";
                        }
                        if (classs.equals("")) {
                            classs = ".*?";
                        }
                        Mysqld.findConTime(classs, name, nc, time);
                    }
                } else if (!num.equals("")) {
                    //查找单条消息
                    Mysqld.findOneTime(num);
                }
            }
            if ("addt".equals(button.getName())) {
                Acttime.model.setNumRows(0);//将表格数据置为0
                String classs = Acttime.classstext.getText();
                boolean allt = Acttime.allt.isSelected();
                String name = Acttime.nametext.getText();
                String nc = Acttime.nctext.getText();
                String time = Acttime.timetext.getText();
                if (classs.equals("")) {
                    JOptionPane.showMessageDialog(null, "志愿者编号不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (allt == true) {
                    Acttime.allt.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (nc.equals("")) {
                    JOptionPane.showMessageDialog(null, "活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (time.equals("")) {
                    JOptionPane.showMessageDialog(null, "志愿时长不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    Mysqld.addTime(classs, name, nc, time);
                    String data[] = new String[4];
                    data[0] = classs;
                    data[1] = name;
                    data[2] = nc;
                    data[3] = time;
                    Acttime.model.addRow(data);
                }
            }
            if ("gai".equals(button.getName())) {
                //更改数据
                String num = Acttime.classstext.getText();
                boolean all = Acttime.allt.isSelected();
                if (!all) {
                    Acttime.one.setSelected(true);
                }
                String name = Acttime.nametext.getText();
                String nc = Acttime.nctext.getText();
                String time = Acttime.timetext.getText();
                String act = Acttime.acttext.getText();
                if (act.equals("")) {
                    JOptionPane.showMessageDialog(null, "条件活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (num.equals("")) {
                    JOptionPane.showMessageDialog(null, "志愿者编号不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (all == true) {
                    Acttime.allt.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (nc.equals("")) {
                    JOptionPane.showMessageDialog(null, "活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (time.equals("")) {
                    JOptionPane.showMessageDialog(null, "志愿时长不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                }
                Mysqld.changeTime(num, name, nc, time, act);
            }
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        }
    }
        public static ResultSet addAblet(ResultSet rt){
            String data[]=new String[4];
            try {
                while(rt.next()){
                    data[0] = rt.getString(1);
                    data[1] = rt.getString(2);
                    data[2] = rt.getString(3);
                    data[3] = rt.getString(4);
                    Acttime.model.addRow(data);
                }
            }catch (SQLException e1){

            }
            return rt;
        }
        public static void addOneAblet(ResultSet rt){
            String data[]=new String[4];
            try {
                while(rt.next()) {
                    data[0] = rt.getString(1);
                    data[1] = rt.getString(2);
                    data[2] = rt.getString(3);
                    data[3] = rt.getString(4);
                    Acttime.classstext.setText(data[0]);
                    Acttime.nametext.setText(data[1]);
                    Acttime.nctext.setText(data[2]);
                    Acttime.timetext.setText(data[3]);
                    Acttime.model.addRow(data);
                }
            }catch (SQLException e2){

            }
        }
}
