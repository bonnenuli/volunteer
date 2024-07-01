package Jframe.ManageUtl;

import Dao.MenageEvent;
import Front.Fronts;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Myself extends JFrame {
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
    javax.swing.JPanel jPanel_4;//放置基本信息
    javax.swing.JPanel jPanel_5;//放置简介以及评论按钮
    //定义标签
    JLabel footerLabel;
    static JButton sc;
    static JButton uploadButton;
    JButton introductory;
    JTextArea text2;
    JScrollPane textsScrollPane;
    JLabel bgimg;
    JLabel imageLabel;
    public static JButton first2;
    public static JButton volunteer;
    public static JButton actforms;
    public static JButton acttimes;
    public static JButton type;
    public static JButton activities;
    public static JButton notic;
    public static JButton personal;
    JLabel name;//定义姓名标签
    public static JTextField nametext;//输入姓名文本
    JLabel number;//定义账户标签
    public static JTextField numbertext;
    JLabel em;//定义账户标签
    public static JTextField emtext;
    JLabel br;//定义账户标签
    public static JTextField brtext;
    // 定义一个面板
    JPanel contentPanel;
    //定义一个监听
    ActionListener listener_1;
    ActionListener listener_2;
    private Object e;

    public Myself() {
        init();
        // 设置窗口标题
        setTitle("校园志愿者管理系统 - 个人中心");
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
        jPanel_1 = new JPanel();
        jPanel_1.setLayout(boxLayout);
        jPanel_1.setBackground(new Color(102, 224, 224, 128));
        jPanel_1.setBounds(20, 10, 2450, 190);
        // 添加页尾组件
        footerLabel = new JLabel("欢迎来到校园志愿者管理系统", JLabel.CENTER);
        footerLabel.setFont(fronts.yt);
        footerLabel.setBackground(new Color(8, 189, 252));
        footerLabel.setBounds(800, 50, 900, 70);
        footerLabel.setForeground(new Color(100, 149, 237));
        // 添加图片
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\2.jpg");
        Image image = icon.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(2450, 1200, Image.SCALE_SMOOTH); // 缩放图片
        icon = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(icon);
        bgimg.setBounds(20, 170, 2450, 1230); // 设置背景图片的位置和大小
        //初始化第二个框的组件
        jPanel_2 = new JPanel();
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
        jPanel_3 = new JPanel();
        jPanel_3.setLayout(boxLayout);
        jPanel_3.setOpaque(false);
        jPanel_3.setBounds(340,400,650,500);
        // 添加图片
        ImageIcon ic = new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\ggxx.jpg");
        Image age = ic.getImage();
        // 计算宽高比
        double ratio = (double)age.getWidth(null) / age.getHeight(null);
        int newWidth, newHeight;
        if (ratio > 1) {
            newWidth = 650;
            newHeight = (int)(650 / ratio);
        } else {
            newHeight = 500;
            newWidth = (int)(500 * ratio);
        }
        // 缩放图片
        Image img = age.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ic = new ImageIcon(img);
        imageLabel = new JLabel(ic);
        imageLabel.setBounds((650 - newWidth) / 2, (500 - newHeight) / 2, newWidth, newHeight);
        //初始化第四个框的组件
        jPanel_4 = new JPanel();
        jPanel_4.setLayout(boxLayout);
        jPanel_4.setOpaque(false);
        jPanel_4.setBounds(1100,400,1100,500);
        name = new JLabel(" 姓    名");
        name.setBounds(200,50,200,35);
        name.setFont(fronts.username);
        nametext = new JTextField(15);
        nametext.setBounds(410,50,300,40);
        nametext.setFont(fronts.usernametext);
        //对账号相关标签初始化
        number = new JLabel(" 电    话");
        number.setBounds(200,130,200,35);
        number.setFont(fronts.username);
        numbertext = new JTextField(15);
        numbertext.setBounds(410,130,300,40);
        numbertext.setFont(fronts.usernametext);
        em = new JLabel(" 邮    箱");
        em.setBounds(200,210,200,35);
        em.setFont(fronts.username);
        emtext = new JTextField(15);
        emtext.setBounds(410,210,300,40);
        emtext.setFont(fronts.usernametext);
        br = new JLabel("生    日");
        br.setBounds(200,290,200,35);
        br.setFont(fronts.username);
        brtext = new JTextField(15);
        brtext.setBounds(410,290,300,40);
        brtext.setFont(fronts.usernametext);
        sc = new JButton("修改信息");
        sc.setForeground(new Color(23, 153, 234));
        sc.setBackground(Color.cyan);
        sc.setFont(fronts.username);
        sc.setBounds(300,430,230,60);
        // 添加长传头像控件
        uploadButton = new JButton("上传头像");
        uploadButton.setFont(fronts.username);
        uploadButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        uploadButton.setBorder(null);
        uploadButton.setBorder(BorderFactory.createRaisedBevelBorder());
        uploadButton.setForeground(new Color(23, 153, 234));
        uploadButton.setBackground(Color.cyan);
        uploadButton.setBounds(550, 430, 180, 60);
        // 设置上传按钮的监听器
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // 打开文件选择对话框
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("图片文件", "png", "jpg", "jpeg", "gif"));
                int result = fileChooser.showOpenDialog(Myself.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // 加载图片
                        BufferedImage image = ImageIO.read(selectedFile);
                        // 创建ImageIcon
                        ImageIcon icon = new ImageIcon(image);
                        // 设置ImageIcon到JLabel
                        imageLabel.setIcon(icon);
                        // 调整JLabel的大小以适应图片
                        imageLabel.setBounds((650 - image.getWidth()) / 2, (500 - image.getHeight()) / 2, image.getWidth(), image.getHeight());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }});
        //初始化第五个框的组件
        jPanel_5 = new JPanel();
        jPanel_5.setLayout(boxLayout);
        jPanel_5.setOpaque(false);
        jPanel_5.setBounds(260,930,WIDTH-50,400);
        introductory = new JButton("个人简介");
        introductory.setContentAreaFilled(false);
        introductory.setForeground(new Color(23, 153, 234));
        introductory.setBackground(Color.cyan);
        introductory.setFont(fronts.username);
        introductory.setBounds(30,10,260,80);
        text2 = new JTextArea("    这次活动的热爱和对志愿服务精神的追求。\n\n");
        text2.setEditable(true);
        text2.setOpaque(false);
        text2.setFont(fronts.username);
        textsScrollPane = new JScrollPane(text2);
        text2.setBounds(20,100,WIDTH-400,300);
        //添加按钮
        jPanel_1.add(footerLabel);
        jPanel_2.add(first2);
        jPanel_2.add(volunteer);
        jPanel_2.add(activities);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(actforms);
        jPanel_2.add(acttimes);
        jPanel_2.add(personal);
        jPanel_3.add(imageLabel);
        jPanel_4.add(name);
        jPanel_4.add(nametext);
        jPanel_4.add(number);
        jPanel_4.add(numbertext);
        jPanel_4.add(em);
        jPanel_4.add(emtext);
        jPanel_4.add(br);
        jPanel_4.add(brtext);
        jPanel_4.add(sc);
        jPanel_4.add(uploadButton);
        jPanel_5.add(introductory);
        jPanel_5.add(text2);
        this.add(jPanel_5);
        this.add(jPanel_4);
        this.add(jPanel_3);
        this.add(jPanel_2);
        this.add(bgimg);
        this.add(jPanel_1);
        allEvent();
        Event();
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
        sc.addActionListener(listener_1);

    }
    void Event(){
        uploadButton.addActionListener(listener_2);
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
        sc.setName("my");
    }



}


