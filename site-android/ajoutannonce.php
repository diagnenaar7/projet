<?php
//Appel du fichier de connexion
require_once('connexion_db.php');

//Récupérationn des données du formulaire (par post)
$poste=$_POST['poste'];
$date=$_POST['date'];
$lieu=$_POST['lieu'];
$email=$_POST['email'];



//extract($_POST); équivaut aux 5 lignes précédentes

//Définition de la requ?te

	$sql = "INSERT into annonce (poste,date,lieu,email) VALUES ('$poste','$date','$lieu','$email')";
 

//Exécution de la requête
$query_ajout=mysql_query($sql) or die(mysql_error());
if($query_ajout){
    echo"<h2>votre annonce a été ajoutée dans la base</h2>";
    
}
?>