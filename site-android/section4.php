<?php
//Appel du fichier de connexion
require_once('connexion_db.php');
//Définition de la requête
$sql="select duree,entreprise,niveau,contact from stage";
$rep=mysql_query($sql) or die(mysql_error());
?>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        
    </head>
<body>

<div class="annoce">
    <h2> LISTE DES ANNONCES DE STAGES </h2>
<table border="3px">
    
    
            <tr>
                <th>duree</th>
                <th>entreprise</th>
                <th>niveau</th>
				<th>contact</th>
                
                </tr>
            
    
 <?php
            while($stage=mysql_fetch_object($rep)){
                echo"<tr>
                        
                        <td>$stage->duree</td>
                        <td>$stage->entreprise</td>
                        <td>$stage->niveau</td>
						<td>$stage->contact</td>
                   </tr>";
            }
            ?>
        </table>


</div>
    </body>
</html>