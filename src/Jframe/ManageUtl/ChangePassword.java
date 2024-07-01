package Jframe.ManageUtl;

import Dao.LogiEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame {
    //定义一个布局
    FlowLayout flowlayout;
    //窗口变量
    final int WIDTH = 400;//设置顶层框架的宽度
    final int HEIGHT = 100;//设置顶层框架高度
    JLabel password;
    public static JPasswordField passwordtext;
    JButton changeown;
    // 定义一个面板
    JPanel contentPanel;
    //创建一个监听
    ActionListener listener_1;
    public ChangePassword() {
        init();
        setVisible(true);//设置当前窗口是否显示
        setResizable(false);//设置窗口不可以调节大小
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置默认关闭方式
        setLocationRelativeTo(null); // 设置窗口居中
        validate();//让组件生效
    }

    void init() {
        //定义一个布局
        flowlayout = new FlowLayout(FlowLayout.CENTER);//居中对齐
        // 设置内容面板
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(0, 0, WIDTH, HEIGHT);
        //设置布局为空
        this.setLayout(flowlayout);
        // 设置窗口标题
        setTitle("更改密码");

        password = new JLabel("密码");
        passwordtext = new JPasswordField(15);
        changeown = new JButton("修改密码");

        listener_1 = new LogiEvent();
        changeown.addActionListener(listener_1);
        changeown.setName("changeown");
        this.add(password);
        this.add(passwordtext);
        this.add(changeown);
    }

}
