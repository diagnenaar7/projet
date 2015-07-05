<?php

$base = mysql_connect ('127.0.0.1', 'root', ''); 

mysql_select_db ('esmt', $base) ;  

 $login=$_GET['login'];
 $password =$_GET['password'];

  
 $chaine='OK|';

       $sql = 'SELECT * FROM demandeur WHERE login = "'.$login.'" AND password="'.$password.'"';
	   
	  $req = mysql_query($sql);
     
      if ($data = mysql_fetch_array($req)) 
	 
	  
	 $chaine=$chaine.$data["id"].'   |'.$data["Nom"].'#' ;
	  
	  else 
	  
	$chaine='KO!';
	
     echo $chaine.'!';
 
  mysql_free_result ($req);  
  mysql_close ();
?>  
 
 
 