package com.casi_td4.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogNouvelleOperation extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textLibelle;
    private JTextField textDate;
    private JTextField textMontant;
    private String date = "";
    private String intitule;
    private float montant;
    boolean saisieOK = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogNouvelleOperation dialog = new DialogNouvelleOperation();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogNouvelleOperation() {
        setModal(true);
        setBounds(100, 100, 502, 225);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblLibell = new JLabel("Libell\u00E9");
            lblLibell.setBounds(10, 91, 81, 14);
            contentPanel.add(lblLibell);
        }
        {
            JLabel lblAjouterUneOpration = new JLabel("Ajouter une op\u00E9ration");
            lblAjouterUneOpration.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblAjouterUneOpration.setBounds(10, 15, 297, 32);
            contentPanel.add(lblAjouterUneOpration);
        }
        {
            textLibelle = new JTextField();
            textLibelle.setBounds(81, 86, 389, 20);
            contentPanel.add(textLibelle);
            textLibelle.setColumns(10);
        }
        {
            JLabel lblDate = new JLabel("Date");
            lblDate.setBounds(10, 62, 76, 14);
            contentPanel.add(lblDate);
        }
        {
            JLabel lblMontant = new JLabel("Montant");
            lblMontant.setBounds(10, 120, 81, 14);
            contentPanel.add(lblMontant);
        }
        {
            textDate = new JTextField();
            // Mettre par d�faut la date du jour
            textDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            textDate.setBounds(81, 58, 118, 20);
            contentPanel.add(textDate);
            textDate.setColumns(10);
        }
        {
            textMontant = new JTextField();
            textMontant.setBounds(81, 114, 118, 20);
            contentPanel.add(textMontant);
            textMontant.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        verifierSaisie();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        fermerDialogBox();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    private void verifierSaisie() {
        date = textDate.getText();
        intitule = textLibelle.getText();
        String montantString = textMontant.getText();
        if (!date.isEmpty() && !intitule.isEmpty() && !montantString.isEmpty()) {
            try {
                montant = Float.parseFloat(montantString);
                saisieOK = true;
            } catch (Exception ex) {
                System.out.println("Erreur de saisie des informations de l'op�ration");
            }
            this.setVisible(false);
        } else {
            System.out.println("Erreur de saisie des informations de l'op�ration");
        }
    }

    private void fermerDialogBox() {
        this.setVisible(false);
    }

    public String getDate() {
        return date;
    }

    public String getIntitule() {
        return intitule;
    }

    public float getMontant() {
        return montant;
    }

    public boolean isSaisieOK() {
        return saisieOK;
    }

}
