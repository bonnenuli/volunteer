package View;

import Front.Fronts;
import Jframe.ManageUtl.ActivityInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagementSystem extends JFrame {
    // 定义布局
    BoxLayout boxLayout;
    FlowLayout flowlayout;
    //窗口变量
    final int WIDTH = 2510;//设置顶层框架的宽度
    final int HEIGHT = 1500;//设置顶层框架高度
    //定义菜单栏
    JMenuBar jMenuBar;//定义一个菜单条
    JMenu jMenu1;//定义一个菜单
    JMenu jMenu2;
    JMenu jMenu3;
    JMenu jMenu4;
    JMenu jMenu5;
    JMenu jMenu6;
    JMenu jMenu7;
    JMenuItem item2_1,item2_2;
    JMenuItem item4_1,item4_2;
    JMenuItem item6_1,item6_2;
    //定义一个盒子
    javax.swing.JPanel jPanel_1;//放置全部界面和背景图片
    javax.swing.JPanel jPanel_2;//放置页尾标签
    javax.swing.JPanel jPanel_3;//放置公告信息
    javax.swing.JPanel jPanel_4;//放置一张图片
    javax.swing.JPanel jPanel_5;//放置四张图片
    javax.swing.JPanel jPanel_6;//放置登录和注册按钮
    //定义标签
    JLabel imageLabel;
    JLabel imLabel;
    JLabel footerLabel;
    JTextArea noticeArea;
    //定义按钮
    JButton loginButton;//登录按钮
    JButton registerButton;//注册按钮
    JScrollPane noticeScrollPane;
    JScrollPane jScrollPane;
    JPanel imageGridPanel;
    // 创建内容面板
    JPanel contentPanel = new JPanel(new BorderLayout());

    public ManagementSystem() {
        init();
        setVisible(true);//设置当前窗口是否显示
        setSize(2510,1500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        validate();//让组件生效
        // 将内容面板添加到窗口
        setContentPane(contentPanel);
    }

    void init(){
        //定义一个布局
        flowlayout = new FlowLayout(FlowLayout.CENTER);//居中对齐
        // 设置内容面板
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //设置布局为空
        this.setLayout(null);
        // 设置窗口标题
        setTitle("校园志愿者登录界面");
        //初始化字体类
        Fronts fronts = new Fronts();
        // 创建菜单栏和菜单项
        jMenuBar = new JMenuBar();//构造菜单条
        jMenu1 = new JMenu("首页");
        jMenu2 = new JMenu("活动信息");
        jMenu3 = new JMenu("公告信息");
        jMenu4 = new JMenu("活动心得");
        jMenu5 = new JMenu("交流反馈");
        jMenu6 = new JMenu("个人中心");
        jMenu7 = new JMenu("后台管理");
        item2_1 = new JMenuItem("活动详细信息",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img.png"));
        item2_2 = new JMenuItem("活动类型",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_1.png"));
        item4_1 = new JMenuItem("心得分享",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_2.png"));
        item4_2 = new JMenuItem("  评  论  ",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_3.png"));
        item6_1 = new JMenuItem("活动记录",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_4.png"));
        item6_2 = new JMenuItem("个人资料",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_5.png"));
        //添加组件
        jMenu2.add(item2_1);
        jMenu2.add(item2_2);
        jMenu4.add(item4_1);
        jMenu4.add(item4_2);
        jMenu6.add(item6_1);
        jMenu6.add(item6_2);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu4);
        jMenuBar.add(jMenu5);
        jMenuBar.add(jMenu6);
        jMenuBar.add(jMenu7);

        //初始化第一个框的组件
        jPanel_1 = new javax.swing.JPanel();
        jPanel_1.setLayout(flowlayout);
        jPanel_1.setBounds(0,0,WIDTH,1500);
        jScrollPane = new JScrollPane(jPanel_1);//添加一个浏览窗格
        jScrollPane.setPreferredSize(new Dimension(1500,1500));//给窗格设置大小
        jPanel_1.setPreferredSize(new Dimension(1500,2400));//给盒子1设置大小
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//将滑动组件显示在窗口中
        // 添加图片
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\m1.jpg");
        imageLabel = new JLabel(icon);
        contentPanel.add(imageLabel, BorderLayout.NORTH);
        imageLabel.setBounds(0,0,WIDTH,520);
        //初始化第二个框的组件
        jPanel_2 = new javax.swing.JPanel();
        jPanel_2.setLayout(flowlayout);
        jPanel_2.setBounds(10,540,WIDTH-20,80);
        // 添加页尾组件
        footerLabel = new JLabel("欢迎来到校园志愿者管理系统", JLabel.CENTER);
        footerLabel.setFont(fronts.title);
        footerLabel.setBackground(new Color(8,189,252));
        footerLabel.setForeground(Color.black);
        //初始化第三个框的组件
        jPanel_3 = new javax.swing.JPanel();
        jPanel_3.setBorder(BorderFactory.createTitledBorder("公告信息"));
        jPanel_3.setBounds(10,620,WIDTH/3,500);
        // 添加公告信息
        noticeArea = new JTextArea("公告信息\n\n有新活动啦！！！\n\n青年志愿者协会招新进行中\n\n");
        noticeArea.setEditable(true);
        noticeScrollPane = new JScrollPane(noticeArea);
        noticeArea.setBounds(10,620,WIDTH/3,500);
        //初始化第四个框的组件
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4.setBounds(810,620,930,500);
        // 添加图片
        ImageIcon ico = new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\ggxx.jpg");
        imLabel = new JLabel(ico);
        contentPanel.add(imageLabel, BorderLayout.NORTH);
        //初始化第六个框的组件
        jPanel_6 = new javax.swing.JPanel();
        jPanel_6.setBorder(BorderFactory.createTitledBorder("登录/注册"));
        jPanel_6.setBounds(2020,820,270,480);



        //登录按钮
        loginButton = new JButton("安全登录");
        loginButton.setBounds(30,110,100,45);
        loginButton.setFont(fronts.login);
        loginButton.setBackground(new Color(8,189,252));
        loginButton.setForeground(Color.black);
        //注册标签
        registerButton = new JButton("注册账号");
        registerButton.setBounds(30,150,100,45);
        registerButton.setFont(fronts.register);
        registerButton.setForeground(Color.black);

        //初始化第五个框的组件
        jPanel_5 = new javax.swing.JPanel();
        jPanel_5.setLayout(flowlayout);
        jPanel_5.setBorder(BorderFactory.createTitledBorder("精彩瞬间"));
        jPanel_5.setBounds(10,1130,WIDTH-20,300);
        // 添加四张图片
        // 创建圆形图片网格
        imageGridPanel = new JPanel(new GridLayout(1, 5, 20, 20));
        imageGridPanel.setOpaque(false);
        String[] imagePaths = {
                "C:\\code\\Volunteer\\image\\Volunteer\\act8.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act9.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act10.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act11.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act12.jpg"
        };
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon circularImageIcon = new ImageIcon(imagePaths[i]);
            Image image = circularImageIcon.getImage();
            Image newImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            circularImageIcon = new ImageIcon(newImage);
            imageLabel = new JLabel(circularImageIcon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            imageLabel.setPreferredSize(new Dimension(400, 300));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            imageGridPanel.add(imageLabel);
        }

        // 活动信息管理菜单项监听器
        item2_1.addActionListener(new JMenu2ItemListener());
        item2_2.addActionListener(new JMenu2ItemListener());
        // 个人中心管理菜单项监听器
        item4_1.addActionListener(new JMenu4ItemListener());
        item4_2.addActionListener(new JMenu4ItemListener());
        // 活动心得管理菜单项监听器
        item6_1.addActionListener(new JMenu6ItemListener());
        item6_2.addActionListener(new JMenu6ItemListener());

        // 添加一个按钮，用于打开活动信息界面
        JButton activityInfoButton = new JButton("活动信息");
        activityInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示活动信息界面
                ActivityInfo activityInfo = new ActivityInfo();

                activityInfo.setVisible(true);
            }
        });

        // 将按钮添加到主界面
        add(activityInfoButton, BorderLayout.SOUTH);


        // 将公告信息和按钮添加到面板
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.add(noticeScrollPane, BorderLayout.CENTER);
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);
        buttonsPanel.add(loginPanel, BorderLayout.SOUTH);

        // 将面板添加到内容面板
        // 将登录按钮添加到内容面板
        //JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.add(loginButton, BorderLayout.EAST);
        contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
        // 将内容面板添加到窗口
        setContentPane(contentPanel);



        // 登录按钮的完善
        loginButton.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
        });

// 注册按钮的完善
        registerButton.addActionListener(e -> {
            Register register = new Register();
            register.setVisible(true);
        });

        // 将五个盒子添加到内容面板
        contentPanel.add(jPanel_1,BorderLayout.NORTH);
        contentPanel.add(jPanel_2);
        contentPanel.add(jPanel_3);
        contentPanel.add(jPanel_4);
        contentPanel.add(jPanel_5);
        jPanel_1.add(imageLabel);
        jPanel_2.add(footerLabel);


        jPanel_6.add(loginButton);
        jPanel_6.add(registerButton);
        jPanel_5.add(imageGridPanel);
        jPanel_4.add(imLabel);
        jPanel_5.add(jPanel_1);
        jPanel_6.add(jPanel_1);
        jPanel_4.add(jPanel_1);
        jPanel_3.add(jPanel_1);
        jPanel_2.add(jPanel_1);
        jPanel_3.add(noticeArea);
        this.add(jPanel_1);
        this.add(jMenuBar);
        this.setJMenuBar(jMenuBar);

    }


    // 活动信息管理菜单项监听器
    private class JMenu2ItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 根据点击的菜单项执行相应操作
            JOptionPane.showMessageDialog(null, "欢迎进入活动信息管理界面");
        }
    }

    // 个人中心管理菜单项监听器
    private class JMenu4ItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 根据点击的菜单项执行相应操作
            JOptionPane.showMessageDialog(null, "欢迎进入个人中心界面");
        }
    }

    // 活动心得管理菜单项监听器
    private class JMenu6ItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 根据点击的菜单项执行相应操作
            JOptionPane.showMessageDialog(null, "欢迎进入活动心得管理界面");
        }
    }
}




