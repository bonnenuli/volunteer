package View;

import Front.Fronts;
import Dao.AccountEvents;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Register extends JFrame {
    //定义一个布局
    FlowLayout flowlayout;
    //窗口变量
    final int WIDTH = 1600;//设置顶层框架的宽度
    final int HEIGHT = 900;//设置顶层框架高度
    //定义按钮和标签
    JLabel bgimg;//定义背景标签
    JLabel title;//定义标题标签
    JLabel name;//定义姓名标签
    public static JTextField nametext;//输入姓名文本
    JLabel namesatisfy;//满足条件就可以
    JLabel account;//定义账户标签
    public static JTextField accounttext;//定义账户文本
    JLabel accountsatisfy;//定义账户条件
    JLabel password;//定义密码标签
    public static JPasswordField passwordtext;//输入密码框
    JLabel passwordsatisfy;//定义密码条件
    JLabel okpassword;//定义密码标签
    public static JPasswordField okpasswordtext;//输入密码框
    JLabel okpasswordsatisfy;//定义密码条件
    public static JButton reg;//注册按钮
    public static JButton exitButton;//退出按钮
    public static JButton fan;
    // 定义一个面板
    JPanel contentPanel;
    private AccountEvents lintener_1;
    public Register() {
        init();
        setVisible(true);//设置当前窗口是否显示
        setSize(1600,900);
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
        this.setBounds(0, 0, WIDTH, HEIGHT);
        //设置布局为空
        this.setLayout(null);
        // 设置背景图片
        ImageIcon img = new ImageIcon("C:\\code\\Volunteer\\image\\Register\\2.jpg"); // 将图片读取到img变量里面
        Image image = img.getImage(); // 转换为Image对象
        Image newimg = image.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH); // 缩放图片
        img = new ImageIcon(newimg); // 转换回ImageIcon对象
        bgimg = new JLabel(img);
        bgimg.setBounds(0, 0, WIDTH, HEIGHT); // 设置背景图片的位置和大小
        //设置一个标题
        Fronts fronts = new Fronts();
        title = new JLabel("校园志愿者管理系统账号注册");
        title.setFont(fronts.title);
        title.setForeground(Color.gray);
        title.setBounds(550,30,1000,200);
        fan = new JButton("返   回");
        fan.setBounds(320,670,150,40);
        fan.setFocusPainted(false);//去掉按钮周围的焦点框
        fan.setContentAreaFilled(false);//设置按钮透明背景
        fan.setFont(new Font("微软雅黑", Font.BOLD, 30));
        fan.setBackground(new Color(255, 153, 41));
        fan.setForeground(Color.black);
        fan.addActionListener(arg0 -> {
            new Login();
        });
        //对姓名相关标签初始化
        name = new JLabel(" 姓    名");
        name.setBounds(500,240,200,35);
        name.setFont(fronts.username);
        nametext = new JTextField(15);
        nametext.setBounds(650,240,300,40);
        nametext.setFont(fronts.usernametext);
        namesatisfy = new JLabel("请输入姓名");
        namesatisfy.setForeground(Color.GRAY);
        namesatisfy.setFont(fronts.remind);
        namesatisfy.setBounds(970,240,200,30);
        //对账号相关标签初始化
        account = new JLabel(" 账    号");
        account.setBounds(500,340,200,35);
        account.setFont(fronts.username);
        accounttext = new JTextField(15);
        accounttext.setBounds(650,340,300,40);
        accounttext.setFont(fronts.usernametext);
        accountsatisfy = new JLabel("请输入6到10位英文字母");
        accountsatisfy.setForeground(Color.gray);
        accountsatisfy.setBounds(970,340,300,30);
        accountsatisfy.setFont(fronts.remind);
        //对密码相关标签初始化
        password = new JLabel(" 密    码");
        password.setBounds(500,440,200,35);
        password.setFont(fronts.username);
        passwordtext = new JPasswordField(15);
        passwordtext.setBounds(650,440,300,40);
        passwordtext.setFont(fronts.usernametext);
        passwordsatisfy = new JLabel("请输入8位英文或数字");
        passwordsatisfy.setForeground(Color.gray);
        passwordsatisfy.setBounds(970,440,300,30);
        passwordsatisfy.setFont(fronts.remind);
        //对确认密码相关标签初始化
        okpassword = new JLabel("确认密码");
        okpassword.setBounds(500,540,200,35);
        okpassword.setFont(fronts.username);
        okpasswordtext = new JPasswordField(15);
        okpasswordtext.setBounds(650,540,300,40);
        okpasswordtext.setFont(fronts.usernametext);
        okpasswordsatisfy = new JLabel("请输入8位英文或数字");
        okpasswordsatisfy.setForeground(Color.gray);
        okpasswordsatisfy.setBounds(970,540,300,30);
        okpasswordsatisfy.setFont(fronts.remind);
        //注册按钮
        reg = new JButton("注   册");
        reg.setBounds(550,670,240,40);
        reg.setFocusPainted(false);//去掉按钮周围的焦点框
        reg.setContentAreaFilled(false);//设置按钮透明背景
        reg.setFont(new Font("微软雅黑", Font.BOLD, 30));
        reg.setBackground(new Color(255, 153, 41));
        reg.setForeground(new Color(203, 137, 101));
        //退出按钮
        exitButton = new JButton("退出系统");
        exitButton.setBounds(800, 670, 240, 40);
        exitButton.setFocusPainted(false);//去掉按钮周围的焦点框
        exitButton.setContentAreaFilled(false);//设置按钮透明背景
        exitButton.setFont(new Font("微软雅黑", Font.BOLD, 30));
	    exitButton.setBackground(new Color(255, 153, 41));
        exitButton.setForeground(new Color(203, 137, 101));
        exitButton.setName("tc");
        exitButton.addActionListener(arg0 -> {
           int result = JOptionPane.showConfirmDialog(null,"您现在要关闭系统吗?关闭后同时注销账号!","退出提示",0,1);
           if(result == JOptionPane.OK_OPTION){
                JOptionPane.showMessageDialog(null, "已退出系统，欢迎下次使用！");
                System.exit(0);
            }
        });
        //添加组件
        this.add(fan);
        this.add(name);
        this.add(nametext);
        this.add(namesatisfy);
        this.add(account);
        this.add(accounttext);
        this.add(accountsatisfy);
        this.add(password);
        this.add(passwordtext);
        this.add(passwordsatisfy);
        this.add(okpassword);
        this.add(okpasswordtext);
        this.add(okpasswordsatisfy);
        this.add(reg);
        this.add(exitButton);
        this.add(title);
        this.add(bgimg);
        setAllTag();
        allEvent();
    }

    void allEvent(){
        lintener_1 = new AccountEvents();
        nametext.addActionListener(lintener_1);
        accounttext.addActionListener(lintener_1);
        passwordtext.addActionListener(lintener_1);
        okpasswordtext.addActionListener(lintener_1);
        reg.addActionListener(lintener_1);
        exitButton.addActionListener(lintener_1);
    }

    void setAllTag(){
        nametext.setName("nametext");//定义姓名
        accounttext.setName("accounttext");//定义账户
        passwordtext.setName("passwordtext");//定义密码文本框
        okpasswordtext.setName("okpasswordtext");//定义确认密码文本框
        reg.setName("reg");
    }
}