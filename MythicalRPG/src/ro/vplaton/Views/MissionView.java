package ro.vplaton.views;

import ro.vplaton.MissionLoader;
import ro.vplaton.controllers.MissionController;
import ro.vplaton.controllers.PlayerController;
import ro.vplaton.models.characters.Hero;
import ro.vplaton.models.characters.Villain;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by plato on 2/28/2016.
 */

public class MissionView extends javax.swing.JPanel implements Observer {
    PlayerController playerController;
    MissionController missionController;

    public MissionView(PlayerController playerController) {
        initComponents();
        this.playerController = playerController;
        this.playerController.getPlayer().getHero().addObserver(this);
        this.pb1.setMaximum(playerController.getPlayer().getHero().getHealth());
        this.pb1.setValue(pb1.getMaximum());

        try {
            missionController = new MissionController(MissionLoader.loadMission("mission1"));
        } catch (IOException e) {
            System.out.println("Error loading misssion!");
        }
        this.pb2.setMaximum(missionController.getVillain().getHealth());
        this.pb2.setValue(pb2.getMaximum());
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnAction1 = new javax.swing.JButton();
        btnAction2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pb2 = new javax.swing.JProgressBar();
        pb1 = new javax.swing.JProgressBar();

        jScrollPane1.setViewportView(jTextPane1);

        btnAction1.setText("Attack");
        btnAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAction1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Actions:");

        btnAction2.setText("Potion");
        btnAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAction2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAction1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnAction2)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                                .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAction1)
                                        .addComponent(btnAction2))
                                .addGap(26, 26, 26))
        );
    }

    private void prompt(String s) {
        this.jTextPane1.setText(jTextPane1.getText() + s + "\n");
    }

    private void btnAction1ActionPerformed(ActionEvent evt) {
        Hero hero = playerController.getPlayer().getHero();
        Villain villain = missionController.getVillain();
        int heroHp = hero.getHealth();
        int villainHp = villain.getHealth();

        villain.getDamage(hero.computeDamage());
        prompt((villainHp - villain.getHealth()) + " damage dealt to " + villain.getName());
        if (villain.isDead()) {
            prompt(villain.getName() + " is dead...");
            missionController.nextVillain();
            villain = missionController.getVillain();
            prompt(villain.getName() + " appeared!");
            this.pb2.setMaximum(villain.getHealth());
        } else {
            hero.getDamage(villain.computeDamage());
            prompt("You received " + (heroHp - hero.getHealth()) + " damage from " + villain.getName());
        }
        this.pb1.setValue(hero.getHealth());
        this.pb2.setValue(villain.getHealth());

        prompt("");
    }

    private void btnAction2ActionPerformed(ActionEvent evt) {
        Hero hero = playerController.getPlayer().getHero();
        hero.drinkPotion();
        prompt("50 hp points restored!");
        this.pb1.setValue(hero.getHealth());

        prompt("");
    }

    private javax.swing.JButton btnAction1;
    private javax.swing.JButton btnAction2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JProgressBar pb1;
    private javax.swing.JProgressBar pb2;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("State changed!");
    }
}
