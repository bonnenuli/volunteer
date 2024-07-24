package Jframe.VolunteerUtl;

import Front.Fronts;
import Dao.VolEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolNews extends JFrame {
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
    JButton first2;
    JTextArea text2;
    JScrollPane textsScrollPane;
    JLabel bgimg;
    public static JButton xw;
    public static JButton jz;
    public static JButton jc;
    public static JButton hd;



    // 定义一个面板
    JPanel contentPanel;
    //定义一个监听
    ActionListener listener_1;
    public SchoolNews() {
        init();
        // 设置窗口标题
        setTitle("校园志愿者管理系统 - 公告信息");
        setVisible(true);//设置当前窗口是否显示
        setSize(2510, 1500);
        setResizable(false);//设置窗口不可以调节大小
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置默认关闭方式
        setLocationRelativeTo(null); // 设置窗口居中
        validate();//让组件生效
    }
    void init(){
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
        jPanel_1.setBounds(20,10,2450,190);
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
        jPanel_2.setBounds(20,300,2450,120);
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
        jPanel_3.setBackground(Color.white);
        jPanel_3.setBorder(BorderFactory.createTitledBorder(""));
        jPanel_3.setBounds(350,550,300,400);
        xw = new JButton("校园新闻");
        xw.setFont(fronts.username);
        xw.setContentAreaFilled(false);
        xw.setForeground(new Color(138,43,226));
        xw.setBackground(Color.cyan);
        xw.setBounds(0, 0, 300, 100);
        xw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.setText("青年志愿者协会招新进行中\n\n我校青年志愿者协会换届啦！！！\n\n共话心声，逐梦未来\n\n");
            }
        });
        jz = new JButton("讲座报告");
        jz.setFont(fronts.username);
        jz.setContentAreaFilled(false);
        jz.setForeground(new Color(138,43,226));
        jz.setBackground(Color.cyan);
        jz.setBounds(0, 100, 300, 100);
        jz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.setText("中国历代绘画宣讲开始啦！！！\n\n口腔宣讲开始啦！！！");
            }
        });
        jc = new JButton("精彩瞬间");
        jc.setFont(fronts.username);
        jc.setContentAreaFilled(false);
        jc.setForeground(new Color(138,43,226));
        jc.setBackground(Color.cyan);
        jc.setBounds(0, 200, 300, 100);
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.setText("1.童年乐章，快乐启航\n" +
                        "2. 九九重阳节，浓浓敬老情\n" +
                        "3.培养创新思维，塑造艺术人生\n" +
                        "4.暖阳行动\n" +
                        "5.文明交通伴我行社区闭班仪式\n" +
                        "6.青春版夕阳开班仪式\n" +
                        "7.传统文化，匠心独运\n" +
                        "8.防范再行动，安全共创建");
            }
        });
        hd = new JButton("活动简介");
        hd.setFont(fronts.username);
        hd.setContentAreaFilled(false);
        hd.setForeground(new Color(138,43,226));
        hd.setBackground(Color.cyan);
        hd.setBounds(0, 300, 300, 100);
        hd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.setText("        这是一场充满热情与期待的活动，我们精心筹备了各式各样的节目，\n\n旨在为志愿者们提供一个展示自我、互相交流的平台。从激昂的诗朗诵到\n\n优美的舞蹈“万疆”，从动感的现代舞到抒情的歌曲“美丽中国”，志愿者们\n\n用精彩的表演传递着对这次活动的热爱和对志愿服务精神的追求。");
            }
        });
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4.setLayout(boxLayout);
        jPanel_4.setBorder(BorderFactory.createTitledBorder(""));
        jPanel_4.setBounds(710,550,1400,600);
        first1 = new JButton("首页");
        first1.setFont(fronts.username);
        first1.setContentAreaFilled(false);
        first1.setForeground(new Color(23, 153, 234));
        first1.setBackground(Color.cyan);
        first1.setBounds(10, 10, 100, 90);
        text2 = new JTextArea("宁夏理工学院学子在第六届“中国创翼”创业创新大赛石嘴山是选拔赛中再创佳绩\n\n我校龙舟队勇夺桂冠\n\n青年志愿者协会招新进行中\n\n我校青年志愿者协会换届啦！！！\n\n共话心声，逐梦未来\n\n");
        text2.setEditable(true);
        text2.setOpaque(false);
        text2.setFont(fronts.username);
        textsScrollPane = new JScrollPane(text2);
        text2.setBounds(80,100,1200,500);
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
        jPanel_3.add(xw);
        jPanel_3.add(jz);
        jPanel_3.add(jc);
        jPanel_3.add(hd);
        jPanel_4.add(first1);
        jPanel_4.add(text2);
        jPanel_4.add(textsScrollPane);
        this.add(jPanel_4);
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
        first2.addActionListener(listener_1);
        sin.addActionListener(listener_1);
    }

    void setAllName(){
        first1.setName("first");
        type.setName("type");
        activity.setName("act");
        actform.setName(" form");
        notic.setName("notic");
        news.setName("new");
        message.setName("message");
        personal.setName("per");
        first2.setName("first2");
        sin.setName("sin");
    }


}



