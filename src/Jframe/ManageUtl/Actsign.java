package Jframe.ManageUtl;

import Dao.ActTypeEvent;
import Front.Fronts;
import Dao.MenageEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
public class Actsign extends JFrame {
         private static DefaultTableModel tableModel;
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
        public static ButtonGroup group = null;//定义性别
        public static JRadioButton allt, one;//定义两个单选框
        public static JLabel act;//定义活动标签
        public static JTextField acttext;
        public static JButton searchButton;//定义查询按钮
        public static JButton addButton;
        public static JButton deleteButton;
        public static JLabel nc;
        public static JTextField nctext;
        public static JLabel nctype;
        public static JTextField nctypetext;
        JLabel footerLabel;
        JButton type;
        JButton activity;
        JButton notic;
        JButton personal;
        JLabel bgimg;
        JButton modifyButton;
        JButton volunteer;
        JButton first2;
        JButton actforms;
        JButton acttimes;
        // 定义一个面板
        JPanel contentPanel;
        //表格的数据
        Object columns[] = {"活动名称", "活动类型"};//标题信息
        JTable table = null;
        JScrollPane jScrollPane;
        public static Vector rwo;
        public static Object a[][];
        public static DefaultTableModel model;
        public static TableColumnModel columnModel;
        //定义一个监听
        ActionListener listener_1;
        ActionListener listener_2;
        public Actsign() {
            init();
            // 设置窗口标题
            setTitle("校园志愿者管理系统 - 活动分类");
            setVisible(true);//设置当前窗口是否显示
            setSize(2510, 1500);
            setResizable(false);//设置窗口不可以调节大小
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭方式
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
            allt.setFont(fronts.sear);
            allt.setContentAreaFilled(false);
            allt.setBounds(60, 70, 150, 45);
            group.add(allt);
            act = new JLabel("活动类别");
            act.setBounds(20, 120, 150, 50);
            //添加文本框
            acttext = new JTextField(15);
            acttext.setBounds(20, 180, 260, 50);
            //添加按钮
            searchButton = new JButton("查询数据");
            searchButton.setBounds(40, 260, 210, 50);
            addButton = new JButton("添加数据");
            addButton.setBounds(40, 330, 210, 50);
            modifyButton = new JButton("修改数据");
            modifyButton.setBounds(40, 400, 210, 50);
            deleteButton = new JButton("删除数据");
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
            nctype = new JLabel("活动类型");
            nctype.setFont(fronts.sear);
            nctype.setBounds(20,90,150,45);
            nctypetext = new JTextField(9);
            nctypetext.setBounds(170,90,350,45);
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
                jPanel_3.add(modifyButton);
                jPanel_3.add(addButton);
                jPanel_3.add(deleteButton);
                jPanel_4.add(jScrollPane);
                jPanel_5.add(nc);
                jPanel_5.add(nctext);
                jPanel_5.add(nctype);
                jPanel_5.add(nctypetext);
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
        listener_2 = new ActTypeEvent();
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
        activity.setName("acts");
        notic.setName("not");
        personal.setName("per");
        searchButton.setName("search");
        addButton.setName("add");
        deleteButton.setName("del");
        modifyButton.setName("gai");
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
    public class ModifyButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // 弹出修改框
                        JFrame modifyFrame = new JFrame("修改活动信息");
                        modifyFrame.setSize(300, 200);
                        modifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        modifyFrame.setLocationRelativeTo(null);
                        // 创建标签和按钮
                        JLabel activityNameLabel = new JLabel((String) tableModel.getValueAt(selectedRow, 1));
                        JButton updateButton = new JButton("更新活动名称");
                        updateButton.addActionListener(new UpdateButtonListener(selectedRow, activityNameLabel));
                        // 添加组件到修改框
                        JPanel panel = new JPanel();
                        panel.add(activityNameLabel);
                        panel.add(updateButton);
                        modifyFrame.add(panel);
                        modifyFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "请选择要修改的活动");
                    }
                }
            }
            private class UpdateButtonListener implements ActionListener {
                private int row;
                private JLabel activityNameLabel;
                public UpdateButtonListener(int row, JLabel activityNameLabel) {
                    this.row = row;
                    this.activityNameLabel = activityNameLabel;
                }
                @Override
                public void actionPerformed(ActionEvent e) {
                    String newActivityName = JOptionPane.showInputDialog("输入新的活动名称");
                    if (newActivityName != null && !newActivityName.isEmpty()) {
                        tableModel.setValueAt(newActivityName, row, 1);
                        activityNameLabel.setText(newActivityName);
                        JOptionPane.showMessageDialog(null, "活动信息已更新");
                    }
                }
            }
    }
