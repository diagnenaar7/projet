




<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('esmt', $base) ;  

$idof=$_GET["identite"];
$fil=$_GET["filiere"];
$entre=$_GET["entreprise"];
$desc=$_GET["description"];

 $sql = "INSERT into favoris (id,filieres,entreprise,description)VALUES ('$idof','$fil','$entre','$desc')";
 //$sql = "INSERT into favoris VALUES ('1','test','tstcolso','test')";
 
 $req = mysql_query($sql);
 

 if ($req==true)
 $chaine='OK';


 else 
 
 $chaine='KO'; 
 echo $chaine;
 
 mysql_free_result ($req);
 mysql_close();
 
?> 
 
 
 
 
 
 
 