package Front;

import java.awt.Font;

public class Fronts {
    public static Font title;
    public static Font username;
    public static Font usernametext;
    public static Font login;
    public static Font register;
    public static Font remind;
    public static Font sear;
    public static Font zhu;
    public static Font yt;
    public Fronts() {
        title = new Font("宋体",Font.BOLD,40);//标题字体
        username = new Font("华文bai行楷",Font.BOLD,30);//标签
        usernametext = new Font("宋体",Font.PLAIN,30);//账号框
        login = new Font("宋体",Font.BOLD,28);//登录按钮
        register = new Font(" 宋体",Font.BOLD,28);//注册标签
        remind = new Font("宋体",Font.BOLD,22);
        sear = new Font("方正清刻本悦宋", Font.BOLD, 26);
        zhu = new Font("和风书道昭和白龙-闪", Font.BOLD, 100);
        yt = new Font("华文bai行楷", Font.BOLD, 60);
    }
}
