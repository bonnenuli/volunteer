package Dao;

import Jframe.VolunteerUtl.Info;
import utils.Mysqld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
    if ("sea".equals(button.getName())) {
        //单条查找
        String num = Info.acttext.getText();
        boolean allt = Info.allt.isSelected();
        boolean one = Info.one.isSelected();
        if (!one&&!allt) {
            Info.allt.setSelected(true);
        }
        String nc = Info.nctext.getText();
        String apply = Info.applytext.getText();
        String stime = Info.stimetext.getText();
        String demand = Info.demandtext.getText();
        String detail = Info.detailtext.getText();
        if (num.equals("")) {
            if (nc.equals("") && stime.equals("") && apply.equals("") && demand.equals("")&&detail.equals("")) {
                Mysqld.findAllinfo();
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
                if (detail.equals("")) {
                    detail = ".*?";
                }
                Mysqld.findConinfo(nc,stime,apply,demand,detail);
            }
        } else if (!num.equals("")) {
            //查找单条消息
            Mysqld.findOneinfo(num);
        }
    }} catch (HeadlessException ex) {
            ex.printStackTrace();
        }
    }
    public static ResultSet addAble(ResultSet rt){
        String data[]=new String[5];
        try {
            while(rt.next()){
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                data[2] = rt.getString(3);
                data[3] = rt.getString(4);
                data[4] = rt.getString(5);
                Info.model.addRow(data);
            }
        }catch (SQLException e1){

        }
        return rt;
    }
    public static void addOneAble(ResultSet rt){
        String data[]=new String[5];
        try {
            while(rt.next()) {
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                data[2] = rt.getString(3);
                data[3] = rt.getString(4);
                data[4] = rt.getString(5);
                Info.nctext.setText(data[0]);
                Info.stimetext.setText(data[1]);
                Info.applytext.setText(data[2]);
                Info.demandtext.setText(data[3]);
                Info.detailtext.setText(data[4]);
                Info.model.addRow(data);
            }
        }catch (SQLException e2){

        }
    }
}
