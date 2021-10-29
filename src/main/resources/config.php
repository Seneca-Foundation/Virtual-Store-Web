<?php
    $localhost = "localhost";
    $dbusername = "postgres";
    $dbpassword = "";
    $dbname = "virtual-store-web";

    $conn = mysqli_connect($localhost,$dbusername,$dbpassword,$dbname);

    if(isset($_POST["submit"]))
    {
        $title = $_POST["title"];
        $pname = rand(1000,10000)."-".$_FILES["file"]["name"];
        $tname = $_FILES["files"]["tmp_name"]
        $uploads_dir = 'resources/images';
        move_uploaded_file($tname,$uploads_dir.'/'.$pname);
        $sql = "INSERT into fileup(title,image) VALUES('$title','$pname')";

        if (mysqli_query($conn,$sql))
        {
            echo "File successfully uploaded";
        }
        else {
            echo "Error";
        }
    }
?>