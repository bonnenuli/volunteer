package Jframe.VolunteerUtl;

import Front.Fronts;
import Dao.VolEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Apply extends JFrame {
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
    JButton first2,sin;
    JButton type;
    JButton activity;
    JButton actform;
    JButton notic;
    JButton news;
    JButton message;
    JButton personal;
    JLabel name;//定义姓名标签
    public static JTextField nametext;//输入姓名文本
    JLabel number;//定义账户标签
    public static JTextField numbertext;
    JLabel em;//定义账户标签
    public static JTextField emtext;
    JLabel act;
    public static JButton apply;//注册按钮
    // 定义一个面板
    JPanel contentPanel;
    JLabel bgimg;
    //定义一个监听
    ActionListener listener_1;

    public Apply() {
        init();
        // 设置窗口标题
        setTitle("校园志愿者管理系统 - 活动报名");

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
        // 设置窗口标题
        setTitle("校园志愿者活动时长界面");
        //初始化字体类
        Fronts fronts = new Fronts();
        //初始化第二个框的组件
        jPanel_1 = new javax.swing.JPanel();
        jPanel_1.setLayout(boxLayout);
        jPanel_1.setOpaque(false);
        jPanel_1.setBounds(20, 10, 2450, 190);
        // 添加页尾组件
        footerLabel = new JLabel("欢迎来到校园志愿者管理系统", JLabel.CENTER);
        footerLabel.setFont(fronts.yt);
        footerLabel.setBackground(Color.white);
        footerLabel.setBounds(800,50,900,70);
        footerLabel.setForeground(new Color(100,149,237));
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
        jPanel_2.setBounds(20, 300, 2450, 90);
        //添加按钮
        first2 = new JButton("首页");
        first2.setFont(fronts.username);
        first2.setForeground(new Color(23, 153, 234));
        first2.setBackground(Color.cyan);
        first2.setBounds(430, 10, 100, 90);
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
        jPanel_3.setBackground(new Color(192,247,252));
        jPanel_3.setBorder(BorderFactory.createTitledBorder("立即报名"));
        jPanel_3.setBounds(820, 590, 900, 600);
        name = new JLabel(" 姓    名");
        name.setBounds(200,100,200,35);
        name.setFont(fronts.username);
        nametext = new JTextField(15);
        nametext.setBounds(410,100,300,40);
        nametext.setFont(fronts.usernametext);
        //对账号相关标签初始化
        number = new JLabel(" 电    话");
        number.setBounds(200,180,200,35);
        number.setFont(fronts.username);
        numbertext = new JTextField(15);
        numbertext.setBounds(410,180,300,40);
        numbertext.setFont(fronts.usernametext);
        em = new JLabel(" 邮    箱");
        em.setBounds(200,260,200,35);
        em.setFont(fronts.username);
        emtext = new JTextField(15);
        emtext.setBounds(410,260,300,40);
        emtext.setFont(fronts.usernametext);
        act = new JLabel(" 活动名称");
        act.setBounds(200,340,200,35);
        act.setFont(fronts.username);
        // 创建权限选择下拉列表
        String[] roles = {"青春", "校园","青春伴夕阳","清风校园","节能校园行","维持秩序"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(410,340,300,40);
        //按钮
        apply = new JButton("立即报名");
        apply.setBounds(350,450,240,40);
        apply.setFocusPainted(false);//去掉按钮周围的焦点框
        apply.setContentAreaFilled(false);//设置按钮透明背景
        apply.setFont(new Font("微软雅黑", Font.BOLD, 30));
        apply.setBackground(new Color(255, 153, 41));
        apply.setForeground(new Color(203, 137, 101));

        //添加按钮
        jPanel_1.add(footerLabel);
        jPanel_2.add(first2);
        jPanel_2.add(sin);
        jPanel_2.add(activity);
        jPanel_2.add(actform);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(news);
        jPanel_2.add(message);
        jPanel_2.add(personal);
        jPanel_3.add(name);
        jPanel_3.add(nametext);
        jPanel_3.add(number);
        jPanel_3.add(numbertext);
        jPanel_3.add(em);
        jPanel_3.add(emtext);
        jPanel_3.add(apply);
        jPanel_3.add(act);
        jPanel_3.add(roleComboBox);
        this.add(jPanel_3);
        this.add(jPanel_2);
        this.add(jPanel_1);
        this.add(bgimg);
        setVisible(true);
        allEvent();
        setAllName();
    }

    void allEvent() {
        listener_1 = new VolEvent();
        first2.addActionListener(listener_1);
        type.addActionListener(listener_1);
        activity.addActionListener(listener_1);
        actform.addActionListener(listener_1);
        notic.addActionListener(listener_1);
        news.addActionListener(listener_1);
        message.addActionListener(listener_1);
        personal.addActionListener(listener_1);
        apply.addActionListener(listener_1);
        sin.addActionListener(listener_1);
    }

    void setAllName() {
        first2.setName("first");
        type.setName("type");
        activity.setName("act");
        actform.setName("form");
        notic.setName("notic");
        news.setName("new");
        message.setName("message");
        personal.setName("per");
        apply.setName("baom");
        sin.setName("sin");
    }

}


