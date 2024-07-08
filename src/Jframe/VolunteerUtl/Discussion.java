package Jframe.VolunteerUtl;

import Front.Fronts;
import Dao.VolEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Discussion extends JFrame {
    //定义一个布局
    FlowLayout flowlayout;
    BoxLayout boxLayout;
    //窗口变量
    final int WIDTH = 2510;//设置顶层框架的宽度
    final int HEIGHT = 1500;//设置顶层框架高度
    //定义一个盒子
    javax.swing.JPanel jPanel_1;//放置页尾组件
    javax.swing.JPanel jPanel_2;//放置所有按钮
    javax.swing.JPanel jPanel_3;//放置首页按钮
    //定义标签
    JLabel footerLabel;
    JButton first1,sin;
    JButton type;
    JButton activity;
    JButton actform;
    JButton notic;
    JButton news;
    JButton message;
    JButton personal;
    public static JTextArea messages,resultText;//显示结果
    JLabel bgimg;
    // 定义一个面板
    JPanel contentPanel;
    //定义一个监听
    ActionListener listener_1;
    public Discussion() {
        init();
        // 设置窗口标题
        setTitle("校园志愿者管理系统 - 互动论坛");
        setVisible(true);//设置当前窗口是否显示
        setSize(2510, 1500);
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
        this.setBounds(20, 120, WIDTH, HEIGHT);
        //设置布局为空
        this.setLayout(null);
        //初始化字体类
        Fronts fronts = new Fronts();
        //初始化第一个框的组件
        jPanel_1 = new javax.swing.JPanel();
        jPanel_1.setLayout(boxLayout);
        jPanel_1.setOpaque(false);
        jPanel_1.setBounds(20, 10, 2450, 190);
        // 添加页尾组件
        footerLabel = new JLabel("欢迎来到校园志愿者管理系统", JLabel.CENTER);
        footerLabel.setFont(fronts.yt);
        footerLabel.setBackground(Color.white);
        footerLabel.setBounds(800, 50, 900, 70);
        footerLabel.setForeground(new Color(100, 149, 237));
        // 添加图片
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\1.jpg");
        Image image = icon.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(2450, 1500, java.awt.Image.SCALE_SMOOTH); // 缩放图片
        icon = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(icon);
        bgimg.setBounds(20, 10, 2450, 1500); // 设置背景图片的位置和大小
        //初始化第二个框的组件
        jPanel_2 = new javax.swing.JPanel();
        jPanel_2.setLayout(boxLayout);
        jPanel_2.setOpaque(false);
        jPanel_2.setBounds(20, 300, 2450, 120);
        //添加按钮
        first1 = new JButton("首页");
        first1.setFont(fronts.username);
        first1.setForeground(new Color(23, 153, 234));
        first1.setBackground(Color.cyan);
        first1.setBounds(430, 10, 100, 90);
        sin = new JButton("签到");
        sin.setFont(fronts.username);
        sin.setForeground(new Color(23, 153, 234));
        sin.setBackground(Color.cyan);
        sin.setBounds(550, 10, 100, 90);
        activity = new JButton("活动信息");
        activity.setForeground(new Color(23, 153, 234));
        activity.setBackground(Color.cyan);
        activity.setFont(fronts.username);
        activity.setBounds(670, 10, 180, 90);
        actform = new JButton("活动报名");
        actform.setFont(fronts.username);
        actform.setForeground(new Color(23, 153, 234));
        actform.setBackground(Color.cyan);
        actform.setBounds(870, 10, 180, 90);
        type = new JButton("精彩瞬间");
        type.setFont(fronts.username);
        type.setForeground(new Color(23, 153, 234));
        type.setBackground(Color.cyan);
        type.setBounds(1070, 10, 180, 90);
        notic = new JButton("通知公告");
        notic.setFont(fronts.username);
        notic.setForeground(new Color(23, 153, 234));
        notic.setBackground(Color.cyan);
        notic.setBounds(1270, 10, 180, 90);
        news = new JButton("校园新闻");
        news.setFont(fronts.username);
        news.setForeground(new Color(23, 153, 234));
        news.setBackground(Color.cyan);
        news.setBounds(1470, 10, 180, 90);
        message = new JButton("留言板");
        message.setFont(fronts.username);
        message.setForeground(new Color(23, 153, 234));
        message.setBackground(Color.cyan);
        message.setBounds(1670, 10, 150, 90);
        personal = new JButton("个人中心");
        personal.setFont(fronts.username);
        personal.setForeground(new Color(23, 153, 234));
        personal.setBackground(Color.cyan);
        personal.setBounds(1840, 10, 180, 90);
        //初始化第三个框的组件
        jPanel_3 = new javax.swing.JPanel();
        jPanel_3.setLayout(boxLayout);
        jPanel_3.setBackground(Color.cyan);
        jPanel_3.setOpaque(false);
        jPanel_3.setBorder(BorderFactory.createTitledBorder(""));
        jPanel_3.setBounds(350, 500, 1850, 850);
        messages = new JTextArea();
        messages.setBorder(BorderFactory.createTitledBorder("留言框"));
        messages.setEditable(false);
        messages.setFont(fronts.sear);
        messages.setBounds(20,50,750,700);
        // 定义两个输入框
        JTextField inputFieldUser1 = new JTextField();
        JTextField inputFieldUser2 = new JTextField();
        // 定义两个发送按钮
        JButton sendButtonUser1 = new JButton("发送");
        JButton sendButtonUser2 = new JButton("发送");
        // 设置输入框和发送按钮的位置和大小
        inputFieldUser1.setBounds(20, 750, 650, 50);
        sendButtonUser1.setBounds(670, 750, 100, 50);
        inputFieldUser2.setBounds(20, 800, 650, 50);
        sendButtonUser2.setBounds(670, 800, 100, 50);
        // 为第一个账号的发送按钮添加事件监听器
        sendButtonUser1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取第一个账号输入框中的文本
                String inputTextUser1 = inputFieldUser1.getText();
                // 将文本添加到第一个账号的文本域和公共文本域中
                messages.setText(messages.getText() + "用户1: " + inputTextUser1 + "\n");
                resultText.setText(resultText.getText() + "用户1: " + inputTextUser1 + "\n");
                // 清空第一个账号的输入框
                inputFieldUser1.setText("");
            }
        });
        // 为第二个账号的发送按钮添加事件监听器
        sendButtonUser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取第二个账号输入框中的文本
                String inputTextUser2 = inputFieldUser2.getText();
                // 将文本添加到第二个账号的文本域和公共文本域中
                messages.setText(messages.getText() + "用户2: " + inputTextUser2 + "\n");
                resultText.setText(resultText.getText() + "用户2: " + inputTextUser2 + "\n");
                // 清空第二个账号的输入框
                inputFieldUser2.setText("");
            }
        });
        //添加显示结果
        resultText = new JTextArea();
        resultText.setBorder(BorderFactory.createTitledBorder("留言信息显示"));
        resultText.setEditable(false);
        resultText.setFont(fronts.sear);
        resultText.setOpaque(false);
        resultText.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "留言信息显示"));
        resultText.setBounds(900,50,700,750);
        //添加按钮
        jPanel_1.add(footerLabel);
        jPanel_2.add(first1);
        jPanel_2.add(sin);
        jPanel_2.add(activity);
        jPanel_2.add(actform);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(news);
        jPanel_2.add(message);
        jPanel_2.add(personal);
        jPanel_3.add(messages);
        jPanel_3.add(inputFieldUser1);
        jPanel_3.add(sendButtonUser1);
        jPanel_3.add(inputFieldUser2);
        jPanel_3.add(sendButtonUser2);
        jPanel_3.add(resultText);
        this.add(jPanel_3);
        this.add(jPanel_2);
        this.add(jPanel_1);
        this.add(bgimg);
        allEvent();
        setAllName();
    }
    void allEvent() {
        listener_1 = new VolEvent();
        first1.addActionListener(listener_1);
        type.addActionListener(listener_1);
        activity.addActionListener(listener_1);
        actform.addActionListener(listener_1);
        notic.addActionListener(listener_1);
        news.addActionListener(listener_1);
        message.addActionListener(listener_1);
        personal.addActionListener(listener_1);
        sin.addActionListener(listener_1);
    }
    void setAllName(){
        first1.setName("first");
        type.setName("type");
        activity.setName("act");
        actform.setName("form");
        notic.setName("notic");
        news.setName("new");
        message.setName("message");
        personal.setName("per");
        sin.setName("sin");
    }
}
