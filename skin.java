import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkinSelector extends JPanel{
    public SkinSelector(Model character, JPanel characterPanel) {
        this.setOpaque(false);
        this.setLayout(null);

        JButton leftSkinBtn = new JButton("<");
        leftSkinBtn.setBounds(0, 0, 30, 30);
        this.add(leftSkinBtn);

        JPanel skinBar = new JPanel();
        skinBar.setBounds(38, 0, 110, 30);
        skinBar.setBackground(Color.WHITE);
        skinBar.setLayout(new BorderLayout());

        JLabel skinLabel = new JLabel(character.SKIN_NAMES[character.currentSkin], SwingConstants.CENTER);
        skinLabel.setFont(new Font("Arial", Font.BOLD, 14));
        skinLabel.setForeground(Color.BLACK);
        skinBar.add(skinLabel, BorderLayout.CENTER);
        this.add(skinBar);

        JButton rightSkinBtn = new JButton(">");
        rightSkinBtn.setBounds(155, 0, 30, 30);
        this.add(rightSkinBtn);

        rightSkinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.currentSkin < character.SKINS.length - 1) {
                    character.currentSkin++;
                } else {
                    character.currentSkin = 0;
                }
                characterPanel.repaint();
                skinLabel.setText(character.SKIN_NAMES[character.currentSkin]);
            }
        });

        leftSkinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.currentSkin > 0) {
                    character.currentSkin--;
                } else {
                    character.currentSkin = character.SKINS.length - 1;
                }
                characterPanel.repaint();
                skinLabel.setText(character.SKIN_NAMES[character.currentSkin]);
            }
        });

    }
}
