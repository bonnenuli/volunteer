import Jframe.ManageUtl.Actsign;
import Jframe.VolunteerUtl.sign;
import View.Login;
import View.Volunteer;
import utils.Mysqld;

import javax.swing.*;

public class App {
    public static Login loginA;
        // 主方法
        public static void main(String[] args) {
            // 设置窗口的观感
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.out.println("Error setting native LAF: " + e);
            }

            //链接数据库
            new Mysqld();
            //主界面
            // 运行校园志愿者管理系统
            //new ManagementSystem();
            // 运行校园志愿者管理系统登录界面
            //new Login();
            // 运行校园志愿者管理系统注册界面
            //new Register();
            //更改志愿者信息
            //new UpdateAccount();
            //修改密码
            //new ChangePassword();
            //new show();
            //管理员
            //new Manage();
            //new Volunteers();
            //运行校园志愿者管理系统活动信息
            //new ActivityInfo();
            //更改志愿者信息
            //new UpdateAccount();
            //活动签到管理
            //new Actsign();
            //活动时长管理
            //new Acttime();
            //活动报名管理
            //new ActivityRegist();
            //个人中心
            //new Myself();

            //志愿者
            new Volunteer();
            //互动论坛
            //new Discussion();
            //活动信息
            //new Info();
            //活动公告
            //new Notice();
            // 校园新闻
            //new SchoolNews();
            //活动报名
            //new Apply();
            //活动精彩瞬间
            //new Moments();
            //活动签到
            new sign();
            //个人主页
            //new Own();
        }
}
