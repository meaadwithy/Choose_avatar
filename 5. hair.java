import javax.swing.*;
import java.awt.*;

public class HairSelector extends JPanel {
    private JPanel colorContainer;
    private Model character;
    private JPanel characterPanel;

    public HairSelector(Model character, JPanel characterPanel) {
        this.character = character;
        this.characterPanel = characterPanel;

        this.setOpaque(false);
        this.setLayout(null);

        JButton leftHairBtn = new JButton("<");
        leftHairBtn.setBounds(0, 0, 30, 30);
        this.add(leftHairBtn);

        JPanel hairBar = new JPanel();
        hairBar.setBounds(38, 0, 110, 30);
        hairBar.setBackground(Color.WHITE);
        hairBar.setLayout(new BorderLayout());

        JLabel hairNameLabel = new JLabel(character.HAIR_NAMES[character.currentHair], SwingConstants.CENTER);
        hairNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        hairNameLabel.setForeground(Color.BLACK);
        hairBar.add(hairNameLabel, BorderLayout.CENTER);
        this.add(hairBar);

        JButton rightHairBtn = new JButton(">");
        rightHairBtn.setBounds(155, 0, 30, 30);
        this.add(rightHairBtn);

        colorContainer = new JPanel();
        colorContainer.setBounds(0, 40, 185, 30);
        colorContainer.setOpaque(false);
        colorContainer.setLayout(null); // تم التعديل إلى null ليعمل setBounds بشكل صحيح
        this.add(colorContainer);

        updateColorButtons();

        rightHairBtn.addActionListener(e -> {
            if (character.currentHair < character.HAIR.length - 1) {
                character.currentHair++;
            } else {
                character.currentHair = 0;
            }
            character.currentHairColor = 0;
            hairNameLabel.setText(character.HAIR_NAMES[character.currentHair]);
            updateColorButtons();
            characterPanel.repaint();
        });

        leftHairBtn.addActionListener(e -> {
            if (character.currentHair > 0) {
                character.currentHair--;
            } else {
                character.currentHair = character.HAIR.length - 1;
            }
            character.currentHairColor = 0;
            hairNameLabel.setText(character.HAIR_NAMES[character.currentHair]);
            updateColorButtons();
            characterPanel.repaint();
        });
    }

    public void updateColorButtons() {
        colorContainer.removeAll();

        int totalColors = 0;
        if (character.currentHair == 0) totalColors = character.HAIR1_COLORS.length;
        else if (character.currentHair == 1) totalColors = character.HAIR2_COLORS.length;

        for (int i = 0; i < totalColors; i++) {
            final int index = i;
            JButton colorBtn = new JButton();
            colorBtn.setBounds(i * 30, 0, 24, 24);
            colorBtn.setBackground(Color.WHITE);
            colorBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            colorBtn.addActionListener(e -> {
                character.currentHairColor = index;
                characterPanel.repaint();
            });
            colorContainer.add(colorBtn);
        }

        colorContainer.revalidate();
        colorContainer.repaint();
    }
}
