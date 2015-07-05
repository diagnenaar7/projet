




<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('esmt', $base) ;  

$idof=$_GET["offre"];
$can=$_GET["matricule"];
 $chaine='OK|';
 
 $sql = "INSERT into candidature (idcandidat,idposte) VALUES ('$can','$idof')";
 
 $req = mysql_query($sql);
 
 if ($req==true)
 $chaine='OK!';

 else 
 
$chaine='KO!'; 
 
  echo $chaine;
 mysql_free_result ($req);
 mysql_close();
 
?> 
 
 
 
 
 
 
 