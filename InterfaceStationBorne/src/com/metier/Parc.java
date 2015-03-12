package com.metier;
import java.util.ArrayList;
public class Parc {
private ArrayList<Station> leParcBorne;
public Parc() {
super();
leParcBorne=new ArrayList<Station>();
}
public ArrayList<Station> getLeParcBorne() {
return leParcBorne;
}
public void setLeParcBorne(ArrayList<Station> leParcBorne) {
this.leParcBorne = leParcBorne;
}
public void ajouterStation(Station s)
 {
 leParcBorne.add(s);
 }
 // ram�ne le nombre de stations
 public int getNbStation()
 {
 return leParcBorne.size();
 }
// ram�ne le nombre total de bornes pour toutes les stations
 public int getNbBorne()
 {
 int cpt = 0;
 // parcours pour faire le cumul
 for (Station s : leParcBorne)
 {
 cpt = cpt + s.getLesBornes().size();
 }
 return cpt;
 }
 // ram�ne la liste de bornes de la station
 // dont l'id est pass� en param�tre
 // ram�ne null si la station n'existe pas 
 public ArrayList<Borne> getLaStation(int id)
 {
 int i = 0;
 Boolean trouve = false;
 Station s;
 ArrayList<Borne> liste = null;
 // onrecherche tant que l'on a pas trouv� et que ce n'est pas la fin de la collection
 while ((trouve == false) && (i < leParcBorne.size()))
 {
 // on r�cup�re la station courante dans un objet de travail
 s = leParcBorne.get(i);
 // on compare les id
 if (s.getIdStation() == id)
 {
 // on r�cup�re la liste
 liste = s.getLesBornes();
trouve = true;
 }
 else
 i = i + 1;
 }
//on d�livre la liste
return liste;
}
public ArrayList<Station> getStationTypeCharge(int idTypeCharge)
{
// d�claration et instanciation d'une collection de travail
ArrayList<Station> listeS=new ArrayList<Station>();
// boole�n et index pour la recherche dans liste de bornes de la station
Boolean trouve;
int i;
Borne b;
// parcours de l'ensemble des stations
for(Station s : leParcBorne)
{
// on repart au d�but pour chaque station
trouve=false;
i=0;
// recherche dans la collection de bornes de la station en cours de traitement
// tant que l'on a pas trouve et que l'on a une chance de trouver(limite taille de la collection)
while ((trouve==false) && (i<s.getLesBornes().size()))
{
// extraction borne dan svariable de travail pas obligatoire  mais plus simple
b=s.getLesBornes().get(i);
// test du codetypepecharge
if (b.getTypeCharge().getCodeTypeCharge()==idTypeCharge)
{ 
// trouve donc ajout � la collection de travail
listeS.add(s);
trouve=true;
}
else
// on avance
i++;
}
}
// on d�livre la collection
return listeS;
}
}