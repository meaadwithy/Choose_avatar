import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EyesSelector extends JPanel{
    public EyesSelector(Model character, JPanel characterPanel) {
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));

        for (int i = 0; i < character.EYES_COLORS.length; i++) {
            final int index = i;
            JButton colorBtn = new JButton();
            colorBtn.setPreferredSize(new Dimension(24, 24));


            colorBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    character.currentEyes = index;
                    characterPanel.repaint();
                }
            });
            this.add(colorBtn);
        }
    }
}
