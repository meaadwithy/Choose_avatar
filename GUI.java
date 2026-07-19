import javax.swing.*;
import java.awt.*;
public class GUI {
    public static void main(String[]args){
      //  "لإنشاء صفحة تشبه المتصفح بعنوان "اختار شخصيتك المصغرة
        JFrame frame = new JFrame("اختار شخصيتك المصغرة ");
        frame.setSize(650,570); // الحجم
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ازرار المتصفح الاغلاق وغيرها
        frame.getContentPane().setBackground(new Color(45, 45, 45)); // لون الخلفية

        frame.setLayout(null);// لاختيار اماكن العناصر اللي حتضيفها
        frame.setVisible(true);// يظهر للمستخدم
    }
}
