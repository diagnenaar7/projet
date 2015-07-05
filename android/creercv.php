<?php

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('esmt', $base) ;  
 
 $ident=$_GET['matricule'];
 $prenom=$_GET['prenom'];
 $nom=$_GET['nom'];
 $objectif=$_GET['objectif'];
 $diplome=$_GET['diplome'];
 $experience=$_GET['experience'];

 $sql = "INSERT into cv (id,prenom,nom, objectif,diplome,experience) VALUES ('$prenom','$nom', '$objectif','$diplome', '$experience')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 