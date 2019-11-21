<?php 
    $conexion=mysqli_connect('localhost','root','','db_as');
    $Region=$_REQUEST['idRegion'];

        $sql1="select idProvincia from provincia where region_idRegion = '$Region'";
        $result=mysqli_query($conexion, $sql1);
       // $cadena="<select class='form-control' id='selcomuna' name='selcomuna'>
         //   <option value=0 >Selecciona tu Comuna o Ciudad</option>'";
         mysqli_set_charset($conexion,"utf8");
         $datos = array();
            $sql2="";
        while($row1=mysqli_fetch_assoc($result)){

            $sql2 ="select idComuna, comunaNombre from comuna where provincia_idProvincia = '$row1[idProvincia]' order by comunaNombre";

            $result2 = mysqli_query($conexion, $sql2);

            while($row2=mysqli_fetch_assoc($result2)){
           //     $cadena=$cadena.'<option value='.$row2[0].'>'.$row2[1].'</option>';
           $datos[] = $row2;
            }
        }
        echo json_encode($datos);
        mysqli_close($conexion);
        //echo $cadena."</select>";


 ?>