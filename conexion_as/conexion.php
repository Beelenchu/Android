<?php
$hostname = 'localhost';
$database = 'mydb';
$username = 'root';
$password = '';

$conexion = new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
    echo "lo sentimos, la conexión ha fallado!";
}
?>