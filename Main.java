import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI {
    private static Model character = new Model();
    public static void main(String[] args) {
        JFrame frame = new JFrame("أختار شخصيتك المصغرة ");
        frame.setSize(650, 570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(23, 23, 55));

        JTextField field = new JTextField();
        field.setBounds(190, 57, 230, 32);
        field.setFont(new Font("Arial", Font.BOLD, 16));
        field.setHorizontalAlignment(JTextField.CENTER);

        JLabel label = new JLabel("اسم المستخدم : ");
        label.setBounds(422, 40, 150, 65);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.white);

        JPanel characterPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                File skinFile = new File(character.SKINS[character.currentSkin]);
                if (skinFile.exists()) {
                    ImageIcon skinIcon = new ImageIcon(character.SKINS[character.currentSkin]);
                    g.drawImage(skinIcon.getImage(), 0, 0, 280, 280, this);
                }
                File eyeFile = new File(character.EYES_COLORS[character.currentEyes]);
                if (eyeFile.exists()) {
                    ImageIcon eyeIcon = new ImageIcon(character.EYES_COLORS[character.currentEyes]);
                    g.drawImage(eyeIcon.getImage(), 0, 0, 280, 280, this);
                }

                String hairImagePath = "";
                if (character.currentHair == 0) {
                    hairImagePath = character.HAIR1_COLORS[character.currentHairColor];
                } else if (character.currentHair == 1) {
                    hairImagePath = character.HAIR2_COLORS[character.currentHairColor];
                }

                if (!hairImagePath.isEmpty()) {
                    File hairFile = new File(hairImagePath);
                    if (hairFile.exists()) {
                        ImageIcon hairIcon = new ImageIcon(hairImagePath);
                        g.drawImage(hairIcon.getImage(), 0, 0, 280, 280, this);
                    }
                }

                String outfitImagePath = "";
                if (character.currentOutfit == 0) {
                    outfitImagePath = character.OUTFIT_1[character.currentOutfitColor];
                } else if (character.currentOutfit == 1) {
                    outfitImagePath = character.OUTFIT_2[character.currentOutfitColor];
                }else if (character.currentOutfit == 2) {
                    outfitImagePath = character.OUTFIT_3[character.currentOutfitColor];
                }else if (character.currentOutfit == 3) {
                    outfitImagePath = character.OUTFIT_4[character.currentOutfitColor];
                }

                if (!outfitImagePath.isEmpty()) {
                    File outfitFile = new File(outfitImagePath);
                    if (outfitFile.exists()) {
                        ImageIcon outfitIcon = new ImageIcon(outfitImagePath);
                        g.drawImage(outfitIcon.getImage(), 0, 0, 280, 280, this);
                    }
                }
            }
        };
        characterPanel.setBounds(330, 120, 280, 280);
        //characterPanel.setOpaque(false);

        JLabel skinLabel = new JLabel("لون البشرة");
        skinLabel.setBounds(237, 150, 70, 30);
        skinLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        skinLabel.setForeground(Color.WHITE);

        SkinSelector skinSelector = new SkinSelector(character, characterPanel);
        skinSelector.setBounds(30, 150, 190, 30);

        JLabel eyesLabel = new JLabel("لون العيون");
        eyesLabel.setBounds(237, 200, 70, 30);
        eyesLabel.setFont(new Font("Arial", Font.ITALIC, 17));
        eyesLabel.setForeground(Color.WHITE);

        EyesSelector eyesSelector = new EyesSelector(character, characterPanel);
        eyesSelector.setBounds(48, 200, 185, 30);

        JLabel HairLabel = new JLabel("شكل الشعر ");
        HairLabel.setBounds(225, 260, 90, 30);
        HairLabel.setFont(new Font("Arial", Font.ITALIC, 17));
        HairLabel.setForeground(Color.WHITE);

        HairSelector hairSelector = new HairSelector(character, characterPanel);
        hairSelector.setBounds(30, 260, 190, 75);

        JLabel outfitLabel = new JLabel("شكل اللبس ");
        outfitLabel.setBounds(225, 360, 90, 30);
        outfitLabel.setFont(new Font("Arial", Font.ITALIC, 17));
        outfitLabel.setForeground(Color.WHITE);

        OutfitSelector outfitSelector = new OutfitSelector(character, characterPanel);
        outfitSelector.setBounds(30, 360, 190, 75);

        frame.add(field);
        frame.add(label);
        frame.add(characterPanel);

        frame.add(skinLabel);
        frame.add(skinSelector);
        frame.add(eyesLabel);
        frame.add(eyesSelector);

        frame.add(HairLabel);
        frame.add(hairSelector);

        frame.add(outfitLabel);
        frame.add(outfitSelector);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
