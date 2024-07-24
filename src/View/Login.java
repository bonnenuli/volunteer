package View;

import Front.Fronts;
import Dao.LogiEvent;
import Dao.RegEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    //定义一个布局
    FlowLayout flowlayout;
    public JLabel account;//定义账户标签
    public JLabel password;//定义密码标签
    public static JLabel role;//定义权限
    public static JComboBox<String> comboBox;
    JLabel title;//定义标题标签
    public static JTextField accounttext;//输入账号文本
    public static JPasswordField passwordtext;//输入密码框
    public JButton login;//登录按钮
    public JButton register;//注册按钮
    private final int totalChance = 3;
    private int chance = 0;
    //监听类定义
    RegEvent regevent;
    LogiEvent logiEvent;
    // 定义一个面板
    JPanel contentPanel;
    public Login() {
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
        // 设置窗口标题
        setTitle("校园志愿者登录界面");
        //初始化字体类
        Fronts fronts = new Fronts();
        // 创建一个背景标签并添加背景图片
        ImageIcon backgroundIcon = new ImageIcon("C:\\code\\Volunteer\\image\\Login\\1.jpg");
        Image backgroundImage = backgroundIcon.getImage();
        Image newBackgroundImage = backgroundImage.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(newBackgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1600, 900);
        setContentPane(backgroundLabel);
        // 设置布局为null，以便手动定位组件
        setLayout(null);
        //添加标题
        title = new JLabel("校园志愿者管理系统");
        title.setFont(fronts.title);
        title.setForeground(Color.black);
        //添加账号和密码还有编辑框
        account = new JLabel("账号 ");
        account.setFont(fronts.username);
        account.setForeground(new Color(100,149,237));
        //添加账号文本框
        accounttext = new JTextField(20);
        accounttext.setFont(fronts.usernametext);
        accounttext.setForeground(new Color(100,149,237));
        //添加密码标签
        password = new JLabel("密码 ");
        password.setFont(fronts.username);
        password.setForeground(new Color(100,149,237));
        //密码框
        passwordtext = new JPasswordField(20);
        passwordtext.setFont(fronts.usernametext);
        passwordtext.setForeground(new Color(100,149,237));
        //添加权限
        role = new JLabel("权限 ");
        role.setFont(fronts.username);
        role.setForeground(new Color(100,149,237));
        comboBox = new JComboBox();
        comboBox.addItem("管理员");
        comboBox.addItem("志愿者");
        //登录按钮
        login = new JButton("登录系统");
        login.setPreferredSize(new Dimension(254,35));
        login.setFont(fronts.login);
        login.setBackground(new Color(8,189,252));
        login.setForeground(Color.black);
        login.setName("ok");
        //注册标签
        register = new JButton("注册账号");
        register.setBounds(10,210,100,40);
        register.setFont(fronts.register);
        register.setForeground(Color.black);
        // 手动定位组件
        title.setBounds(900, 150, 400, 100);
        account.setBounds(800, 300, 100, 50);
        password.setBounds(800, 360, 100, 50);
        role.setBounds(800, 430, 100, 50);
        accounttext.setBounds(900, 300, 400, 50);
        passwordtext.setBounds(900, 360, 400, 50);
        comboBox.setBounds(900,430,400,50);
        login.setBounds(800, 550, 200, 50);
        register.setBounds(1100,550,200,50);
        // 添加组件到窗口
        add(title);
        add(account);
        add(password);
        add(role);
        add(accounttext);
        add(passwordtext);
        add(comboBox);
        add(login);
        add(register);
        // 设置窗口大小和关闭操作
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        allEvent();
    }
    //所有监听事件
    void allEvent(){
        regevent = new RegEvent();
        logiEvent = new LogiEvent();
        register.addMouseListener(regevent);
        login.addActionListener(logiEvent);
    }

}
