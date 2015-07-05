<?php
//Appel du fichier de connexion
require_once('connexion_db.php');
//Définition de la requête
$sql="select id,poste,date,lieu from annonce";
$rep=mysql_query($sql) or die(mysql_error());
?>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        
    </head>
<body>

<div class="annoce">
    <h1> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LISTE DES ANNONCES </h1>
<table border="3px">
    
    
            <tr>
                <th>numero</th>
                <th>poste</th>
                <th>date</th>
                <th>lieu</th>
                </tr>
            
    
 <?php
            while($annonce=mysql_fetch_object($rep)){
                echo"<tr>
                        <td>$annonce->id</td>
                        <td>$annonce->poste</td>
                        <td>$annonce->date</td>
                        <td>$annonce->lieu</td>
                   </tr>";
            }
            ?>
        </table>


</div>
    </body>
</html>