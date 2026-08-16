import javax.swing.*;
import java.awt.*;

public class OutfitSelector extends JPanel {
    private JPanel colorContainer;
    private Model character;
    private JPanel characterPanel;

    public OutfitSelector(Model character, JPanel characterPanel) {
        this.character = character;
        this.characterPanel = characterPanel;

        this.setOpaque(false);
        this.setLayout(null);


        JButton leftOutfitBtn = new JButton("<");
        leftOutfitBtn.setBounds(0, 0, 30, 30);
        this.add(leftOutfitBtn);


        JPanel outfitBar = new JPanel();
        outfitBar.setBounds(38, 0, 110, 30);
        outfitBar.setBackground(Color.WHITE);
        outfitBar.setLayout(new BorderLayout());

        JLabel outfitNameLabel = new JLabel(character.OUTFIT_NAMES[character.currentOutfit], SwingConstants.CENTER);
        outfitNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        outfitNameLabel.setForeground(Color.BLACK);
        outfitBar.add(outfitNameLabel, BorderLayout.CENTER);
        this.add(outfitBar);


        JButton rightOutfitBtn = new JButton(">");
        rightOutfitBtn.setBounds(155, 0, 30, 30);
        this.add(rightOutfitBtn);

        colorContainer = new JPanel();
        colorContainer.setBounds(0, 40, 185, 30);
        colorContainer.setOpaque(false);
        colorContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        this.add(colorContainer);

        updateColorButtons();

        rightOutfitBtn.addActionListener(e -> {
            if (character.currentOutfit < character.OUTFIT_NAMES.length - 1) {
                character.currentOutfit++;
            } else {
                character.currentOutfit = 0;
            }
            character.currentOutfitColor = 0;
            outfitNameLabel.setText(character.OUTFIT_NAMES[character.currentOutfit]);
            updateColorButtons();
            characterPanel.repaint();
        });

        leftOutfitBtn.addActionListener(e -> {
            if (character.currentOutfit > 0) {
                character.currentOutfit--;
            } else {
                character.currentOutfit = character.OUTFIT_NAMES.length - 1;
            }
            character.currentOutfitColor = 0;
            outfitNameLabel.setText(character.OUTFIT_NAMES[character.currentOutfit]);
            updateColorButtons();
            characterPanel.repaint();
        });
    }

    private void updateColorButtons() {
        colorContainer.removeAll();

        int totalColors = 0;
        if (character.currentOutfit == 0) totalColors = character.OUTFIT_1.length;
        else if (character.currentOutfit == 1) totalColors = character.OUTFIT_2.length;
        else if (character.currentOutfit == 2) totalColors = character.OUTFIT_3.length;
        else if (character.currentOutfit == 3) totalColors = character.OUTFIT_4.length;

        for (int i = 0; i < totalColors; i++) {
            final int index = i;
            JButton colorBtn = new JButton();
            colorBtn.setPreferredSize(new Dimension(24, 24));
            colorBtn.setBackground(Color.WHITE);
            colorBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            colorBtn.addActionListener(e -> {
                character.currentOutfitColor = index;
                characterPanel.repaint();
            });
            colorContainer.add(colorBtn);
        }

        colorContainer.revalidate();
        colorContainer.repaint();
    }
}
