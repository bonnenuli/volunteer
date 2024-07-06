package utils;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Session
{
    public static final HashMap<Integer, Set<Date>> RECORD_MAP=new HashMap<>();
    public static final HashMap<String, BufferedImage>IMAGE_MAP=new HashMap<>();
    public static void init()
    {
    }
    public static void dispose() {
        JDBCUtil.closeConnection();}
}
