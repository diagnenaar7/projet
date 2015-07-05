
<form method="post" action="" name="form_inscription">
  <h1> Formulaire d'inscription</h1>
<div class="field">
  <label for="nom">Nom:*</label><br />
  <input name="nom" type="text" required autofocus >
</div>

<div class="field">
  <label for="prenom">Prenoms:*</label><br />
  <input name="prenom" type="text" required>
</div>

<div class="field">
  <label for="birthday">Date de naissance:*</label><br />
  <input type="date" name="birthday" required>
</div>

<div class="field">
  <label for="lieu">Lieu de naissance:*</label><br />
  <input type="text" name="lieu" required>
</div>


<div class="field">
  <label>Sexe*:</label><br />
  <input name="sexe" value="M" type="radio">M
  <input name="sexe" value="F" type="radio">F
</div>
<div class="field">
  <label>Adresse:</label><br />
  <textarea cols="15" rows="3" name="adresse" >j'habite a ...</textarea>
   </div>

<div class="tel">
  <label>Tel. portable:</label><br />
  <input name="Tel">
</div>

<div class="email">
  <label>Email:*</label><br />
  <input name="email" required>
</div>
<div class="field">
  <label for="email">Confirmer l'Email:*</label><br />
  <input type="mail" name="email" placeholder="Retaper votre 
email" required>
</div>


<div class="field">
  <label for="filiere">Filière choisie*:</label><br />
  <select name="filiere" required>
    <option></option>
    <option value="1">Licence</option>
    <option value="2">Master</option>
    <option value="3">Doctorat</option>
  </select>
</div>

<div class="field">
  <label>Donner un mot de pass:*</label><br />
  <input type="mail" required>
</div>

<div class="field">
  <label>Confirmer le mot de pass:*</label><br />
  <input type="mail" autocomplete=”off” required>
</div>

<div id="info">
<legend>* champ obligatoire</legend><br />
</div>



<div id="boutons">
  <input name="retablir" value="Rétablir" type="reset">
  <input name="envoi" value="Envoyer" type="submit">
</div>
</form>
