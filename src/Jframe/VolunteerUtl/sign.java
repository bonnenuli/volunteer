package Jframe.VolunteerUtl;

import Dao.VolEvent;
import Front.Fronts;
import utils.MainFrame;
import View.VolunteerSign;
import utils.Camera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class sign extends JFrame {
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
        //定义标签
        JLabel footerLabel;
        JButton first1,sin,type,activity,actform,notic,news,message,personal;
        JLabel bgimg;
        // 定义一个面板
        JPanel contentPanel;
        private MainFrame parent;
        private JToggleButton daka;
        private JTextArea area;
        private JPanel center;
        private VolunteerSign code;
        private DetectFaceThread detectFaceThread;
        //定义一个监听
        ActionListener listener_1;
        public sign() {
            this.parent = parent;
            init();
            // 设置窗口标题
            setTitle("校园志愿者管理系统 - 活动签到");
            setVisible(true);//设置当前窗口是否显示
            setSize(2510, 1500);
            setResizable(false);//设置窗口不可以调节大小
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置默认关闭方式
            setLocationRelativeTo(null); // 设置窗口居中
            validate();//让组件生效
            addListener();
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
            jPanel_3.setBorder(BorderFactory.createTitledBorder(""));
            jPanel_3.setBounds(350, 540, 1650, 750);
            area = new JTextArea();
            area.setEditable(false);
            area.setFont(new Font("宋体", Font.BOLD, 32));
            JScrollPane scrollPane = new JScrollPane(area);
            scrollPane.setBounds(100, 92, 660, 450);
            daka = new JToggleButton("签到打卡");
            daka.setFont(new Font("宋体", Font.BOLD, 40));
            daka.setForeground(new Color(23, 153, 234));
            daka.setBackground(Color.cyan);
            daka.setBounds(580, 600, 550, 120);
            JPanel blackPanel = new JPanel();
            blackPanel.setBounds(952, 92, 660, 450);
            blackPanel.setBackground(Color.BLACK);
            setLayout(new BorderLayout());

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
            jPanel_3.add(scrollPane);
            jPanel_3.add(daka);
            jPanel_3.add(blackPanel);
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
            sin.addActionListener(listener_1);
        }

        void setAllName(){
            first1.setName("first");
            type.setName("type");
            activity.setName("act");
            actform.setName("form");
            notic.setName("notic");
            news.setName("new");
            message.setName("message");
            personal.setName("per");
            sin.setName("sin");
        }
    private void addListener() {
        daka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (daka.isSelected()) {
                    area.append("正在开启摄像头，请稍后。。。\n");
                    daka.setEnabled(false);
                    daka.setText("关闭摄像头");
                    Thread cameraThread = new Thread()
                    {
                        public void run()
                        {
                            if (Camera.startCamera())
                            {
                                area.append("请面向摄像头打卡。\n");
                                daka.setEnabled(true);
                                JPanel cameraPanel = Camera.getCameraPanel();
                                cameraPanel.setBounds(952, 92, 660, 450);
                                jPanel_3.add(cameraPanel);
                            }else
                            {
                                JOptionPane.showMessageDialog(parent,"未检测到摄像头！\n");
                                releaseCamera();
                                return;
                            }
                        }
                    };
                    cameraThread.start();
                    detectFaceThread = new sign.DetectFaceThread();
                    detectFaceThread.start();
                } else {
                    releaseCamera();
                }
            }
        });
    }

    private void releaseCamera() {
        Camera.releaseCamera();
        area.append("摄像头已关闭\n");
        if (detectFaceThread!=null){detectFaceThread.stop();}
        daka.setText("打   卡");
        daka.setSelected(false);
        daka.setEnabled(true);
    }

    private class DetectFaceThread extends Thread {
        boolean work = true;
        public void run() {
            while (work) {
                if (Camera.cameraIsOpen()) {
                    BufferedImage frame = Camera.getCameraFrame();
                    if (frame != null && code != null) {
                        VolunteerSign v = VolunteerSign.getEmp(code);
                        VolunteerSign.addClockInRecord(v);
                        area.append(v.getName() + "打卡成功\n");
                        releaseCamera();
                    }
                }
            }
        }
    }

    public synchronized void stop() {
        if (detectFaceThread != null) {
            detectFaceThread.work = false;
            detectFaceThread = null;
        }
    }
}
