package Jframe.ManageUtl;

import Dao.MenageEvent;
import utils.Mysqld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditInfoDialog extends JFrame {
    // 定义组件，如文本字段、标签、按钮等
    public static JTextField nameTextField;
    public static JTextField phoneTextField;
    public static JTextField emailTextField;
    public static JTextField birthdayTextField;
    JButton saveButton;
    private MenageEvent listener_1;

    public EditInfoDialog() {
        // 初始化组件
        nameTextField = new JTextField(15);
        phoneTextField = new JTextField(15);
        emailTextField = new JTextField(15);
        birthdayTextField = new JTextField(15);
        saveButton = new JButton("保存");

        // 设置窗口属性，如大小、位置、布局等
        setTitle("修改个人信息");
        setSize(400, 300);
        setLocationRelativeTo(null); // 居中显示
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 关闭时释放资源
        setVisible(true);//设置当前窗口是否显示
        validate();//让组件生效
        // 添加组件到内容面板
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(5, 2));
        contentPanel.add(new JLabel("姓名:"));
        contentPanel.add(nameTextField);
        contentPanel.add(new JLabel("联系电话:"));
        contentPanel.add(phoneTextField);
        contentPanel.add(new JLabel("邮箱:"));
        contentPanel.add(emailTextField);
        contentPanel.add(new JLabel("生日:"));
        contentPanel.add(birthdayTextField);
        contentPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    //向数据库更新信息
                    Mysqld.updatemy();
                }catch (Exception e1) {

                }
            }});
        // 添加内容面板到窗口
        add(contentPanel);
        setVisible(true); // 设置窗口可见
    }

    }
