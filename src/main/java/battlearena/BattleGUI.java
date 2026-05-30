package battlearena;

import javax.swing.*;
import java.awt.*;

public class BattleGUI extends JFrame {

    private JComboBox<String> enemy1Select;
    private JComboBox<String> enemy2Select;
    private JTextArea battleLog;
    private JButton startButton;

    public BattleGUI() {

        setTitle("Battle Arena");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2));

        enemy1Select = new JComboBox<>(new String[]{"Zombie", "Ogre"});
        enemy2Select = new JComboBox<>(new String[]{"Zombie", "Ogre"});

        topPanel.add(new JLabel("Enemy 1:"));
        topPanel.add(enemy1Select);
        topPanel.add(new JLabel("Enemy 2:"));
        topPanel.add(enemy2Select);

        add(topPanel, BorderLayout.NORTH);

        // Battle log
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(battleLog), BorderLayout.CENTER);

        // Start button
        startButton = new JButton("Start Battle");
        add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(e -> startBattle());

        setVisible(true);
    }

    private void startBattle() {

        Enemy e1 = createEnemy((String) enemy1Select.getSelectedItem());
        Enemy e2 = createEnemy((String) enemy2Select.getSelectedItem());

        battleLog.setText(""); // clear log

        battleLog.append("Battle Start!\n");

        int round = 1;

        while (e1.getHealthPointsRemaining() > 0 && e2.getHealthPointsRemaining() > 0) {

            battleLog.append("\n--- Round " + round + " ---\n");

            // e1 attacks
            e2.setHealthPointsRemaining(e2.getHealthPointsRemaining() - e1.getAttackDamage());
            battleLog.append(e1.getEnemyName() + " hits for " + e1.getAttackDamage() + "\n");
            battleLog.append(e2.getEnemyName() + " HP: " + e2.getHealthPointsRemaining() + "\n");

            if (e2.getHealthPointsRemaining() <= 0) {
                battleLog.append("\n" + e2.getEnemyName() + " has been defeated!\n");
                break;
            }

            // e2 attacks
            e1.setHealthPointsRemaining(e1.getHealthPointsRemaining() - e2.getAttackDamage());
            battleLog.append(e2.getEnemyName() + " hits for " + e2.getAttackDamage() + "\n");
            battleLog.append(e1.getEnemyName() + " HP: " + e1.getHealthPointsRemaining() + "\n");

            if (e1.getHealthPointsRemaining() <= 0) {
                battleLog.append("\n" + e1.getEnemyName() + " has been defeated!\n");
                break;
            }

            round++;
        }

        battleLog.append("\n--- Battle Over ---\n");
    }

    private Enemy createEnemy(String type) {
        return switch (type) {
            case "Zombie" -> new Zombie(10, 1);
            case "Ogre" -> new Ogre(20, 2);
            default -> null;
        };
    }
}
