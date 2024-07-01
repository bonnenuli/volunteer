package Jframe.VolunteerUtl;

import Dao.VolEvent;
import Front.Fronts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Types extends JFrame {
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
    javax.swing.JPanel jPanel_5;
    javax.swing.JPanel jPanel_6;
    //定义标签
    JLabel footerLabel;
    JButton first1;
    JButton type;
    JButton activity;
    JButton actform;
    JButton notic;
    JButton news;
    JButton message;
    JButton personal;
    JPanel imageGridPanel;
    JPanel imGridPanel;
    JPanel labelsPanel;
    JPanel labelPanel;
    // 定义一个面板
    JPanel contentPanel;
    public static ButtonGroup group = null;//定义性别
    public static JRadioButton allt, one;//定义两个单选框
    public static JLabel act;
    public static JTextField acttext;
    public static DefaultTableModel model;
    JLabel bgimg;
    //定义一个监听
    ActionListener listener_1;

    public Types() {
        init();
        // 设置窗口标题
        setTitle("校园志愿者管理系统 - 活动类型");

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
        setTitle("校园志愿者--活动时长界面");
        //初始化字体类
        Fronts fronts = new Fronts();
        //初始化第一个框的组件
        jPanel_1 = new javax.swing.JPanel();
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
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\1.jpg");
        Image image = icon.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(2450, 1200, java.awt.Image.SCALE_SMOOTH); // 缩放图片
        icon = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(icon);
        bgimg.setBounds(20, 170, 2450, 1230); // 设置背景图片的位置和大小
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
        first1.setBounds(550, 10, 100, 90);
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
        type = new JButton("活动类型");
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

        // 初始化第三个框的组件
        jPanel_3 = new javax.swing.JPanel();
        jPanel_3.setLayout(flowlayout);
        jPanel_3.setBackground(Color.cyan);
        jPanel_3.setOpaque(false);
        jPanel_3.setBounds(570, 450, 1510, 300);
        // 添加四张图片
        // 创建圆形图片网格
        imageGridPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        imageGridPanel.setOpaque(false);
        String[] imagePaths = {
                "C:\\code\\Volunteer\\image\\Volunteer\\act8.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act9.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act10.jpg"
        };

        for (String imagePath : imagePaths) {
            ImageIcon circularImageIcon = new ImageIcon(imagePath);
            Image im = circularImageIcon.getImage();
            Image newImage = im.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            circularImageIcon = new ImageIcon(newImage);
            JLabel imageLabel = new JLabel(circularImageIcon); // 创建新的 JLabel
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            imageLabel.setPreferredSize(new Dimension(400, 300));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
            imageGridPanel.add(imageLabel); // 将 JLabel 添加到 imageGridPanel
        }
        //初始化第四个框的组件
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4.setLayout(flowlayout);
        jPanel_4.setBackground(Color.cyan);
        jPanel_4.setOpaque(false);
        jPanel_4.setBounds(570, 760, 1510, 70);
        labelPanel = new JPanel(new GridLayout(1, 3, 20, 20)); // 修改变量名
        labelPanel.setOpaque(false);
        String[] label = { // 修改数组变量名
                "户外素质拓展", "培养创新思维，塑造艺术人生", "童年乐章，快乐启航"
        };
        // 添加标签
        for (String labelText : label) {
            JLabel label1 = new JLabel(labelText);
            label1.setHorizontalAlignment(JLabel.CENTER);
            label1.setVerticalAlignment(JLabel.CENTER);
            label1.setPreferredSize(new Dimension(400, 30));
            labelPanel.add(label1);
        }
        // 初始化第五个框的组件
        jPanel_5 = new javax.swing.JPanel();
        jPanel_5.setLayout(flowlayout);
        jPanel_5.setBackground(Color.cyan);
        jPanel_5.setOpaque(false);
        jPanel_5.setBounds(570, 880, 1510, 300);
        // 添加四张图片
        // 创建圆形图片网格
        imGridPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        imGridPanel.setOpaque(false);
        String[] imPaths = {
                "C:\\code\\Volunteer\\image\\Volunteer\\act11.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act12.jpg",
                "C:\\code\\Volunteer\\image\\Volunteer\\act13.jpg"
        };

        for (String imPath : imPaths) {
            ImageIcon circularImageIcon = new ImageIcon(imPath);
            Image im = circularImageIcon.getImage();
            Image newImage = im.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            circularImageIcon = new ImageIcon(newImage);
            JLabel imLabel = new JLabel(circularImageIcon); // 创建新的 JLabel
            imLabel.setHorizontalAlignment(JLabel.CENTER);
            imLabel.setVerticalAlignment(JLabel.CENTER);
            imLabel.setPreferredSize(new Dimension(400, 300));
            imLabel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
            imGridPanel.add(imLabel); // 将 JLabel 添加到 imageGridPanel
        }
        //初始化第六个框的组件
        jPanel_6 = new javax.swing.JPanel();
        jPanel_6.setLayout(flowlayout);
        jPanel_6.setBackground(Color.cyan);
        jPanel_6.setOpaque(false);
        jPanel_6.setBounds(570, 1190, 1510, 50);
        labelsPanel = new JPanel(new GridLayout(1, 3, 20, 20)); // 修改变量名
        labelsPanel.setOpaque(false);
        String[] labelsTexts = { // 修改数组变量名
                "文明交通伴我行", "节粮倡议宣讲", "传统文化，匠心独运"
        };
        // 添加标签
        for (String labelsText : labelsTexts) {
            JLabel labels = new JLabel(labelsText);
            labels.setHorizontalAlignment(JLabel.CENTER);
            labels.setVerticalAlignment(JLabel.CENTER);
            labels.setPreferredSize(new Dimension(400, 30));
            labelsPanel.add(labels);
        }
        // 添加按钮
        jPanel_1.add(footerLabel);
        jPanel_2.add(first1);
        jPanel_2.add(activity);
        jPanel_2.add(actform);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(news);
        jPanel_2.add(message);
        jPanel_2.add(personal);
        jPanel_3.add(imageGridPanel);
        jPanel_4.add(labelPanel);
        jPanel_5.add(imGridPanel);
        jPanel_6.add(labelsPanel);

        this.add(jPanel_6);
        this.add(jPanel_5);
        this.add(jPanel_4);
        this.add(jPanel_3);
        this.add(jPanel_2);
        this.add(bgimg);
        this.add(jPanel_1);
        setVisible(true);
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

    }

    void setAllName() {
        first1.setName("first");
        type.setName("type");
        activity.setName("act");
        actform.setName("form");
        notic.setName("notic");
        news.setName("new");
        message.setName("message");
        personal.setName("per");
    }

}