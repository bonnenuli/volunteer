package utils;

import Dao.*;
import Jframe.ManageUtl.*;
import Jframe.VolunteerUtl.Info;

import javax.swing.*;
import java.sql.*;
import java.util.Collections;

public class Mysqld {
    public static Connection con = null;
    private static final String account = "root";
    private static final String password = "root";
    public static final String accounts = "a";
    private static final String passwords = "a";
    private static DefaultRowSorter<Object, Object> Table;

    public Mysqld() {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.lang.System.out.println("加载驱动成功");
        } catch (Exception e) {
            java.lang.System.out.println("加载驱动失败");
        }
        String uri = "jdbc:mysql://localhost:3306/Volunteer?serverTimezone=GMT%2B8&useSSL=false";
        try {
            if ("root".equals(account)) {
                con = DriverManager.getConnection(uri, account, password);
                java.lang.System.out.println("链接数据库成功");
            } else if ("a".equals(account)) {
                con = DriverManager.getConnection(uri, accounts, passwords);
                java.lang.System.out.println("链接数据库成功");
            }
        } catch (SQLException e) {
            java.lang.System.out.println("链接数据库失败");
        }
    }

    // 登录验证
    public static String loginAccount(String account, String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String role = null; // 存储用户的权限
        String uri = "select account, password, role from user where account = ? and password = ? ";
        try {
            // 使用PreparedStatement来避免SQL注入
            pstmt = con.prepareStatement(uri);
            pstmt.setString(1, account);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                role = rs.getString("role"); // 获取用户的权限
                // 根据角色创建相应的界面应该在外部方法中调用，而不是在这里
            } else {
                // 如果没有匹配的用户，不需要做任何操作，role将保持为null
            }
        } catch (SQLException e) {
            System.out.println("登录验证时发生错误：" + e.getMessage());
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return role; // 返回用户的权限，如果登录失败则返回null
    }

    public static void onlineAccount() {
        Statement sql;//用来执行命令
        ResultSet rs;
        String uri = "select * from user";
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(uri);
            Volunteers.resultText.setText("");
            Volunteers.resultText.setText("姓名\t账号\t状态\n");
            while (rs.next()) {
                String name = rs.getString("name");//返回第一个值就是账号
                String account = rs.getString("account");//返回的第一个值就是
                String start = rs.getString("start");
                if (start.equals("0")) {
                    String uri1 = Volunteers.resultText.getText() + name + "\t" + account + "\t在线" + "\n";
                    Volunteers.resultText.setText(uri1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 打印异常信息
        }
    }

    public static void AllAccount() {
        Statement sql;//用来执行命令
        ResultSet rs;
        String uri = "select * from user";
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(uri);
            Volunteers.resultText.setText("");
            Volunteers.resultText.setText("姓名\t账号\t状态\n");
            while (rs.next()) {
                String name = rs.getString("name");//返回第一个值就是账号
                String account = rs.getString("account");//返回的第一个值就是
                String start = rs.getString("start");
                if (start.equals("0")) {
                    String uri1 = Volunteers.resultText.getText() + name + "\t" + account + "\t在线" + "\n";
                    Volunteers.resultText.setText(uri1);
                }
                if (start.equals("1")) {
                    String uri1 = Volunteers.resultText.getText() + name + "\t" + account + "\t离线" + "\n";
                    Volunteers.resultText.setText(uri1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 打印异常信息
        }

    }

    public static void updateAccount() {
        ResultSet rs;
        PreparedStatement preSql;
        String sqlStr = "update user set name=?,password=? where account=?";
        try {
            String account = UpdateAccount.accounttext.getText();
            String name = UpdateAccount.nametext.getText();
            String password = new String(UpdateAccount.passwordtext.getPassword());
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, account);
            preSql.setString(3, password);
            int ok = preSql.executeUpdate();
            JOptionPane.showMessageDialog(null, "更改成功", "更改消息", JOptionPane.WARNING_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "更改失败", "更改消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void setStart(String account) {
        PreparedStatement preSql;
        String sqlStr = "update user set start =? where account=?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, "1");
            preSql.setString(2, account);
            preSql.executeLargeUpdate();
        } catch (SQLException e) {

        }
    }

    public static void changepassword(String account, String password) {
        PreparedStatement preSql;
        String sqlStr = "update user set password=? where account=?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, password);
            preSql.setString(2, account);
            preSql.executeLargeUpdate();
        } catch (SQLException e) {

        }
    }

    public static void addVolunteer(String name, String sex, String age, String year, String classs, String home) {
        PreparedStatement preSql;
        String sqlStr = "insert into vol(name,sex,age,year,classs,home) values(?,?,?,?,?,?)";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, sex);
            preSql.setString(3, age);
            preSql.setString(4, year);
            preSql.setString(5, classs);
            preSql.setString(6, home);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "添加失败", "添加信息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "添加成功", "添加信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "当前志愿者编号不存在", "添加信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void delVolunteer(String classs) {
        PreparedStatement preSql;
        String sqlStr = "delete from vol where classs=?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, classs);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "未找到相关志愿者编号", "消息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "删除成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "当前志愿者编号已经存在", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void changeVolunteer(String name, String sex, String age, String year, String classs, String home, String classsT) {
        PreparedStatement preSql;
        String sqlStr = "update vol set name=?,sex=?,age=?,year=?,classs=?,home=? where classs=?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, sex);
            preSql.setString(3, age);
            preSql.setString(4, year);
            preSql.setString(5, classs);
            preSql.setString(6, home);
            preSql.setString(7, classsT);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "编号错误或编号不存在", "消息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "更改成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "编号错误", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void findAllVolunteer() {
        PreparedStatement preSql;
        Volunteers.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from vol";
        try {
            preSql = con.prepareStatement(sqlStr);
            ResultSet rs = preSql.executeQuery();
            LogiEvent.addAble(rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static ResultSet getRs() {
        PreparedStatement preSql;
        ResultSet rs = null;
        Volunteers.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from vol";
        try {
            preSql = con.prepareStatement(sqlStr);
            rs = preSql.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }

    public static void findConVolunteer(String name, String sex, String age, String year, String classs, String home) {
        PreparedStatement preSql;
        ResultSet rs = null;
        Volunteers.model.setNumRows(0);
        String sqlStr = "select * from vol where name regexp? and sex regexp? and age regexp? and year regexp? and classs regexp? and home regexp?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, sex);
            preSql.setString(3, age);
            preSql.setString(4, year);
            preSql.setString(5, classs);
            preSql.setString(6, home);
            rs = preSql.executeQuery();
            LogiEvent.addAble(rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findOneVolunteer(String classs) {
        PreparedStatement preSql;
        ResultSet rs = null;
        Volunteers.model.setNumRows(0);
        String sqlStr = "select * from vol where classs = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, classs);
            rs = preSql.executeQuery();
            LogiEvent.addOneAble(rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void addTime(String classs, String name, String nc, String time) {
        PreparedStatement preSql;
        String sqlStr = "insert into time(classs,name,nc,time) values(?,?,?,?)";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, classs);
            preSql.setString(2, name);
            preSql.setString(3, nc);
            preSql.setString(4, time);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "添加失败", "添加信息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "添加成功", "添加信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "当前活动信息不存在", "添加信息", JOptionPane.WARNING_MESSAGE);
        }
    }


    public static void changeTime(String num, String name, String nc, String time, String act) {
        PreparedStatement preSql;
        String sqlStr = "update time set classs=?,name=?,nc=?,time=? where nc=?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, num);
            preSql.setString(2, name);
            preSql.setString(3, nc);
            preSql.setString(4, time);
            preSql.setString(5, act);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "活动名称错误或活动名称不存在", "消息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "更改成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "活动名称错误", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void findAllTime() {
        PreparedStatement preSql;
        Acttime.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from time";
        try {
            preSql = con.prepareStatement(sqlStr);
            ResultSet rt = preSql.executeQuery();
            ActtimeEvent.addAblet(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findConTime(String num, String name, String nc, String time) {
        PreparedStatement preSql;
        ResultSet rt = null;
        Acttime.model.setNumRows(0);
        String sqlStr = "select * from time where classs regexp? and name regexp? and nc regexp? and time regexp?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, num);
            preSql.setString(2, name);
            preSql.setString(3, nc);
            preSql.setString(4, time);
            rt = preSql.executeQuery();
            ActtimeEvent.addAblet(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findOneTime(String act) {
        PreparedStatement preSql;
        ResultSet rt = null;
        Acttime.model.setNumRows(0);
        String sqlStr = "select * from time where nc = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, act);
            rt = preSql.executeQuery();
            ActtimeEvent.addOneAblet(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void addActinfo(String nc, String stime, String apply, String demand, String rtime, String detail) {
        PreparedStatement preSql;
        String sqlStr = "insert into actinof(nc,stime,apply,demand,rtime,detail) values(?,?,?,?,?,?)";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, stime);
            preSql.setString(3, apply);
            preSql.setString(4, demand);
            preSql.setString(5, rtime);
            preSql.setString(6, detail);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "添加失败", "添加信息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "添加成功", "添加信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "当前活动名称不存在", "添加信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void delActinfo(String nc) {
        PreparedStatement preSql;
        String sqlStr = "delete from actinof where nc=?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "未找到相关志愿者编号", "消息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "删除成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "当前活动信息已经存在", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void changeActinfo(String nc, String stime, String apply, String demand, String rtime, String detail, String act) {
        PreparedStatement preSql;
        String sqlStr = "update actinof set nc=?,stime=?,apply=?,demand=?,rtime=?,detail=? where nc=?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, stime);
            preSql.setString(3, apply);
            preSql.setString(4, demand);
            preSql.setString(5, rtime);
            preSql.setString(6, detail);
            preSql.setString(7, act);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "活动名称错误或活动名称不存在", "消息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "更改成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "活动名称错误", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void findAllActinfo() {
        PreparedStatement preSql;
        ActivityInfo.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from actinof";
        try {
            preSql = con.prepareStatement(sqlStr);
            ResultSet rt = preSql.executeQuery();
            ActInofEvent.addAblei(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findConActinfo(String nc, String stime, String apply, String demand, String rtime, String detail) {
        PreparedStatement preSql;
        ResultSet rt = null;
        ActivityInfo.model.setNumRows(0);
        String sqlStr = "select * from actinof where nc regexp? and rtime regexp? and apply regexp? and demand regexp? and rtime regexp?and detail regexp?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, stime);
            preSql.setString(3, apply);
            preSql.setString(4, demand);
            preSql.setString(5, rtime);
            preSql.setString(6, detail);
            rt = preSql.executeQuery();
            ActInofEvent.addAblei(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findOneActinfo(String num) {
        PreparedStatement preSql;
        ResultSet rt = null;
        ActivityInfo.model.setNumRows(0);
        String sqlStr = "select * from actinof where nc = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, num);
            rt = preSql.executeQuery();
            ActInofEvent.addOneAblei(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void addType(String nc, String type) {
        PreparedStatement preSql;
        String sqlStr = "insert into acttype(nc,type) values(?,?)";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, type);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "添加失败", "添加信息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "添加成功", "添加信息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "当前活动名称不存在", "添加信息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void delType(String[] numbers) {
        if (numbers != null && numbers.length > 0) {
            String placeholders = String.join(",", Collections.nCopies(numbers.length, "?"));
            String sql = "DELETE FROM acttype WHERE type IN (" + placeholders + ")";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                for (int i = 0; i < numbers.length; i++) {
                    pstmt.setString(i + 1, numbers[i]);
                }
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("没有找到匹配的数据，或者数据可能已经被删除。");
                } else {
                    System.out.println(rowsAffected + " 条记录被删除。");
                }
            } catch (SQLException e) {
                System.out.println("批量删除时发生错误：" + e.getMessage());
                // 这里可以进一步处理异常，例如记录日志或者通知用户
            }
        } else {
            System.out.println("没有提供有效的编号数组进行删除。");
        }
    }

    public static void changeType(String nc, String type, String act) {
        PreparedStatement preSql;
        String sqlStr = "update acttype set nc=?,type=? where nc=?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, type);
            preSql.setString(3, act);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "活动名称错误或活动名称不存在", "消息", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "更改成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "活动名称错误", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void findAllType() {
        PreparedStatement preSql;
        Actsign.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from acttype";
        try {
            preSql = con.prepareStatement(sqlStr);
            ResultSet rt = preSql.executeQuery();
            ActTypeEvent.addAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findConType(String nc, String type) {
        PreparedStatement preSql;
        ResultSet rt = null;
        Actsign.model.setNumRows(0);
        String sqlStr = "select * from acttype where nc regexp? and type regexp? ";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, type);
            rt = preSql.executeQuery();
            ActTypeEvent.addAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findOneType(String num) {
        PreparedStatement preSql;
        ResultSet rt = null;
        Actsign.model.setNumRows(0);
        String sqlStr = "select * from acttype where nc = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, num);
            rt = preSql.executeQuery();
            ActTypeEvent.addOneAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void findAllApply() {
        PreparedStatement preSql;
        ActivityRegist.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from actapply";
        try {
            preSql = con.prepareStatement(sqlStr);
            ResultSet rt = preSql.executeQuery();
            ActapplyEvent.addAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findConApply(String nc, String applyper, String apply, String applytime, String state) {
        PreparedStatement preSql;
        ResultSet rt = null;
        ActivityRegist.model.setNumRows(0);
        String sqlStr = "select * from actapply where classs regexp? and applyper regexp? and apply regexp?  and applytime regexp?and states regexp?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, applyper);
            preSql.setString(3, apply);
            preSql.setString(4, applytime);
            preSql.setString(5, state);
            rt = preSql.executeQuery();
            ActapplyEvent.addAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findOneApply(String pre) {
        PreparedStatement preSql;
        ResultSet rt = null;
        ActivityRegist.model.setNumRows(0);
        String sqlStr = "select * from actapply where applyper = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, pre);
            rt = preSql.executeQuery();
            ActapplyEvent.addOneAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void delApply(String[] acts) {
        if (acts != null && acts.length > 0) {
            String placeholders = String.join(",", Collections.nCopies(acts.length, "?"));
            String sql = "DELETE FROM actapply where nc IN (" + placeholders + ")";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                for (int i = 0; i < acts.length; i++) {
                    pstmt.setString(i + 1, acts[i]);
                }
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("没有找到匹配的数据，或者数据可能已经被删除。");
                    JOptionPane.showMessageDialog(null, "未找到相关志愿者编号", "消息", JOptionPane.WARNING_MESSAGE);
                } else {
                    System.out.println(rowsAffected + " 条记录被删除。");
                    JOptionPane.showMessageDialog(null, "删除成功", "消息", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                System.out.println("批量删除时发生错误：" + e.getMessage());
            }
        } else {
            System.out.println("没有提供有效的编号数组进行删除。");
            JOptionPane.showMessageDialog(null, "没有提供有效的编号数组进行删除。", "消息", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void findAllinfo() {
        PreparedStatement preSql;
        Info.model.setNumRows(0);//将表格数据置为0
        String sqlStr = "select * from actinof";
        try {
            preSql = con.prepareStatement(sqlStr);
            ResultSet rt = preSql.executeQuery();
            InfoEvent.addAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findConinfo(String nc,  String apply, String demand, String rtime,String detail) {
        PreparedStatement preSql;
        ResultSet rt = null;
        Info.model.setNumRows(0);
        String sqlStr = "select * from actinof where nc regexp? and apply regexp? and demand regexp? and rtime regexp?and detail regexp?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, nc);
            preSql.setString(2, apply);
            preSql.setString(3, demand);
            preSql.setString(4, rtime);
            preSql.setString(5, detail);
            rt = preSql.executeQuery();
            InfoEvent.addAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void findOneinfo(String num) {
        PreparedStatement preSql;
        ResultSet rt = null;
        Info.model.setNumRows(0);
        String sqlStr = "select * from actinof where nc = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, num);
            rt = preSql.executeQuery();
            InfoEvent.addOneAble(rt);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
