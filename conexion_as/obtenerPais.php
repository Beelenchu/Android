<?php
include 'conexion.php';
$consulta = "select * from pais";
$datos = Array();
$result = mysqli_query($conexion,$consulta);

while($row = mysqli_fetch_object($result)){
$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);
?>