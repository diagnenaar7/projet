<?php
//Appel du fichier de connexion
require_once('connexion_db.php');

//R�cup�rationn des donn�es du formulaire (par post)
$poste=$_POST['poste'];
$date=$_POST['date'];
$lieu=$_POST['lieu'];
$email=$_POST['email'];



//extract($_POST); �quivaut aux 5 lignes pr�c�dentes

//D�finition de la requ?te

	$sql = "INSERT into annonce (poste,date,lieu,email) VALUES ('$poste','$date','$lieu','$email')";
 

//Ex�cution de la requ�te
$query_ajout=mysql_query($sql) or die(mysql_error());
if($query_ajout){
    echo"<h2>votre annonce a �t� ajout�e dans la base</h2>";
    
}
?>