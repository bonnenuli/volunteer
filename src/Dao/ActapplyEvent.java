package Dao;

import Jframe.ManageUtl.ActivityRegist;
import utils.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActapplyEvent implements ActionListener {
    JButton button;//定义一个按钮
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
            if ("dapply".equals(button.getName())) {
                // 获取用户输入的编号列表
                String numbers = ActivityRegist.activitytext.getText().trim();

                // 检查是否有输入
                if (numbers.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "条件不能为空", "删除信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    // 将输入的字符串分割成编号数组
                    String[] numberArray = numbers.split(",");
                    // 调用批量删除方法
                    Mysqld.delApply(numberArray);
                    JOptionPane.showMessageDialog(null, "删除成功", "删除信息", JOptionPane.WARNING_MESSAGE);
                }
            }

            if ("sapply".equals(button.getName())) {
                //单条查找
                String pre = ActivityRegist.peotext.getText();
                String nc = ActivityRegist.nctext.getText();
                boolean one = ActivityRegist.one.isSelected();
                boolean all = ActivityRegist.allt.isSelected();
                if(!one&&!all){
                    ActivityRegist.allt.setSelected(true);
                }
                String applyper = ActivityRegist.applypertext.getText();
                String apply = ActivityRegist.applytext.getText();
                String time = ActivityRegist.timetext.getText();
                String state = ActivityRegist.statetext.getText();
                if (pre.equals("")) {
                    if (nc.equals("") && applyper.equals("") && apply.equals("") && time.equals("") && state.equals("")) {
                        Mysqld.findAllApply();
                        //信息框是否有数据 查看所以数据
                        System.out.println("正在查找所有消息");
                    } else {
                        if (nc.equals("")) {
                            nc = ".*?";
                        }
                        if (applyper.equals("")) {
                            applyper = ".*?";
                        }
                        if (apply.equals("")) {
                            apply = ".*?";
                        }
                        if (time.equals("")) {
                            time = ".*?";
                        }
                        if (state.equals("")) {
                            state = ".*?";
                        }
                        Mysqld.findConApply(nc,applyper,apply,time,state);
                    }
                } else if (!pre.equals("")) {
                    //查找单条消息
                    Mysqld.findOneApply(pre);
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static ResultSet addAble(ResultSet rt){
        String data[]=new String[6];
        try {
            while(rt.next()){
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                data[2] = rt.getString(3);
                data[3] = rt.getString(4);
                data[4] = rt.getString(5);
                ActivityRegist.model.addRow(data);
            }
        }catch (SQLException e1){

        }
        return rt;
    }
    public static void addOneAble(ResultSet rt){
        String data[]=new String[6];
        try {
            while(rt.next()) {
                data[0] = rt.getString(1);
                data[1] = rt.getString(2);
                data[2] = rt.getString(3);
                data[3] = rt.getString(4);
                data[4] = rt.getString(5);
                ActivityRegist.nctext.setText(data[0]);
                ActivityRegist.applypertext.setText(data[1]);
                ActivityRegist.applytext.setText(data[2]);
                ActivityRegist.timetext.setText(data[3]);
                ActivityRegist.statetext.setText(data[4]);
                ActivityRegist.model.addRow(data);
            }
        }catch (SQLException e2){

        }
    }
}
