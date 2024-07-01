package Dao;

import View.Register;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegEvent implements MouseListener {
    //鼠标点击
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            new Register();
        }
    }
    //按住鼠标
    @Override
    public void mousePressed(MouseEvent e) {

    }
    //释放鼠标
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    //鼠标移动
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    //鼠标退出
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
