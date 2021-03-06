package ro.vplaton.views;

import ro.vplaton.PlayerLoader;
import ro.vplaton.controllers.PlayerController;
import ro.vplaton.models.characters.Hero;

import javax.swing.*;

/**
 * @author plato
 */
public class SelectCharacterView extends javax.swing.JPanel {

    private PlayerController playerController;

    public SelectCharacterView(String playerName) {
        initComponents();
        DefaultListModel<String> model = null;
        playerController = new PlayerController(playerName);
        try {
            playerController.setPlayer(PlayerLoader.loadPlayer(playerName));
            model = new DefaultListModel<String>();
            for (String heroName: playerController.getHeroesNames()) {
                model.addElement(heroName);
            }
        } catch (Exception e) {
            System.out.println("Error loading player data!");
        }
        charList.setModel(model);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        charList = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        newCharBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        statsText = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        charOkBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setViewportView(charList);

        jLabel1.setText("Available characters:");

        newCharBtn.setText("Create new");
        newCharBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCharBtnActionPerformed(evt);
            }
        });

        charOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okCharBtnActionPerformed(evt);
            }
        });

        charList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                charListValueChanged(evt);
            }
        });

        statsText.setEditable(false);
        statsText.setColumns(20);
        statsText.setRows(5);
        jScrollPane2.setViewportView(statsText);

        jLabel2.setText("Stats:");

        charOkBtn.setText("Ok");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(newCharBtn)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(charOkBtn)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newCharBtn)
                                        .addComponent(charOkBtn))
                                .addContainerGap(201, Short.MAX_VALUE))
        );
    }

    private void charListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        StringBuilder sb = new StringBuilder();
        playerController.getPlayer().selectHero(charList.getSelectedValue());
        Hero hero = playerController.getPlayer().getHero();
        sb.append("Name: " + hero.getName() + "\n");
        sb.append("Class: " + hero.getClassString() + "\n");
        sb.append("Level: " + hero.getLevel() + "\n");
        statsText.setText(sb.toString());
    }

    private void newCharBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void okCharBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        ((JFrame)this.getRootPane().getParent()).setContentPane(new MissionView(playerController));
        (this.getRootPane().getParent()).revalidate();
    }

    private javax.swing.JList<String> charList;
    private javax.swing.JButton charOkBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newCharBtn;
    private javax.swing.JTextArea statsText;
}
