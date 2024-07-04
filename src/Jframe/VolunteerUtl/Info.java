package Jframe.VolunteerUtl;

import Dao.InfoEvent;
import Front.Fronts;
import Dao.VolEvent;
import utils.Mysqld;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.Vector;

public class Info extends JFrame {
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
    JLabel bgimg;
    public static ButtonGroup group = null;//定义性别
    public static JRadioButton allt, one;//定义两个单选框
    public static JLabel act, nc, stime, demand, detail;//定义活动标签
    public static JTextField acttext;
    public static JButton searchButton;//定义查询按钮
    public static JTextField nctext;
    public static JTextField stimetext;
    public static JLabel apply;
    public static JTextField applytext;
    public static JTextField demandtext;
    public static JTextField detailtext;
    //表格的数据
    Object columns[] = {"活动名称", "开始时间", "报名人数", "需求人数", "发布时间", "活动介绍"};//标题信息
    JTable table = null;
    JScrollPane jScrollPane;
    public static Vector rwo;
    public static Object a[][];
    public static DefaultTableModel model;
    public static TableColumnModel columnModel;

    // 定义一个面板
    JPanel contentPanel;
    //定义一个监听
    ActionListener listener_1;
    ActionListener listener_2;
    private DefaultTableModel Model;
    private JTable Table;
    private JRootPane jf;

    public Info() {
        init();
        // 设置窗口标题
        setTitle("校园志愿者管理系统 - 活动信息");
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
        jPanel_3.setBorder(BorderFactory.createTitledBorder("搜索框"));
        jPanel_3.setBounds(200, 450, 310, 750);
        //添加按钮
        group = new ButtonGroup();
        one = new JRadioButton("单个信息");
        one.setFont(Fronts.sear);
        one.setOpaque(false);
        one.setBounds(60, 120, 150, 60);
        group.add(one);
        allt = new JRadioButton("全部信息");
        allt.setFont(Fronts.sear);
        allt.setOpaque(false);
        allt.setBounds(60, 170, 150, 60);
        group.add(allt);
        act = new JLabel("活动名称");
        act.setBounds(20, 220, 150, 50);
        //添加文本框
        acttext = new JTextField(15);
        acttext.setBounds(20, 280, 260, 50);
        //添加按钮
        searchButton = new JButton("查询数据");
        searchButton.setContentAreaFilled(false);
        searchButton.setFont(Fronts.title);
        searchButton.setBounds(40, 400, 210, 50);
        //初始化第四个框的组件
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4.setLayout(boxLayout);
        jPanel_4.setOpaque(false);
        jPanel_4.setBorder(BorderFactory.createTitledBorder("志愿者数据信息显示"));
        jPanel_4.setBounds(510, 450, 1300, 750);
        table();
        jScrollPane.setBounds(43, 50, 1300, 600);
        jScrollPane.setOpaque(false);
        //初始化第五个框的组件
        jPanel_5 = new javax.swing.JPanel();
        jPanel_5.setLayout(boxLayout);
        jPanel_5.setOpaque(false);
        jPanel_5.setBorder(BorderFactory.createTitledBorder("数据处理"));
        jPanel_5.setBounds(1820, 450, 520, 750);
        nc = new JLabel("活动名称");
        nc.setFont(fronts.sear);
        nc.setBounds(20, 130, 150, 45);
        nctext = new JTextField(9);
        nctext.setBounds(170, 130, 350, 45);
        stime = new JLabel("开始时间");
        stime.setFont(fronts.sear);
        stime.setBounds(20, 190, 150, 45);
        stimetext = new JTextField(9);
        stimetext.setBounds(170, 190, 350, 45);
        apply = new JLabel("报名人数");
        apply.setFont(fronts.sear);
        apply.setBounds(20, 250, 150, 45);
        applytext = new JTextField(9);
        applytext.setBounds(170, 250, 350, 45);
        demand = new JLabel("需求人数");
        demand.setFont(fronts.sear);
        demand.setBounds(20, 310, 150, 45);
        demandtext = new JTextField(9);
        demandtext.setBounds(170, 310, 350, 45);
        detail = new JLabel("活动介绍");
        detail.setFont(fronts.sear);
        detail.setBounds(20, 370, 150, 45);
        detailtext = new JTextField(9);
        detailtext.setBounds(170, 370, 350, 45);
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
        jPanel_3.add(one);
        jPanel_3.add(allt);
        jPanel_3.add(act);
        jPanel_3.add(acttext);
        jPanel_3.add(searchButton);
        jPanel_4.add(jScrollPane);
        jPanel_5.add(nc);
        jPanel_5.add(nctext);
        jPanel_5.add(stime);
        jPanel_5.add(stimetext);
        jPanel_5.add(apply);
        jPanel_5.add(applytext);
        jPanel_5.add(demand);
        jPanel_5.add(demandtext);
        jPanel_5.add(detail);
        jPanel_5.add(detailtext);
        this.add(jPanel_5);
        this.add(jPanel_4);
        this.add(jPanel_3);
        this.add(jPanel_2);
        this.add(jPanel_1);
        this.add(bgimg);
        allEvent();
        Event();
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

    void Event() {
        listener_2 = new InfoEvent();
        searchButton.addActionListener(listener_2);
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
        searchButton.setName("sea");
        sin.setName("sin");
    }

    void table() {
        table = getTable();
        jScrollPane = new JScrollPane(table);//添加一个浏览窗格
        jScrollPane.setPreferredSize(new Dimension(1400, 600));//给窗格设置大小
        table.setPreferredSize(new Dimension(1400, 1500));//给表格设置大小
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//将滑动组件显示在窗口中
    }

    JTable getTable() {
        if (table == null) {
            table = new JTable();//创建
            int[] columnWidth = {100, 100, 200, 100, 220, 200};//设置列宽
            table.setRowHeight(50);
            model = new DefaultTableModel() {
                public boolean isCellEditable(int rwo, int column) {
                    return false;
                }
            };//列宽和行数 并且让表格不可编辑
            model.setColumnIdentifiers(columns);
            table.setModel(model);//设置为表格的模式
            columnModel = table.getColumnModel();//获取到表格的控制
            table.getTableHeader().setResizingAllowed(false); // 设置表格不可调整列宽
            table.getTableHeader().setReorderingAllowed(false); // 设置表格列不可重新排列
            int count = columnModel.getColumnCount();//返回列数和行数
            for (int i = 0; i < count; i++) {
                TableColumn column = columnModel.getColumn(i);//返回列表中的对象
                column.setPreferredWidth(columnWidth[i]);
            }
            rwo = new Vector(8);
        }
        return table;
    }
}
