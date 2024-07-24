package Dao;

import Jframe.ManageUtl.ActivityInfo;
import Jframe.ManageUtl.Acttime;
import utils.Mysqld;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActInofEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
    try {
        button = (JButton) e.getSource();//强制转换类型
        if ("searchi".equals(button.getName())) {
            //单条查找
            String num = ActivityInfo.activitytext.getText();
            boolean allt = ActivityInfo.allt.isSelected();
            boolean one = ActivityInfo.one.isSelected();
            if (!one&&!allt) {
                ActivityInfo.allt.setSelected(true);
            }
            String nc = ActivityInfo.nctext.getText();
            String rtime = ActivityInfo.rtimetext.getText();
            String apply = ActivityInfo.applytext.getText();
            String stime = ActivityInfo.stimetext.getText();
            String demand = ActivityInfo.demandtext.getText();
            String detail = ActivityInfo.detailtext.getText();
            if (num.equals("")) {
                if (nc.equals("") && stime.equals("") && apply.equals("") && demand.equals("")&&rtime.equals("")&&detail.equals("")) {
                    Mysqld.findAllActinfo();
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
                    Mysqld.findConActinfo(nc,stime,apply,demand,rtime,detail);
                }
            } else if (!num.equals("")) {
                //查找单条消息
                Mysqld.findOneActinfo(num);
            }
        }


        //活动报名的增删，报名信息的导出
        if ("addi".equals(button.getName())) {
            ActivityInfo.model.setNumRows(0);//将表格数据置为0
            boolean allt = ActivityInfo.allt.isSelected();
            String nc = ActivityInfo.nctext.getText();
            String rtime = ActivityInfo.rtimetext.getText();
            String apply = ActivityInfo.applytext.getText();
            String stime = ActivityInfo.stimetext.getText();
            String demand = ActivityInfo.demandtext.getText();
            String detail = ActivityInfo.detailtext.getText();
            if (apply.equals("")) {
                JOptionPane.showMessageDialog(null, "报名人数不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (allt == true) {
                Acttime.allt.setSelected(true);
                JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (rtime.equals("")) {
                JOptionPane.showMessageDialog(null, "发布时间不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (nc.equals("")) {
                JOptionPane.showMessageDialog(null, "活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (stime.equals("")) {
                JOptionPane.showMessageDialog(null, "开始时间不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            }
            else if (demand.equals("")) {
                JOptionPane.showMessageDialog(null, "需求人数不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            }
            else if (detail.equals("")) {
                JOptionPane.showMessageDialog(null, "活动介绍不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            }else {
                Mysqld.addActinfo(nc,stime,apply,demand,rtime,detail);
                String data[] = new String[6];
                data[0] = nc;
                data[1] = stime;
                data[2] = apply;
                data[3] = demand;
                data[4] = rtime;
                data[5] = detail;
                ActivityInfo.model.addRow(data);
            }
        }
        if ("deli".equals(button.getName())) {
            //删除数据
            String nc = ActivityInfo.activitytext.getText();
            if (nc.equals("")) {
                JOptionPane.showMessageDialog(null, "条件不能为空", "删除信息", JOptionPane.WARNING_MESSAGE);
            } else {
                Mysqld.delActinfo(nc);
            }
        }
        if ("gaii".equals(button.getName())) {
            //更改数据
            String num = ActivityInfo.activitytext.getText();
            boolean allt = ActivityInfo.allt.isSelected();
            String nc = ActivityInfo.nctext.getText();
            String rtime = ActivityInfo.rtimetext.getText();
            String apply = ActivityInfo.applytext.getText();
            String stime = ActivityInfo.stimetext.getText();
            String demand = ActivityInfo.demandtext.getText();
            String detail = ActivityInfo.detailtext.getText();
            if (!allt) {
                ActivityInfo.one.setSelected(true);
            }
            if (num.equals("")) {
                JOptionPane.showMessageDialog(null, "条件活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (apply.equals("")) {
                JOptionPane.showMessageDialog(null, "报名人数不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (allt == true) {
                Acttime.allt.setSelected(true);
                JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (rtime.equals("")) {
                JOptionPane.showMessageDialog(null, "发布时间不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (nc.equals("")) {
                JOptionPane.showMessageDialog(null, "活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            } else if (stime.equals("")) {
                JOptionPane.showMessageDialog(null, "开始时间不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            }
            else if (demand.equals("")) {
                JOptionPane.showMessageDialog(null, "需求人数不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            }
            else if (detail.equals("")) {
                JOptionPane.showMessageDialog(null, "活动介绍不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
            }

            Mysqld.changeActinfo(nc,stime,apply,demand,rtime,detail,num);
        }
    } catch (HeadlessException ex) {
        ex.printStackTrace();
    }
}
    public static ResultSet addAblei(ResultSet rt){
        String data[]=new String[6];
        try {
            while(rt.next()){
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                data[2] = rt.getString(3);
                data[3] = rt.getString(4);
                data[4] = rt.getString(5);
                data[5] = rt.getString(6);
                ActivityInfo.model.addRow(data);
            }
        }catch (SQLException e1){

        }
        return rt;
    }
    public static void addOneAblei(ResultSet rt){
        String data[]=new String[6];
        try {
            while(rt.next()) {
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                data[2] = rt.getString(3);
                data[3] = rt.getString(4);
                data[4] = rt.getString(5);
                data[5] = rt.getString(6);
                ActivityInfo.nctext.setText(data[0]);
                ActivityInfo.stimetext.setText(data[1]);
                ActivityInfo.applytext.setText(data[2]);
                ActivityInfo.demandtext.setText(data[3]);
                ActivityInfo.rtimetext.setText(data[3]);
                ActivityInfo.detailtext.setText(data[3]);
                ActivityInfo.model.addRow(data);
            }
        }catch (SQLException e2){

        }
    }
}


