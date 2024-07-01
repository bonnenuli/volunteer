package Jframe.ManageUtl;

import View.ManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 添加志愿者信息的对话框
public class AddVolunteer extends JFrame {
    private JTextField nameField;
    private JTextField idField;
    private JTextField phoneNumberField;
    private ManagementSystem man;

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public void setPhoneNumberField(JTextField phoneNumberField) {
        this.phoneNumberField = phoneNumberField;
    }

    public ManagementSystem getMan() {
        return man;
    }

    public void setMan(ManagementSystem man) {
        this.man = man;
    }

    public AddVolunteer(JFrame parent) {
        //super(parent, "添加居民信息", true);
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        // 创建输入组件
        add(new JLabel("姓名:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("身份证号:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("电话号码:"));
        phoneNumberField = new JTextField();
        add(phoneNumberField);

        // 创建按钮
        JButton addButton = new JButton("添加");
        addButton.addActionListener(new AddButtonListener());
        add(addButton);

        JButton cancelButton = new JButton("取消");
        cancelButton.addActionListener(e -> setVisible(false));
        add(cancelButton);
    }


    // 添加居民信息的菜单项监听器
    public class AddResidentMenuItemListener implements ActionListener {
        private ManagementSystem parent;

        public AddResidentMenuItemListener(ManagementSystem parent) {
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // 显示添加居民信息的对话框
            Object ManagementSystem;
            AddVolunteer dialog = new AddVolunteer(parent);
            dialog.setVisible(true);
        }
    }

    // 添加按钮监听器
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 获取输入的居民信息
            String name = nameField.getText();
            String id = idField.getText();
            String phoneNumber = phoneNumberField.getText();

            // 这里可以添加将居民信息保存到数据库的逻辑
            // ...

            // 清空输入框
            nameField.setText("");
            idField.setText("");
            phoneNumberField.setText("");

            // 关闭对话框
            setVisible(false);

            // 提示信息
            //JOptionPane.showMessageDialog(ManagementSystem.this, "居民信息已添加");
        }
    }

}
