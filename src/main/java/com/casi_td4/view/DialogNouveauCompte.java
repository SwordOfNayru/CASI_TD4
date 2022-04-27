// package view;

// import java.awt.BorderLayout;
// import java.awt.FlowLayout;
// import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JButton;
// import javax.swing.JDialog;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextField;
// import javax.swing.border.EmptyBorder;

// import modele.Compte;

// public class DialogNouveauCompte extends JDialog {

// private final JPanel contentPanel = new JPanel();
// private JTextField textNumeroCompte;
// private JTextField textSolde;
// private String numeroCompte="";
// private float solde;
// private boolean saisieOK=false;

// /**
// * Create the dialog.
// */
// public DialogNouveauCompte() {
// setModal(true);
// setBounds(100, 100, 440, 173);
// getContentPane().setLayout(new BorderLayout());
// contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
// getContentPane().add(contentPanel, BorderLayout.CENTER);
// contentPanel.setLayout(null);
// {
// JLabel lblNumroDeCompte = new JLabel("Num\u00E9ro de compte");
// lblNumroDeCompte.setBounds(22, 49, 92, 14);
// contentPanel.add(lblNumroDeCompte);
// }

// JLabel lblSolde = new JLabel("Solde");
// lblSolde.setBounds(22, 75, 48, 14);
// contentPanel.add(lblSolde);

// JLabel lblSaisissezLesInformations = new JLabel("Saisissez les informations
// pour la cr\u00E9ation du nouveau compte");
// lblSaisissezLesInformations.setFont(new Font("Tahoma", Font.BOLD, 12));
// lblSaisissezLesInformations.setBounds(22, 12, 410, 25);
// contentPanel.add(lblSaisissezLesInformations);

// textNumeroCompte = new JTextField();
// textNumeroCompte.setBounds(137, 46, 261, 20);
// contentPanel.add(textNumeroCompte);
// textNumeroCompte.setColumns(10);

// textSolde = new JTextField();
// textSolde.setBounds(137, 72, 96, 20);
// contentPanel.add(textSolde);
// textSolde.setColumns(10);
// {
// JPanel buttonPane = new JPanel();
// buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
// getContentPane().add(buttonPane, BorderLayout.SOUTH);
// {
// JButton okButton = new JButton("OK");
// okButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// verifierSaisie();
// }
// });
// //okButton.setActionCommand("OK");
// buttonPane.add(okButton);
// getRootPane().setDefaultButton(okButton);
// }
// {
// JButton cancelButton = new JButton("Cancel");
// cancelButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// fermerDialogBox();
// }
// });
// //cancelButton.setActionCommand("Cancel");
// buttonPane.add(cancelButton);
// }
// }
// }
// private void verifierSaisie()
// {
// numeroCompte = textNumeroCompte.getText();
// if (!numeroCompte.isEmpty())
// {
// try {
// solde=Float.parseFloat(textSolde.getText());
// }
// catch (Exception ex)
// {
// System.out.println("Erreur de saisie des informations du compte");
// }
// saisieOK=true;
// this.setVisible(false);
// }
// else
// {
// System.out.println("Erreur de saisie des informations du compte");
// }

// }

// private void fermerDialogBox()
// {
// this.setVisible(false);
// }
// public String getNumeroCompte() {
// return numeroCompte;
// }
// public float getSolde() {
// return solde;
// }
// public boolean isSaisieOK() {
// return saisieOK;
// }

// }
