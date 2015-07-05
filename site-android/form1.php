

<form method="post" action="ajoutannonce.php" name="formannoce">
  <h2> VEILLEZ METTRE VOTRE ANNONCE</h2>
<div class="field">
  <label for="poste" ">Poste*</label><br />
  
    <textarea cols="15" rows="3" name="poste"   required autofocus>ingénieur en ...</textarea>
</div><br />


<div class="field">
  <label for="day">Date de Publication:*</label><br />
  <input type="date" name="date"   required>
</div><br />

<div class="field">
  <label for="lieu">Lieu:*</label><br />
  <input name="lieu" type="text" required>
</div><br />



<div class="email">
  <label>Email:*</label><br />
  <input name="email" required>
</div><br />



<div id="info">
<legend>* champ obligatoire</legend><br />
</div>



<div id="boutons">
  <input name="retablir" value="Rétablir" type="reset">
  <input name="envoi" value="Envoyer" type="submit">
</div>

</form>

