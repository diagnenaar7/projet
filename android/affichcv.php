<?php
$base = new PDO('mysql:host=localhost;dbname=esmt','root','');  
  


	  
      $sql =$base->query( 'SELECT * FROM cv ');   
	  
     
	  while ($data = $sql->fetch()) {
	   echo $data["prenom"].'
	  '.$data["nom"].'
	  '.$data["objectif"].'
	  '.$data["diplome"].'
	  '.$data["experience"] ;
	 
	  }	
      $sql->closeCursor();
	  
	  
  //mysql_close ();

?> 
