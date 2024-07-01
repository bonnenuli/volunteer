package Jframe.ManageUtl;

import Dao.ActInofEvent;
import Dao.ActtimeEvent;
import Front.Fronts;
import Dao.MenageEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;
public class Acttime extends JFrame {
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
        javax.swing.JPanel jPanel_4;//放置首页按钮
        javax.swing.JPanel jPanel_5;//放置基本信息
        //定义标签
        JLabel footerLabel;
        private static JButton first2;
        private static JButton type;
        private static JButton activity;
        private static JButton volunteer;
        private static JButton notic;
        private static JButton acttimes;
        private static JButton actforms;
        private static JButton personal;
        public static JLabel name;
        public static JTextField nametext;
        public static ButtonGroup group = null;//定义性别
        public static JRadioButton allt,one;//定义两个单选框
        public static JLabel classs;
        public static JTextField classstext;
        public static JLabel nc;
        public static JTextField nctext;
        public static JLabel time;
        public static JTextField timetext;
        public static JLabel act;//定义活动标签
        public static JTextField acttext;
        private static JButton searchButton;//定义查询按钮
        private static JButton addButton;
        private static JButton modifyButton;
        JLabel bgimg;
        // 定义一个面板
        JPanel contentPanel;
        //表格的数据
        Object columns[] = {"志愿者编号", "姓名","活动名称", "活动时长（h）"};//标题信息
        JTable table = null;
        JScrollPane jScrollPane;
        public static Vector rwo;
        public static Object a[][];
        public static DefaultTableModel model;
        private static TableColumnModel columnModel;
        //定义一个监听
        ActionListener listener_1;
        ActionListener listener_2;
        private DefaultTableModel tableModel;
    public Acttime() {
            init();
            // 设置窗口标题
            setTitle("校园志愿者管理系统 - 活动时长");
            setVisible(true);//设置当前窗口是否显示
            setSize(2510, 1500);
            setResizable(false);//设置窗口不可以调节大小
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置默认关闭方式
            setLocationRelativeTo(null); // 设置窗口居中
            validate();//让组件生效
        }
        public void init() {
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
            jPanel_1.setBackground(new Color(102, 224, 224, 128));
            jPanel_1.setBounds(20, 10, 2450, 190);
            // 添加页尾组件
            footerLabel = new JLabel("欢迎来到校园志愿者管理系统", JLabel.CENTER);
            footerLabel.setFont(fronts.yt);
            footerLabel.setBackground(new Color(8, 189, 252));
            footerLabel.setBounds(800, 50, 900, 70);
            footerLabel.setForeground(new Color(100, 149, 237));
            // 添加图片
            ImageIcon icon = new ImageIcon("C:\\code\\Volunteer\\image\\Volunteer\\3.jpg");
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
            activity = new JButton("活动管理");
            activity.setFont(fronts.username);
            activity.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//将光标设为小手形状
            activity.setBorder(null);//设置此组件的无边框
            activity.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框（凸）
            activity.setForeground(new Color(23, 153, 234));
            activity.setBackground(Color.cyan);
            activity.setBounds(700, 10, 180, 70);
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
            act = new JLabel("活动名称");
            act.setBounds(20, 120, 150, 50);
            //添加文本框
            acttext = new JTextField(15);
            acttext.setBounds(20, 180, 260, 50);
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
            //添加文本框
            nc = new JLabel("活动名称");
            nc.setFont(fronts.sear);
            nc.setBounds(20,30,150,45);
            nctext = new JTextField(9);
            nctext.setBounds(170,30,350,45);
            classs = new JLabel("志愿者编号");
            classs.setFont(fronts.sear);
            classs.setBounds(20,90,150,45);
            classstext = new JTextField(9);
            classstext.setBounds(170,90,350,45);
            name = new JLabel("姓名");
            name .setFont(fronts.sear);
            name .setBounds(20,150,150,45);
            nametext = new JTextField(9);
            nametext.setBounds(170,150,350,45);
            time = new JLabel("志愿时长");
            time.setFont(fronts.sear);
            time.setBounds(20,210,150,45);
            timetext = new JTextField(9);
            timetext.setBounds(170,210,350,45);
            // 添加第五个框到内容面板
            contentPanel.add(jPanel_4);
            //添加按钮
            jPanel_1.add(footerLabel);
            jPanel_2.add(first2);
            jPanel_2.add(volunteer);
            jPanel_2.add(activity);
            jPanel_2.add(type);
            jPanel_2.add(notic);
            jPanel_2.add(actforms);
            jPanel_2.add(acttimes);
            jPanel_2.add(personal);
            jPanel_3.add(one);
            jPanel_3.add(allt);
            jPanel_3.add(act);
            jPanel_3.add(acttext);
            jPanel_3.add(searchButton);
            jPanel_3.add(addButton);
            jPanel_3.add(modifyButton);
            jPanel_4.add(jScrollPane);
            jPanel_5.add(name);
            jPanel_5.add(nametext);
            jPanel_5.add(classs);
            jPanel_5.add(classstext);
            jPanel_5.add(nc);
            jPanel_5.add(nctext);
            jPanel_5.add(time);
            jPanel_5.add(timetext);
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
        activity.addActionListener(listener_1);
        notic.addActionListener(listener_1);
        personal.addActionListener(listener_1);
    }
    void Event(){
        listener_2 = new ActtimeEvent();
        searchButton.addActionListener(listener_2);
        modifyButton.addActionListener(listener_2);
        addButton.addActionListener(listener_2);
    }
    void setAllName() {
        first2.setName("zhu");
        volunteer.setName("vol");
        actforms.setName("apply");
        acttimes.setName("time");
        type.setName("type");
        activity.setName("acts");
        notic.setName("not");
        personal.setName("per");
        searchButton.setName("search");
        addButton.setName("addt");
        modifyButton.setName("gai");
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
            int[] columnWidth={200,200,220,200};//设置列宽
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
}

