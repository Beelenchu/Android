<?php
//header('Content-type: text/plain; charset=utf-8');

include 'conexion.php';
$region = $_REQUEST['idRegion'];
$datos = array();
mysqli_set_charset($conexion,"utf8");
$consulta2 = "select idProvincia, from provincia where region_idRegion = '$region'";

$result = mysqli_query($conexion,$consulta2);

while($row = mysqli_fetch_assoc($result)){
$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);


?>