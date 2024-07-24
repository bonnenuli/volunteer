package Dao;

import Jframe.ManageUtl.*;
import View.Login;
import View.Manage;
import View.Volunteer;
import utils.Mysqld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogiEvent implements ActionListener {
    JButton button;//定义一个按钮
    JMenuItem item;//菜单项成员变量
    public String account;//账号成员变量
    int loginAttempts = 0;//定义目前总计用户尝试次数
    int maxLoginAttempts = 3;//定义最大登录尝试次数常量
    public void actionPerformed(ActionEvent e) {// 获取事件源，并强制转换为JButton类型
        try {
            button = (JButton) e.getSource();//强制转换类型
            // 检查按钮的名称是否为"ok"
            if ("ok".equals(button.getName())) {
                // 检查登录尝试次数是否达到最大值
                if (loginAttempts >= maxLoginAttempts) {
                    // 显示错误消息并结束方法执行
                    JOptionPane.showMessageDialog(null, "登录尝试次数过多，请稍后再试", "登录信息", JOptionPane.ERROR_MESSAGE);
                    return; // 结束方法执行
                }
                // 获取用户输入的账号和密码
                String account = Login.accounttext.getText();
                String password = new String((Login.passwordtext.getPassword()));
                // 检查账号和密码是否为空
                if (account == null || account.trim().isEmpty()) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "账号不能为空", "登录信息", JOptionPane.WARNING_MESSAGE);
                }
                if (password == null || password.trim().isEmpty()) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "密码不能为空", "登录信息", JOptionPane.WARNING_MESSAGE);
                }
                // 调用数据库方法检查账号和密码
                String role = Mysqld.loginAccount(account, password);
                // 根据角色创建相应的界面
                if ("管理员".equals(role)) {
                    new Manage(); // 创建管理员界面
                } else if ("志愿者".equals(role)) {
                    new Volunteer(); // 创建志愿者界面
                } else {
                    // 登录失败，增加尝试次数
                    loginAttempts++;
                    // 显示剩余尝试次数
                    int remainingAttempts = maxLoginAttempts - loginAttempts;
                    JOptionPane.showMessageDialog(null, "账号或密码错误，剩余尝试次数：" + remainingAttempts, "登录信息", JOptionPane.WARNING_MESSAGE);
                    // 检查是否达到了最大尝试次数
                    if (loginAttempts >= maxLoginAttempts) {
                        JOptionPane.showMessageDialog(null, "登录尝试次数过多，请稍后再试", "登录信息", JOptionPane.ERROR_MESSAGE);
                    }
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
                // 将表格数据置为0
                Volunteers.model.setNumRows(0);
                // 获取用户输入的姓名
                String name = Volunteers.nametext.getText();
                // 获取性别选择的布尔值
                boolean man = Volunteers.Men.isSelected();
                boolean woman = Volunteers.Women.isSelected();
                // 获取是否选择全部性别的布尔值
                boolean allsex = Volunteers.allsex.isSelected();
                // 定义性别字符串变量
                String sex;
                // 获取用户输入的年龄
                String age = Volunteers.agetext.getText();
                // 获取用户输入的服务年限
                String year = Volunteers.yeartext.getText();
                // 获取用户输入的志愿者编号
                String classs = Volunteers.classstext.getText();
                // 获取用户输入的住址
                String home = Volunteers.hometext.getText();
                // 检查姓名是否为空
                if (name.equals("")) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "姓名不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if ((man == false && woman == false) && allsex == true) {
                    // 显示警告消息
                    Volunteers.Men.setSelected(true);
                    JOptionPane.showMessageDialog(null, "全部在添加信息时不能被选中", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if ((man == false && woman == false) && allsex == false) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "姓别不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (age.equals("")) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "年龄不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (year.equals("")) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "服务年限不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (classs.equals("")) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "志愿者编号不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else if (home.equals("")) {
                    // 显示警告消息
                    JOptionPane.showMessageDialog(null, "住址不能为空", "编辑信息", JOptionPane.WARNING_MESSAGE);
                } else {
                    // 获取性别
                    if (Volunteers.Men.isSelected() == true) {
                        sex = Volunteers.Men.getText();
                    } else {
                        sex = Volunteers.Women.getText();
                    }
                    // 调用数据库方法添加志愿者信息
                    Mysqld.addVolunteer(name, sex, age, year, classs, home);
                    // 创建一个包含6个元素的String数组
                    String data[] = new String[6];
                    // 填充数组，包含姓名、性别、年龄、服务年限、志愿者编号和住址
                    data[0] = name;
                    data[1] = sex;
                    data[2] = age;
                    data[3] = year;
                    data[4] = classs;
                    data[5] = home;
                    // 将数组作为新的一行添加到表格模型中
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
            if ("acts".equals(button.getName())) {
                new ActivityInfo();
            }
            if ("not".equals(button.getName())) {

            }
            if ("per".equals(button.getName())) {
                new Myself();
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
        // 定义一个字符串数组data，长度为6，用于存储从结果集ResultSet中获取的数据。
        String data[]=new String[6];

        try {
            // 使用while循环遍历ResultSet中的所有行。
            while(rs.next()){
                // 从ResultSet的当前行中获取各个列的值，并存储到data数组中。
                // 列索引是从1开始的，不是从0开始。
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);

                // 将data数组作为新的一行添加到Volunteers类的表格模型中。
                // 在表格中添加一行新的数据。
                Volunteers.model.addRow(data);
            }
        }catch (SQLException e){
            // 捕获并处理可能发生的SQLException异常。

        }
        // 返回传入的ResultSet对象。
        return rs;
    }

    public static void addOneAble(ResultSet rs){
        // 定义一个字符串数组data，长度为6，用于存储从结果集ResultSet中获取的数据。
        String data[]=new String[6];

        try {
            // 调用rs.next()方法，将ResultSet的光标移动到下一行，如果存在的话。
            // 如果没有下一行，rs.next()将返回false。
            rs.next();

            // 从ResultSet中获取当前行的各个列的值，并将其存储到data数组中。
            data[0] = rs.getString(1); // 获取第1列的字符串是姓名。
            data[1] = rs.getString(2); // 性别。
            data[2] = rs.getString(3);
            data[3] = rs.getString(4);
            data[4] = rs.getString(5);
            data[5] = rs.getString(6);

            // 设置Volunteers类中的各个文本框和单选按钮的值，以显示获取的数据。
            Volunteers.nametext.setText(data[0]); // 设置姓名文本框的内容。
            if(data[1].equals("男")){
                Volunteers.Men.setSelected(true); // 如果性别为男，则选中男性单选按钮。
            }else if(data[1].equals("女")){
                Volunteers.Women.setSelected(true); // 如果性别为女，则选中女性单选按钮。
            }
            Volunteers.agetext.setText(data[2]); // 设置年龄文本框的内容。
            Volunteers.yeartext.setText(data[3]); // 设置年份文本框的内容。
            Volunteers.classstext.setText(data[4]); // 设置班级文本框的内容。
            Volunteers.hometext.setText(data[5]); // 设置家庭住址文本框的内容。

            // 将data数组作为新的一行添加到Volunteers类的表格模型中。
            // 这样会在表格中添加一行新的数据。
            Volunteers.model.addRow(data);
        }catch (SQLException e){
            // 捕获并处理可能发生的SQLException异常。
        }
    }

}