<?php

include 'conexion.php';
mysqli_set_charset($conexion,"utf8");
$userRut =  $_REQUEST["userRut"];
$userNombre = $_REQUEST["userNombre"];
$userApellidos = $_REQUEST["userApellidos"];
$userFechaNac = $_REQUEST["userFechaNac"];

//$consulta = "insert into users (userApellidos) 
//values ('$userApellidos')";

$consulta = "insert into users (userRut, userNombre, userApellidos, userFechaNac) 
values ('$userRut','$userNombre','$userApellidos','$userFechaNac')";

$result = mysqli_query($conexion, $consulta);

mysqli_close($conexion);
?>