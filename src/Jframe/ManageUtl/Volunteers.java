package Jframe.ManageUtl;

import Dao.MenageEvent;
import Front.Fronts;
import Dao.LogiEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Volunteers extends JFrame {
    //定义一个布局
    FlowLayout flowlayout;
    BoxLayout boxLayout;
    JLabel footerLabel;
    //窗口变量
    final int WIDTH = 2510;//设置顶层框架的宽度
    final int HEIGHT = 1600;//设置顶层框架高度
    //定义按钮和标签
    JLabel bgimg;//定义背景标签
    JLabel title;//定义标题标签
    //定义菜单栏
    JMenuBar jMenuBar;//定义一个菜单条
    JMenu jMenu;//定义一个菜单
    JMenu jMenu1;
    JMenu jMenu2;
    JMenuItem item1,item2,item3,item4;
    JMenuItem item1_1,item1_2;
    JMenuItem item2_1,item2_2;
    //定义一个盒子
    javax.swing.JPanel jPanel_1;//放置图片和其他的盒子
    javax.swing.JPanel jPanel_2;//放置表格
    javax.swing.JPanel jPanel_3;
    javax.swing.JPanel jPanel_4;
    javax.swing.JPanel jPanel_5;
    //定义标签
    public static JButton first2;
    public static JButton volunteer;
    public static JButton actforms;
    public static JButton acttimes;
    public static JButton type;
    public static JButton activities;
    public static JButton notic;
    public static JButton personal;
    public static JLabel name;
    public static JTextField nametext;
    public static ButtonGroup group = null;//定义性别
    public static JRadioButton Men,Women,allsex;//定义两个单选框
    public static JLabel age;
    public static JTextField agetext;
    public static JLabel year;
    public static JTextField yeartext;
    public static JLabel home;
    public static JTextField hometext;
    public static JLabel classs;
    public static JTextField classstext;
    //定义按钮
    JButton add;//增加
    JButton del;//删除
    JButton change;//修改
    JButton show;//查找
    JButton reset;//重置
    private static JLabel numbercondition;//志愿者编号条件
    public static JTextField numbeconditiontext;//志愿者编号条件文本
    public static JTextArea resultText;//显示结果
    //表格的数据
    Object columns[] = {"姓名","性别","年龄","服务年限","志愿者编号","住址"};//标题信息
    JTable table = null;
    JScrollPane jScrollPane;
    static Vector rwo;
    static Object a[][];
    public static DefaultTableModel model;
    private static TableColumnModel columnModel;
    // 定义一个面板
    JPanel contentPanel;
    //定义一个监听
    ActionListener listener_1;
    ActionListener listener_2;
    public Volunteers() {
        init();
        setVisible(true);//设置当前窗口是否显示
        setSize(2510,1500);
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
        this.setBounds(0, 0, WIDTH, HEIGHT);
        //设置布局为空
        this.setLayout(null);
        // 设置窗口标题
        setTitle("校园志愿者管理员--志愿者管理界面");
        //初始化字体类
        Fronts fronts = new Fronts();

        //添加菜单栏
        jMenuBar = new JMenuBar();//构造菜单条
        jMenu = new JMenu("管理");
        jMenu1 = new JMenu("活动管理");
        jMenu2 = new JMenu("个人设置");
        item1 = new JMenuItem("查看在线人数",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img.png"));
        item2 = new JMenuItem("查看所以账号",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_1.png"));
        item3 = new JMenuItem("更改志愿者账号信息",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_2.png"));
        item4 = new JMenuItem("更改密码",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_3.png"));
        item1_1 = new JMenuItem("活动信息",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_2.png"));
        item1_2 = new JMenuItem("报名情况审核",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_3.png"));
        item2_1 = new JMenuItem("密码修改",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_4.png"));
        item2_2 = new JMenuItem("注销",new ImageIcon("C:\\code\\Volunteer\\image\\ManagementSystem\\img_5.png"));

        //添加组件
        jMenu.add(item1);
        jMenu.add(item2);
        jMenu.add(item3);
        jMenu.add(item4);
        jMenu1.add(item1_1);
        jMenu1.add(item1_2);
        jMenu2.add(item2_1);
        jMenu2.add(item2_2);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        // 添加图片
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\3.jpg");
        Image image = icon.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(2450, 1500, java.awt.Image.SCALE_SMOOTH); // 缩放图片
        icon = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(icon);
        bgimg.setBounds(20, 10, 2450, 1500); // 设置背景图片的位置和大小
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
        jPanel_3.setBorder(BorderFactory.createTitledBorder("搜索框"));
        jPanel_3.setBounds(20, 450, 310, 750);
        //添加按钮
        group = new ButtonGroup();
        Men = new JRadioButton("男");
        Men.setFont(fronts.sear);
        Men.setContentAreaFilled(false);
        Men.setBounds(60, 20, 150, 45);
        Women = new JRadioButton("女");
        Women.setFont(fronts.sear);
        Women.setContentAreaFilled(false);
        Women.setBounds(60, 70, 150, 45);
        group.add(Men);
        group.add(Women);
        allsex = new JRadioButton("全部信息");
        allsex.setContentAreaFilled(false);
        allsex.setFont(fronts.sear);
        allsex.setBounds(60, 120, 150, 45);
        group.add(allsex);
        numbercondition = new JLabel("【志愿者编号】");
        numbercondition.setBounds(20, 180, 300, 50);
        //添加文本框
        numbeconditiontext = new JTextField(15);
        numbeconditiontext.setBounds(20, 240, 260, 50);
        //添加按钮
        show = new JButton("查询数据");
        show.setContentAreaFilled(false);
        show.setBounds(40, 300, 210, 50);
        add = new JButton("添加数据");
        add.setContentAreaFilled(false);
        add.setBounds(40, 370, 210, 50);
        change = new JButton("修改数据");
        change.setContentAreaFilled(false);
        change.setBounds(40, 440, 210, 50);
        del = new JButton("删除数据");
        del.setContentAreaFilled(false);
        del.setBounds(40, 510, 210, 50);
        reset = new JButton("重置数据");
        reset.setContentAreaFilled(false);
        reset.setBounds(40, 580, 210, 50);
        //初始化第四个框的组件
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4.setLayout(boxLayout);
        jPanel_4.setOpaque(false);
        jPanel_4.setBorder(BorderFactory.createTitledBorder("志愿者数据信息显示"));
        jPanel_4.setBounds(320, 450, 1500, 750);
        table();
        jScrollPane.setBounds(43, 50, 1400, 350);
        //添加显示结果
        resultText = new JTextArea();
        resultText.setBorder(BorderFactory.createTitledBorder("账号信息显示"));
        resultText.setEditable(false);
        resultText.setFont(fronts.sear);
        resultText.setBounds(43,400,1400,350);
        // 创建第五个盒子（活动公告）
        jPanel_5 = new javax.swing.JPanel();
        jPanel_5.setLayout(boxLayout);
        jPanel_5.setOpaque(false);
        jPanel_5.setBorder(BorderFactory.createTitledBorder("活动信息"));
        jPanel_5.setBounds(1820, 450, 600, 750);
        name = new JLabel("姓名");
        name.setFont(fronts.sear);
        name.setBounds(20,30,150,45);
        nametext = new JTextField(9);
        nametext.setBounds(170,30,350,45);
        age = new JLabel("年龄");
        age.setFont(fronts.sear);
        age.setBounds(20,90,150,45);
        agetext = new JTextField(9);
        agetext.setBounds(170,90,350,45);
        year = new JLabel("年限");
        year .setFont(fronts.sear);
        year .setBounds(20,150,150,45);
        yeartext = new JTextField(9);
        yeartext.setBounds(170,150,350,45);
        classs = new JLabel("志愿者编号");
        classs.setFont(fronts.sear);
        classs.setBounds(20,210,150,45);
        classstext = new JTextField(9);
        classstext.setBounds(170,210,350,45);
        home = new JLabel("住址");
        home.setFont(fronts.sear);
        home.setBounds(20,270,150,45);
        hometext = new JTextField(9);
        hometext.setBounds(170,270,350,45);
        //
        jPanel_1.add(footerLabel);
        jPanel_2.add(first2);
        jPanel_2.add(volunteer);
        jPanel_2.add(activities);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(actforms);
        jPanel_2.add(acttimes);
        jPanel_2.add(personal);
        jPanel_3.add(Men);
        jPanel_3.add(Women);
        jPanel_3.add(allsex);
        jPanel_3.add(numbercondition);
        jPanel_3.add(numbeconditiontext);
        jPanel_3.add(add);
        jPanel_3.add(del);
        jPanel_3.add(change);
        jPanel_3.add(show);
        jPanel_3.add(reset);
        jPanel_4.add(jScrollPane);
        jPanel_4.add(resultText);
        jPanel_5.add(name);
        jPanel_5.add(nametext);
        jPanel_5.add(age);
        jPanel_5.add(agetext);
        jPanel_5.add(year);
        jPanel_5.add(yeartext);
        jPanel_5.add(classs);
        jPanel_5.add(classstext);
        jPanel_5.add(home);
        jPanel_5.add(hometext);
        this.add(jPanel_5);
        this.add(jPanel_4);
        this.add(jPanel_3);
        this.add(jPanel_2);
        this.add(jPanel_1);
        this.add(bgimg);
        this.add(jMenuBar);
        this.setJMenuBar(jMenuBar);
        allEvent();
        Event();
        setAllName();

    }

    void table(){
        table = getTable();
        jScrollPane = new JScrollPane(table);//添加一个浏览窗格
        jScrollPane.setPreferredSize(new Dimension(1500,400));//给窗格设置大小
        table.setPreferredSize(new Dimension(1500,900));//给表格设置大小
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//将滑动组件显示在窗口中
    }

    JTable getTable() {
        if(table == null) {
            table = new JTable();//创建
            int[] columnWidth={120,150,100,100,200,100,220,200};//设置列宽
            table.setRowHeight(50);
            model = new DefaultTableModel(){
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
            for(int i = 0;i<count;i++){
                TableColumn column = columnModel.getColumn(i);//返回列表中的对象
                column.setPreferredWidth(columnWidth[i]);
            }
            rwo = new Vector(8);
        }
        return table;
    }

    void allEvent() {
        listener_1 = new LogiEvent();
        item1.addActionListener(listener_1);
        item2.addActionListener(listener_1);
        item3.addActionListener(listener_1);
        item4.addActionListener(listener_1);
        add.addActionListener(listener_1);
        del.addActionListener(listener_1);
        change.addActionListener(listener_1);
        show.addActionListener(listener_1);
        reset.addActionListener(listener_1);
    }
        void Event(){
        listener_2 = new MenageEvent();
        first2.addActionListener(listener_2);
        volunteer.addActionListener(listener_2);
        actforms.addActionListener(listener_2);
        acttimes.addActionListener(listener_2);
        type.addActionListener(listener_2);
        activities.addActionListener(listener_2);
        notic.addActionListener(listener_2);
        personal.addActionListener(listener_2);

    }


    void setAllName(){
        item1.setName("item1");
        item2.setName("item2");
        item3.setName("item3");
        item4.setName("item4");
        add.setName("add");
        del.setName("del");
        change.setName("gai");
        show.setName("show");
        reset.setName("reset");
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
