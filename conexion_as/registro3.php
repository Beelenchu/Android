<?php

include 'conexion.php';
mysqli_set_charset($conexion,"utf8");
$userCorreo =  $_REQUEST["userCorreo"];
$userNumeroContacto = $_REQUEST["userNumeroContacto"];
$password = $_REQUEST["password"];
$userRut =  $_REQUEST["userRut"];
$passHash = password_hash($password, PASSWORD_BCRYPT);
$consulta = "update users set userCorreo = '$userCorreo', userNumeroContacto = '$userNumeroContacto', password = '$passHash' where userRut = '$userRut'"; 


//$consulta = "insert into users (userCorreo, userNumeroContacto, password) 
//values ('$userCorreo', '$userNumeroContacto', '$password')";
$result = mysqli_query($conexion, $consulta);

mysqli_close($conexion);
?>