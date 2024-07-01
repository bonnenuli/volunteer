package Dao;

import Jframe.ManageUtl.ManageComponents;
import Jframe.ManageUtl.ManageDatabaseReading;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class DelEvent implements ActionListener {
    Connection con=null;
    java.sql.Statement sql;
    java.sql.PreparedStatement sqll;
    String headnumber;
    public void actionPerformed(ActionEvent e){
        headnumber = ManageComponents.readNumberText();
        boolean x = (headnumber.equals(""));
        if(x==true){
            JOptionPane.showMessageDialog(null, "条件志愿者编号不能为空", "消息", JOptionPane.WARNING_MESSAGE);
        }else{
            delDate();
        }
    }
    void delDate(){
        String Uri ="delete from leaderdate where 志愿者编号=?";
        try{
            sqll = ManageDatabaseReading.con.prepareStatement(Uri);
            sqll.setString(1,headnumber);
            int ok=sqll.executeUpdate();
            if(ok==0){
                JOptionPane.showMessageDialog(null, "未找到相关志愿者编号", "消息", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "删除成功", "消息", JOptionPane.WARNING_MESSAGE);
            }
        }catch (SQLException e){

        }
    }
}


