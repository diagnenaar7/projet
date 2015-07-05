<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('esmt', $base) ;  

	  $chaine='';
      $sql = 'SELECT * FROM offres';   
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["categorie"].'   |'.$row["Entreprise"].'   |'.$row["Profil"].'   |'.$row["Description"].' #' ;
	  }	
     echo $chaine.'!'; 
  mysql_close ();
?> 
 
 
 