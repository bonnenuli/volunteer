package View;

import Front.Fronts;
import Dao.MenageEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Manage extends JFrame {
    // 定义布局
    BoxLayout boxLayout;
    JLabel bgimg;
    //定义菜单栏
    JMenuBar jMenuBar;//定义一个菜单条
    JMenu jMenu1;//定义一个菜单
    JMenu jMenu2;
    JMenu jMenu3;
    JMenu jMenu4;
    JMenu jMenu5;
    JMenu jMenu6;
    //定义一个盒子
    javax.swing.JPanel jPanel_1;//放置全部界面和背景图片
    javax.swing.JPanel jPanel_2;//放置页尾标签
    javax.swing.JPanel jPanel_3;//放置公告信息
    JLabel footerLabel;
    JLabel footer;
    public static JLabel activity;//定义活动标签
    public static JTextField activitytext;
    public static JButton searchButton;//定义查询按钮
    public static JButton addButton;//定义添加按钮
    public static JButton modifyButton;//定义修改按钮
    public static JButton deleteButton;//定义删除按钮
    public static JButton first2;
    public static JButton volunteer;
    public static JButton actforms;
    public static JButton acttimes;
    public static JButton type;
    public static JButton activities;
    public static JButton notic;
    public static JButton personal;

    // 创建内容面板
    JPanel contentPanel = new JPanel(new BorderLayout());
    //定义一个监听
    ActionListener listener_1;

    public Manage() {
        initialize();
        setVisible(true);
        setSize(2510, 1500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(contentPanel); // 将内容面板添加到窗口
    }

    private void initialize() {
        // 设置内容面板
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(20, 120, WIDTH, HEIGHT);
        //设置布局为空
        this.setLayout(null);
        // 设置窗口标题
        setTitle("校园志愿者登录界面");
        //初始化字体类
        Fronts fronts = new Fronts();

        //添加菜单栏
        jMenuBar = new JMenuBar();//构造菜单条
        jMenu1 = new JMenu("首页");
        jMenu2 = new JMenu("个人中心");
        jMenu3 = new JMenu("活动报名");
        jMenu4 = new JMenu("活动通知");
        jMenu5 = new JMenu("活动心得");
        jMenu6 = new JMenu("交流反馈");

        //添加组件
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu4);
        jMenuBar.add(jMenu5);
        jMenuBar.add(jMenu6);
        //初始化第一个框的组件
        jPanel_1 = new javax.swing.JPanel();
        jPanel_1.setLayout(boxLayout);
        jPanel_1.setBackground(new Color(102, 224, 224, 128));
        jPanel_1.setBounds(20, 10, 2440, 190);
        // 添加页尾组件
        footerLabel = new JLabel("欢迎来到校园志愿者管理系统", JLabel.CENTER);
        footerLabel.setFont(fronts.yt);
        footerLabel.setBackground(new Color(8, 189, 252));
        footerLabel.setBounds(800, 50, 900, 70);
        footerLabel.setForeground(new Color(100, 149, 237));
        // 添加图片
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\2.jpg");
        Image image = icon.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(2450, 1200, java.awt.Image.SCALE_SMOOTH); // 缩放图片
        icon = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(icon);
        bgimg.setBounds(20, 170, 2450, 1230); // 设置背景图片的位置和大小
        //初始化第二个框的组件
        jPanel_2 = new javax.swing.JPanel();
        jPanel_2.setLayout(boxLayout);
        jPanel_2.setOpaque(false);
        jPanel_2.setBounds(20, 260, 2450, 120);
        //添加按钮
        first2 = new JButton("首页");
        first2.setFont(fronts.username);
        first2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        first2.setBorder(null);//设置此组件的无边框
        first2.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        first2.setForeground(new Color(23, 153, 234));
        first2.setBackground(Color.cyan);
        first2.setBounds(350, 10, 100, 70);
        volunteer = new JButton("志愿者管理");
        volunteer.setForeground(new Color(23, 153, 234));
        volunteer.setBackground(Color.cyan);
        volunteer.setFont(fronts.username);
        volunteer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        volunteer.setBorder(null);//设置此组件的无边框
        volunteer.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        volunteer.setBounds(470, 10, 210, 70);
        activities = new JButton("活动管理");
        activities.setFont(fronts.username);
        activities.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        activities.setBorder(null);//设置此组件的无边框
        activities.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        activities.setForeground(new Color(23, 153, 234));
        activities.setBackground(Color.cyan);
        activities.setBounds(700, 10, 180, 70);
        type = new JButton("活动分类管理");
        type.setFont(fronts.username);
        type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        type.setBorder(null);//设置此组件的无边框
        type.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        type.setForeground(new Color(23, 153, 234));
        type.setBackground(Color.cyan);
        type.setBounds(900, 10, 240, 70);
        notic = new JButton("通知公告");
        notic.setFont(fronts.username);
        notic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        notic.setBorder(null);//设置此组件的无边框
        notic.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        notic.setForeground(new Color(23, 153, 234));
        notic.setBackground(Color.cyan);
        notic.setBounds(1160, 10, 180, 70);
        actforms = new JButton("活动报名信息管理");
        actforms.setFont(fronts.username);
        actforms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        actforms.setBorder(null);//设置此组件的无边框
        actforms.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        actforms.setForeground(new Color(23, 153, 234));
        actforms.setBackground(Color.cyan);
        actforms.setBounds(1360, 10, 300, 70);
        acttimes = new JButton("活动时长管理");
        acttimes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        acttimes.setBorder(null);//设置此组件的无边框
        acttimes.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        acttimes.setFont(fronts.username);
        acttimes.setForeground(new Color(23, 153, 234));
        acttimes.setBackground(Color.cyan);
        acttimes.setBounds(1680, 10, 240, 70);
        personal = new JButton("个人中心");
        personal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
        personal.setBorder(null);//设置此组件的无边框
        personal.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
        personal.setFont(fronts.username);
        personal.setForeground(new Color(23, 153, 234));
        personal.setBackground(Color.cyan);
        personal.setBounds(1940, 10, 180, 70);

        //初始化第三个框的组件
        jPanel_3 = new javax.swing.JPanel();
        jPanel_3.setLayout(boxLayout);
        jPanel_3.setOpaque(false);
        jPanel_3.setBounds(220, 650, 2050, 550);
        footer = new JLabel("欢迎来到校园志愿者管理员界面", JLabel.CENTER);
        footer.setFont(fronts.zhu);
        footer.setOpaque(false);
        footer.setBackground(new Color(8, 189, 252));
        footer.setBounds(200, 130, 1700, 170);
        footer.setForeground(new Color( 100,149,237));


        jPanel_1.add(footerLabel);
        jPanel_2.add(first2);
        jPanel_2.add(volunteer);
        jPanel_2.add(activities);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(actforms);
        jPanel_2.add(acttimes);
        jPanel_2.add(personal);
        jPanel_3.add(footer);
        // 将三个盒子添加到主面板
        contentPanel.add(jPanel_1);
        contentPanel.add(jPanel_2);
        contentPanel.add(jPanel_3);
        contentPanel.add(bgimg);
        this.setJMenuBar(jMenuBar);
        setVisible(true);
        allEvent();
        setAllName();
    }

    void allEvent() {
        listener_1 = new MenageEvent();
        first2.addActionListener(listener_1);
        volunteer.addActionListener(listener_1);
        actforms.addActionListener(listener_1);
        acttimes.addActionListener(listener_1);
        type.addActionListener(listener_1);
        activities.addActionListener(listener_1);
        notic.addActionListener(listener_1);
        personal.addActionListener(listener_1);

    }

    void setAllName() {
        first2.setName("zhu");
        volunteer.setName("vol");
        actforms.setName("apply");
        acttimes.setName("time");
        type.setName("type");
        activities.setName("acts");
        notic.setName("not");
        personal.setName("per");

    }
}