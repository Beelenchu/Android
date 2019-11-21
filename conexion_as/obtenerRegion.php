<?php
//header('Content-type: text/plain; charset=utf-8');

include 'conexion.php';
$pais = $_REQUEST["idPais"];

$consulta2 = "select idRegion, regionNombre
from region where pais_idPais = $pais";


$datos = array();
mysqli_set_charset($conexion,"utf8");
$result = mysqli_query($conexion,$consulta2);

while($row = mysqli_fetch_assoc($result)){
$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);


?>