package Dao;

import utils.Mysqld;
import View.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountEvents implements ActionListener {
    JTextField alluse;
    JButton alljubtton;
    Statement sql;
    ResultSet rs;

    public void actionPerformed(ActionEvent e) {

        try {
            alluse = (JTextField) e.getSource();//则证明他是按钮
            if (alluse != null) {
                allUee();
            }
        } catch (Exception e1) {
            alljubtton = (JButton) e.getSource();
            if (alljubtton.getName() == "reg") {
                Jbtton();
            }
        }
    }

    void allUee() {
        if (alluse.getName() == "nametext") {
            Register.accounttext.requestFocus();
        } else if (alluse.getName() == "accounttext") {
            Register.passwordtext.requestFocus();
        } else if (alluse.getName() == "passwordtext") {
            Register.okpasswordtext.requestFocus();
        } else if (alluse.getName() == "okpasswordtext") {
            Register.reg.requestFocus();
        }
    }
    void Jbtton(){
        //判断确认密码和密码框内的内容是否一样
        //判断姓名不能为空
        //账号不能为空
        //确认密码不能为空
        //密码不能为空
        boolean namet = Register.nametext.getText().equals("");
        boolean accountt = Register.nametext.getText().equals("");
        //获取密码
        char[] str = Register.passwordtext.getPassword();
        String passwordtext = new String(str);
        boolean passwordt = passwordtext.equals("");

        str = Register.okpasswordtext.getPassword();
        String okpasswordtext = new String(str);
        boolean okpasswordt = okpasswordtext.equals("");

        if(namet==true){
            JOptionPane.showMessageDialog(null,"姓名不能为空","注册信息",JOptionPane.WARNING_MESSAGE);
        }else if(accountt==true){
            JOptionPane.showMessageDialog(null,"账号不能为空","注册信息",JOptionPane.WARNING_MESSAGE);
        }else if(passwordt==true){
            JOptionPane.showMessageDialog(null,"密码不能为空","注册信息",JOptionPane.WARNING_MESSAGE);
        }else if(okpasswordt==true){
            JOptionPane.showMessageDialog(null,"确认密码不能为空","注册信息",JOptionPane.WARNING_MESSAGE);
        }else if(passwordtext.equals(okpasswordtext)==false){
            //如果确认密码一样
            JOptionPane.showMessageDialog(null,"密码输入不一致","注册信息",JOptionPane.WARNING_MESSAGE);
        }else {
            //姓名文本
            String name = Register.nametext.getText();
            //账号文本
            String account = Register.accounttext.getText();
            //密码文本
            String password = passwordtext;
            java.sql.Connection con = Mysqld.con;
            PreparedStatement preSql;
            String Uri ="insert into user values(?,?,?,?,?)";
            try {
                preSql = con.prepareStatement(Uri);
                preSql.setString(1,name);
                preSql.setString(2,account);
                preSql.setString(3,password);
                preSql.setString(4,"志愿者");
                preSql.setString(5,"1");
                int login = preSql.executeUpdate();
                JOptionPane.showMessageDialog(null,"注册成功","注册信息",JOptionPane.WARNING_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"当前账号已经存在","注册信息",JOptionPane.WARNING_MESSAGE);
            }

        }

    }
}

