// package com.casi_td4;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.Writer;
// import java.lang.reflect.Type;
// import java.util.LinkedList;

// import com.google.gson.Gson;
// import com.google.gson.GsonBuilder;
// import com.google.gson.reflect.TypeToken;

// import modele.BanqueFacade;
// import modele.Compte;
// import modele.Operation;

// public class testJson {

// public static void main(String[] args) {
// // Le mod�le
// LinkedList<Compte> lesComptes;

// // Le gestionnaire json - utilise la biblioth�que googlr
// final GsonBuilder builder = new GsonBuilder();
// final Gson gson = builder.create();

// // Le contenu du fichier
// String json = "";

// /*
// * Etape 1
// * Lecture du fichier json ligne � ligne et remplissage de la variable json
// */
// String fichierJson = "d:\\banque.json";
// try {
// InputStream ips = new FileInputStream(fichierJson);
// InputStreamReader ipsr = new InputStreamReader(ips);
// BufferedReader br = new BufferedReader(ipsr);
// String ligne;
// while ((ligne = br.readLine()) != null) {
// System.out.println(ligne);
// json += ligne;
// }
// br.close();
// } catch (Exception e) {
// System.out.println(e.toString());
// }

// /*
// * Etape 2
// * Remplissage des objets du mod�le � partir des donn�es r�cup�r�es
// * dans le fichier json
// */
// if (json.compareTo("") == 0) {
// // Si le fichier est vide, on cr�e une liste vide
// lesComptes = new LinkedList<Compte>();
// } else {
// // Le fichier n'est pas vide, on utilise la biblioth�que google
// // pour remplir les objets automatiquement
// Type type = new TypeToken<LinkedList<Compte>>() {
// }.getType();
// lesComptes = gson.fromJson(json, type);
// }

// /*
// * Etape 3
// * Utilisation de l'application
// * Ici par exemple, je cr�e 5 comptes ayant chacun 5 op�rations
// * Attention, c'est un travail sur le mod�le, les donn�es ne sont pas
// * enregistr�e dans le fichier json
// */
// for (int j = 1; j <= 5; j++) {
// Compte c = new Compte("Compte " + j, (float) j + 1000);
// for (int i = 1; i <= 5; i++) {
// c.addOperation("intitule " + i, "date", (float) 12.2 + i * j);
// }
// lesComptes.add(c);
// }

// /*
// * Etape 4
// * Enregistrement des objets du mod�le dans le fichier json
// * Attention! Ici pas d'insert ou update, on enregistre tout le fichier
// */

// // Transformation du mod�le d'objets en chaine au format json
// json = gson.toJson(lesComptes);
// // Ecriture sur le support physique
// File fichier = new File("d:\\banque.json");
// Writer writer = null;
// try {

// // ouverture d'un flux de sortie sur un fichier
// // a pour effet de cr�er le fichier
// writer = new FileWriter(fichier);
// writer.write(json);
// } catch (IOException e) {
// System.out.println("Impossible d'�crire dans le fichier " + e.getMessage());
// e.printStackTrace();

// } finally {
// if (writer != null) {
// try {
// writer.close();
// } catch (IOException e) {
// System.out.println("Erreur " + e.getMessage());
// e.printStackTrace();
// }
// }
// }
// }
// }
