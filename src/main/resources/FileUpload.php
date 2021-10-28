<?php
$target_Path = "images/";
$target_Path = $target_Path.basename( $_FILES['fileToUpload']['name'] );
move_uploaded_file( $_FILES['fileToUpload']['tmp_name'], $target_Path );

?>