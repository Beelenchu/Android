<?php 
   
    $conexion=mysqli_connect('localhost','root','','mydb');
    $comunaNombre = $_REQUEST["comunaNombre"];
    $resPoblacion = $_REQUEST["resPoblacion"];
    $resCalle = $_REQUEST["resCalle"];
    $resNumero = $_REQUEST["resNumero"];

    //$sql1 = "insert into pruebastring (nombreComuna) values ('$nombreComuna')";
    $sql1 = "select idComuna from comuna where comunaNombre = '$comunaNombre'";
    mysqli_set_charset($conexion,"utf8");
    $datos = Array();
    $result = mysqli_query($conexion, $sql1);
    while($row1=mysqli_fetch_assoc($result)){
       
        //$sql2 = "insert into residencia (comuna_idComuna) 
        //values ('$row1[idComuna]')";
        $sql2 = "insert into residencia (comuna_idComuna, resPoblacion, resCalle, resNumero) 
       values ('$row1[idComuna]','$resPoblacion', '$resCalle', '$resNumero')";
    }
    
    $result = mysqli_query($conexion, $sql2);
    mysqli_close($conexion);

/*
 while($row1=mysqli_fetch_assoc($result)){
        $datos = $row1;
    }
    echo json_encode($datos);

*/



    /*$comuna_idComuna = $_REQUEST["comuna_idComuna"];
    $resPoblacion = $_REQUEST["resPoblacion"];
    $resCalle = $_REQUEST["resCalle"];
    $resNumero = $_REQUEST["resNumero"];
    mysqli_set_charset($conexion,"utf8");

        $sql1="insert into residencia (comuna_idComuna, resPoblacion, resCalle, resNumero)
        values ('$comuna_idComuna', '$resPoblacion', '$resCalle', '$resNumero')";
        $result=mysqli_query($conexion, $sql1);
   
        mysqli_close($conexion);
*/
 ?>