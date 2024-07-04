package Dao;

import Jframe.ManageUtl.*;
import View.Login;
import View.Manage;
import View.Volunteer;
import utils.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogiEvent implements ActionListener {
    JButton button;//定义一个按钮
    JMenuItem item;
    public String account;
    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();//强制转换类型
            if ("ok".equals(button.getName())) {
                // 获取用户输入的账号和密码
                String account = Login.accounttext.getText();
                String password = new String((Login.passwordtext.getPassword()));
                // 检查账号和密码是否为空
                if (account == null || account.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "账号不能为空", "登录信息", JOptionPane.WARNING_MESSAGE);
                }
                if (password == null || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "密码不能为空", "登录信息", JOptionPane.WARNING_MESSAGE);
                }
                // 调用数据库方法检查账号和密码
                String role = Mysqld.loginAccount(account, password);
                // 根据角色创建相应的界面
                if ("管理员".equals(role)) {
                    new Manage(); // 创建管理员界面
                } else if ("志愿者".equals(role)) {
                    new Volunteer(); // 创建志愿者界面
                }
            } else if (button.getName() == "change") {
                //向数据库更新信息
                Mysqld.updateAccount();
            } else if (button.getName() == "changeown") {
                String password = new String(ChangePassword.passwordtext.getPassword());
                Mysqld.changepassword(account, password);
                JOptionPane.showMessageDialog(null, "修改密码成功", "修改密码", JOptionPane.WARNING_MESSAGE);
            }
            if ("add".equals(button.getName())) {
                Volunteers.model.setNumRows(0);//将表格数据置为0
                String name = Volunteers.nametext.getText();
                boolean man = Volunteers.Men.isSelected();
                boolean woman = Volunteers.Women.isSelected();
                boolean allsex = Volunteers.allsex.isSelected();
                String sex;
                String age = Volunteers.agetext.getText();
                String year = Volunteers.yeartext.getText();
                String classs = Volunteers.classstext.getText();
                String home = Volunteers.hometext.getText();
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if ((man == false && woman == false) && allsex == true) {
                    Volunteers.Men.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if ((man == false && woman == false) && allsex == false) {
                    JOptionPane.showMessageDialog(null, "姓别不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (age.equals("")) {
                    JOptionPane.showMessageDialog(null, "年龄不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (year.equals("")) {
                    JOptionPane.showMessageDialog(null, "服务年限不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (classs.equals("")) {
                    JOptionPane.showMessageDialog(null, "志愿者编号不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (home.equals("")) {
                    JOptionPane.showMessageDialog(null, "住址不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (Volunteers.Men.isSelected() == true) {
                        sex = Volunteers.Men.getText();
                    } else {
                        sex = Volunteers.Women.getText();
                    }
                    Mysqld.addVolunteer(name, sex, age, year, classs, home);
                    String data[] = new String[6];
                    data[0] = name;
                    data[1] = sex;
                    data[2] = age;
                    data[3] = year;
                    data[4] = classs;
                    data[5] = home;
                    Volunteers.model.addRow(data);
                }
            }
            if ("del".equals(button.getName())) {
                //删除数据
                String number = Volunteers.numbeconditiontext.getText();
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null, "条件不能为空", "删除信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    Mysqld.delVolunteer(number);
                }
            }
            if ("gai".equals(button.getName())) {
                //更改数据
                String numberA = Volunteers.numbeconditiontext.getText();
                String name = Volunteers.nametext.getText();
                String sex;
                boolean man = Volunteers.Men.isSelected();
                boolean woman = Volunteers.Women.isSelected();
                boolean allsex = Volunteers.allsex.isSelected();
                String age = Volunteers.agetext.getText();
                String year = Volunteers.yeartext.getText();
                String classs = Volunteers.classstext.getText();
                String home = Volunteers.hometext.getText();
                if (numberA.equals("")) {
                    JOptionPane.showMessageDialog(null, "条件志愿者编号不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if ((man == false && woman == false) && allsex == true) {
                    Volunteers.Men.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if ((man == false && woman == false) && allsex == false) {
                    JOptionPane.showMessageDialog(null, "请选择性别", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (age.equals("")) {
                    JOptionPane.showMessageDialog(null, "年龄不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (year.equals("")) {
                    JOptionPane.showMessageDialog(null, "服务年限不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (classs.equals("")) {
                    JOptionPane.showMessageDialog(null, "志愿者编号不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (home.equals("")) {
                    JOptionPane.showMessageDialog(null, "住址不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (Volunteers.Men.isSelected() == true) {
                        sex = Volunteers.Men.getText();
                    } else {
                        sex = Volunteers.Women.getText();
                    }
                    Mysqld.changeVolunteer(name, sex, age, year, classs, home,numberA);
                }
            }
            if ("show".equals(button.getName())) {
                //单条查找
                String numberA = Volunteers.numbeconditiontext.getText();
                String name = Volunteers.nametext.getText();
                String sex = "";
                boolean man = Volunteers.Men.isSelected();
                boolean woman = Volunteers.Women.isSelected();
                boolean allsex = Volunteers.allsex.isSelected();
                if(!man&&!woman&&!allsex){
                    Volunteers.allsex.setSelected(true);
                }
                String age = Volunteers.agetext.getText();
                String year = Volunteers.yeartext.getText();
                String classs = Volunteers.classstext.getText();
                String home = Volunteers.hometext.getText();
                String number = Volunteers.numbeconditiontext.getText();
                if (Volunteers.Men.isSelected() == true) {
                    sex = Volunteers.Men.getText();
                } else {
                    sex = Volunteers.Women.getText();
                }
                if (number.equals("")) {
                    if (name.equals("") && allsex && age.equals("") && year.equals("") && classs.equals("") && home.equals("")) {
                        Mysqld.findAllVolunteer();
                        //信息框是否有数据 查看所以数据
                        System.out.println("正在查找所有消息");
                    } else {
                        if (name.equals("")) {
                            name = ".*?";
                        }
                        if (sex.equals("")) {
                            sex = ".*?";
                        }
                        if (age.equals("")) {
                            age = ".*?";
                        }
                        if (year.equals("")) {
                            year = ".*?";
                        }
                        if (classs.equals("")) {
                            classs = ".*?";
                        }
                        if (home.equals("")) {
                            home = ".*?";
                        }
                        Mysqld.findConVolunteer(name, sex, age, year, classs, home);
                    }

                } else if (!numberA.equals("")) {
                    //查找单条消息
                    Mysqld.findOneVolunteer(numberA);
                }
            }
            if ("reset".equals(button.getName())) {
                Volunteers.nametext.setText("");
                Volunteers.allsex.setSelected(true);
                Volunteers.agetext.setText("");
                Volunteers.yeartext.setText("");
                Volunteers.classstext.setText("");
                Volunteers.hometext.setText("");
            }
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
            if ("not".equals(button.getName())) {
                new Actsign();
            }
            if ("per".equals(button.getName())) {
                new Actsign();
            }
        }catch (Exception e1) {
            //报错他就是一个非按钮的监听
            try {
                item = (JMenuItem) e.getSource();
                if (item.getName() == "item1") {
                    //查看所有在线用户
                    Mysqld.onlineAccount();
                }
                if (item.getName() == "item2") {
                    //查看所有在线用户
                    Mysqld.AllAccount();
                }
                if (item.getName() == "item3") {
                    //
                    new UpdateAccount();
                }
                if (item.getName() == "item4") {
                    //
                    new ChangePassword();
                }
            } catch (Exception ex) {
                System.out.println("报错");
            }
        }
    }
    public static ResultSet addAble(ResultSet rs){
        String data[]=new String[6];
        try {
            while(rs.next()){
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                Volunteers.model.addRow(data);
            }
        }catch (SQLException e){

        }
        return rs;
    }
    public static void addOneAble(ResultSet rs){
        String data[]=new String[6];
        try {
                rs.next();
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                Volunteers.nametext.setText(data[0]);
                if(data[1].equals("男")){
                    Volunteers.Men.setSelected(true);
                }else if(data[1].equals("女")){
                    Volunteers.Women.setSelected(true);
                }
                Volunteers.agetext.setText(data[2]);
                Volunteers.yeartext.setText(data[3]);
                Volunteers.classstext.setText(data[4]);
                Volunteers.hometext.setText(data[5]);
                Volunteers.model.addRow(data);
        }catch (SQLException e){

        }
    }
}