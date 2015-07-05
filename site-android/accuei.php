

<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <!-- Start WOWSlider.com HEAD section --> <!-- add to the <head> of your page -->
	<link rel="stylesheet" type="text/css" href="engine1/style.css" />
	<script type="text/javascript" src="engine1/jquery.js"></script>
	<!-- End WOWSlider.com HEAD section -->
   
    <title>Page Title</title>


<body>
  
    <div class="page">
<header>
<?php
    include("head.php");
?>
    
    
</header>
<nav>
<?php
     echo include("navi.php");
?>

    
</nav>
<section>
    
     <!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
	<div id="wowslider-container1">
	<div class="ws_images"><ul>
		<li><img src="data1/images/i.jpg" alt="un univers" title="un univers" id="wows1_0"/></li>
		<li><img src="data1/images/im.jpg" alt="un but" title="un but" id="wows1_1"/></li>
		<li><img src="data1/images/ima.jpg" alt="des objectifs" title="des objectifs" id="wows1_2"/></li>
		<li><img src="data1/images/image.jpg" alt="une profession" title="une profession" id="wows1_3"/></li>
		<li><a href="http://wowslider.com/vi"><img src="data1/images/images.jpg" alt="javascript slider" title="des emplois" id="wows1_4"/></a></li>
		<li><img src="data1/images/inde.jpg" alt="des accords" title="des accords" id="wows1_5"/></li>
	</ul></div>
	<div class="ws_bullets"><div>
		<a href="#" title="un univers"><span><img src="data1/tooltips/i.jpg" alt="un univers"/>1</span></a>
		<a href="#" title="un but"><span><img src="data1/tooltips/im.jpg" alt="un but"/>2</span></a>
		<a href="#" title="des objectifs"><span><img src="data1/tooltips/ima.jpg" alt="des objectifs"/>3</span></a>
		<a href="#" title="une profession"><span><img src="data1/tooltips/image.jpg" alt="une profession"/>4</span></a>
		<a href="#" title="des emplois"><span><img src="data1/tooltips/images.jpg" alt="des emplois"/>5</span></a>
		<a href="#" title="des accords"><span><img src="data1/tooltips/inde.jpg" alt="des accords"/>6</span></a>
	</div></div><div class="ws_script" style="position:absolute;left:-99%"><a href="http://wowslider.com">responsive carousel</a> by WOWSlider.com v8.1</div>
	<div class="ws_shadow"></div>
	</div>	
	<script type="text/javascript" src="engine1/wowslider.js"></script>
	<script type="text/javascript" src="engine1/script.js"></script>
	<!-- End WOWSlider.com BODY section -->
   
    <?php
    include("section1.php");
?>
</section>
    <section>
    <?php
    include("section2.php");
?>
    </section>
    
    <section>
    
    <?php
    include("section3.php");
?>
    
    </section>

    <footer>
         <?php
    include("foot.php");
?>
        
    </footer>
    </div>
    
    </body>


</html>

