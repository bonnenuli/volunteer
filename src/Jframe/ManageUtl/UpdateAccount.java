package Jframe.ManageUtl;

import Dao.LogiEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpdateAccount extends JFrame {
    //定义一个布局
    FlowLayout flowlayout;
    // 定义一个面板
    JPanel contentPanel;
    //窗口变量
    final int WIDTH = 400;//设置顶层框架的宽度
    final int HEIGHT = 350;//设置顶层框架高度
    JLabel name;
    JLabel password;
    public static JTextField nametext;
    public static JPasswordField passwordtext;
    JLabel account;
    public static JTextField accounttext;
    JButton change;
    //创建一个监听
    ActionListener listener_1;

    public UpdateAccount() {
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
        setTitle("校园志愿者增加界面");
        name = new JLabel("姓名");
        password = new JLabel("密码");
        account = new JLabel("账号");
        nametext = new JTextField(26);
        passwordtext = new JPasswordField(26);
        accounttext = new JTextField(26);
        change = new JButton("更改志愿者信息");
        change.setName("change");
        listener_1 = new LogiEvent();
        change.addActionListener(listener_1);

        this.add(account);
        this.add(accounttext);
        this.add(name);
        this.add(nametext);
        this.add(password);
        this.add(passwordtext);
        this.add(change);


    }

}
