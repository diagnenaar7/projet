<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('esmt', $base) ;  

 $offre=$_GET['off'];
 
	  $chaine='';
      $sql = 'SELECT * FROM offres where Filieres="'.$offre.'"';   
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["id"].' '.$row["Filieres"].' '.$row["Entreprise"].' '.$row["Description"].'#' ;
	  }	
     echo $chaine.'!'; 
  mysql_close ();
?> 
 
 
 