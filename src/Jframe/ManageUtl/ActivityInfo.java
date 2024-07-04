package Jframe.ManageUtl;

import Dao.ActInofEvent;
import Front.Fronts;
import Dao.MenageEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ActivityInfo extends JFrame {
    // 定义布局
    BoxLayout boxLayout;
    JLabel bgimg;
    public static JTextField searchField;
    public static JComboBox<String> typeComboBox;
    public static JTable activityTable;
    public static JTextArea announcementArea;
    //定义一个盒子
    javax.swing.JPanel jPanel_1;//放置全部界面和背景图片
    javax.swing.JPanel jPanel_2;//放置页尾标签
    javax.swing.JPanel jPanel_3;//放置公告信息
    javax.swing.JPanel jPanel_4;
    javax.swing.JPanel jPanel_5;
    JLabel footerLabel;
    public static ButtonGroup group = null;//定义性别
    public static JRadioButton allt, one;//定义两个单选框
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
    public static JLabel nc;
    public static JTextField nctext;
    public static JLabel stime;
    public static JTextField stimetext;
    public static JLabel apply;
    public static JTextField applytext;
    public static JLabel demand;
    public static JTextField demandtext;
    public static JLabel rtime;
    public static JTextField rtimetext;
    public static JLabel detail;
    public static JTextField detailtext;
    //表格的数据
    Object columns[] = {"活动名称", "开始时间", "报名人数", "需求人数", "发布时间", "活动介绍"};//标题信息
    JTable table = null;
    JScrollPane jScrollPane;
    public static Vector rwo;
    public static Object a[][];
    public static DefaultTableModel model;
    public static TableColumnModel columnModel;
    // 创建内容面板
    JPanel contentPanel = new JPanel(new BorderLayout());
    //定义一个监听
    ActionListener listener_1;
    ActionListener listener_2;
    public ActivityInfo() {
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
        setTitle("校园志愿者管理员--活动信息管理界面");
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
        footerLabel.setBackground(new Color(8, 189, 252));
        footerLabel.setBounds(800, 50, 900, 70);
        footerLabel.setForeground(Color.white);
        // 添加图片
        ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\3.jpg");
        Image image = icon.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(2450, 1500, java.awt.Image.SCALE_SMOOTH); // 缩放图片
        icon = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(icon);
        bgimg.setBounds(20, 10, 2450, 1500); // 设置背景图片的位置和大小
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
        one = new JRadioButton("单个信息");
        one.setFont(fronts.sear);
        one.setContentAreaFilled(false);
        one.setBounds(60, 20, 150, 45);
        group.add(one);
        allt = new JRadioButton("全部信息");
        allt.setContentAreaFilled(false);
        allt.setFont(fronts.sear);
        allt.setBounds(60, 70, 150, 45);
        group.add(allt);
        activity = new JLabel("活动名称");
        activity.setBounds(20, 120, 150, 50);
        //添加文本框
        activitytext = new JTextField(15);
        activitytext.setBounds(20, 180, 260, 50);
        //添加按钮
        searchButton = new JButton("查询数据");
        searchButton.setContentAreaFilled(false);
        searchButton.setBounds(40, 260, 210, 50);
        addButton = new JButton("添加数据");
        addButton.setContentAreaFilled(false);
        addButton.setBounds(40, 330, 210, 50);
        modifyButton = new JButton("修改数据");
        modifyButton.setContentAreaFilled(false);
        modifyButton.setBounds(40, 400, 210, 50);
        deleteButton = new JButton("删除数据");
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBounds(40, 470, 210, 50);

        //初始化第四个框的组件
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4.setLayout(boxLayout);
        jPanel_4.setOpaque(false);
        jPanel_4.setBorder(BorderFactory.createTitledBorder("志愿者数据信息显示"));
        jPanel_4.setBounds(320, 450, 1500, 750);
        table();
        jScrollPane.setBounds(43, 50, 1400, 700);

        // 创建第五个盒子（活动公告）
        jPanel_5 = new javax.swing.JPanel();
        jPanel_5.setLayout(boxLayout);
        jPanel_5.setOpaque(false);
        jPanel_5.setBorder(BorderFactory.createTitledBorder("活动信息"));
        jPanel_5.setBounds(1820, 450, 600, 750);
        nc = new JLabel("活动名称");
        nc.setFont(fronts.sear);
        nc.setBounds(20,30,150,45);
        nctext = new JTextField(9);
        nctext.setBounds(170,30,350,45);
        stime = new JLabel("开始时间");
        stime.setFont(fronts.sear);
        stime.setBounds(20,90,150,45);
        stimetext = new JTextField(9);
        stimetext.setBounds(170,90,350,45);
        apply = new JLabel("报名人数");
        apply .setFont(fronts.sear);
        apply .setBounds(20,150,150,45);
        applytext = new JTextField(9);
        applytext.setBounds(170,150,350,45);
        demand = new JLabel("需求人数");
        demand.setFont(fronts.sear);
        demand.setBounds(20,210,150,45);
        demandtext = new JTextField(9);
        demandtext.setBounds(170,210,350,45);
        rtime = new JLabel("发布时间");
        rtime.setFont(fronts.sear);
        rtime.setBounds(20,270,150,45);
        rtimetext = new JTextField(9);
        rtimetext.setBounds(170,270,350,45);
        detail = new JLabel("活动介绍");
        detail.setFont(fronts.sear);
        detail.setBounds(20,330,150,45);
        detailtext = new JTextField(9);
        detailtext.setBounds(20,390,500,300);
        jPanel_1.add(footerLabel);
        jPanel_2.add(first2);
        jPanel_2.add(volunteer);
        jPanel_2.add(activities);
        jPanel_2.add(type);
        jPanel_2.add(notic);
        jPanel_2.add(actforms);
        jPanel_2.add(acttimes);
        jPanel_2.add(personal);
        jPanel_3.add(one);
        jPanel_3.add(allt);
        jPanel_3.add(activity);
        jPanel_3.add(activitytext);
        jPanel_3.add(searchButton);
        jPanel_3.add(addButton);
        jPanel_3.add(modifyButton);
        jPanel_3.add(deleteButton);
        jPanel_4.add(jScrollPane);
        jPanel_5.add(nc);
        jPanel_5.add(nctext);
        jPanel_5.add(stime);
        jPanel_5.add(stimetext);
        jPanel_5.add(apply);
        jPanel_5.add(applytext);
        jPanel_5.add(demand);
        jPanel_5.add(demandtext);
        jPanel_5.add(rtime);
        jPanel_5.add(rtimetext);
        jPanel_5.add(detail);
        jPanel_5.add(detailtext);

        // 将三个盒子添加到主面板
        contentPanel.add(jPanel_5);
        contentPanel.add(jPanel_4);
        contentPanel.add(jPanel_3);
        contentPanel.add(jPanel_2);
        contentPanel.add(jPanel_1);
        contentPanel.add(bgimg);
        setVisible(true);
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
    }
void Event(){
        listener_2 = new ActInofEvent();
        searchButton.addActionListener(listener_2);
        deleteButton.addActionListener(listener_2);
        modifyButton.addActionListener(listener_2);
        addButton.addActionListener(listener_2);
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
        searchButton.setName("searchi");
        addButton.setName("addi");
        deleteButton.setName("deli");
        modifyButton.setName("gaii");

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
