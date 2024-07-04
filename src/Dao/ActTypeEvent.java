package Dao;

import Jframe.ManageUtl.Acttime;
import Jframe.ManageUtl.Actsign;
import utils.Mysqld;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActTypeEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
            if ("search".equals(button.getName())) {
                //单条查找
                String num = Actsign.acttext.getText();
                boolean allt = Actsign.allt.isSelected();
                boolean one = Actsign.one.isSelected();
                if (!one&&!allt) {
                    Actsign.allt.setSelected(true);
                }
                String nc = Actsign.nctext.getText();
                String type = Actsign.nctypetext.getText();
                String act = Actsign.acttext.getText();
                if (act.equals("")) {
                    if ( nc.equals("") && type.equals("")) {
                        Mysqld.findAllType();
                        //信息框是否有数据 查看所以数据
                        System.out.println("正在查找所有消息");
                    } else {
                        if (nc.equals("")) {
                            nc = ".*?";
                        }
                        if (type.equals("")) {
                            type = ".*?";
                        }
                        Mysqld.findConType( nc, type);
                    }
                } else if (!num.equals("")) {
                    //查找单条消息
                    Mysqld.findOneType(num);
                }
            }
            if ("add".equals(button.getName())) {
                Actsign.model.setNumRows(0);//将表格数据置为0
                boolean allt = Actsign.allt.isSelected();
                String nc = Actsign.nctext.getText();
                String type = Actsign.nctypetext.getText();
                if (nc.equals("")) {
                    JOptionPane.showMessageDialog(null, "活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (allt == true) {
                    Actsign.allt.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (type.equals("")) {
                    JOptionPane.showMessageDialog(null, "活动类型不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    Mysqld.addType( nc, type);
                    String data[] = new String[2];
                    data[0] = nc;
                    data[1] = type;
                    Actsign.model.addRow(data);
                }
            }

            if ("del".equals(button.getName())) {
                // 获取用户输入的编号列表
                String numbers = Actsign.acttext.getText().trim();
                // 检查是否有输入
                if (numbers.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "条件不能为空", "删除信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    // 将输入的字符串分割成编号数组
                    String[] numberArray = numbers.split(",");
                    // 调用批量删除方法
                    Mysqld.delType(numberArray);
                    JOptionPane.showMessageDialog(null, "删除成功", "删除信息", JOptionPane.WARNING_MESSAGE);
                }
            }

            if ("gai".equals(button.getName())) {
                //更改数据
                boolean allt = Actsign.allt.isSelected();
                String nc = Actsign.nctext.getText();
                String type = Actsign.nctypetext.getText();
                String act = Actsign.acttext.getText();
                if (!allt) {
                    Acttime.one.setSelected(true);
                }
                if (act.equals("")) {
                    JOptionPane.showMessageDialog(null, "条件活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (nc.equals("")) {
                    JOptionPane.showMessageDialog(null, "活动名称不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (allt == true) {
                    Actsign.allt.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                }  else if (type.equals("")) {
                    JOptionPane.showMessageDialog(null, "活动类型不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                }
                Mysqld.changeType(nc, type, act);
            }
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        }
    }
    public static ResultSet addAble(ResultSet rt){
        String data[]=new String[2];
        try {
            while(rt.next()){
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                Actsign.model.addRow(data);
            }
        }catch (SQLException e1){

        }
        return rt;
    }
    public static void addOneAble(ResultSet rt){
        String data[]=new String[2];
        try {
            while(rt.next()) {
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                Actsign.nctext.setText(data[0]);
                Actsign.nctypetext.setText(data[1]);
                Actsign.model.addRow(data);
            }
        }catch (SQLException e2){

        }
    }
}
