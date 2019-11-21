<?php 
    $conexion=mysqli_connect('localhost','root','','db_as');
    $Region=$_REQUEST['idRegion'];

        $sql1="SELECT idProvincia FROM provincia WHERE region_idRegion = '$Region'";
        $result=mysqli_query($conexion, $sql1);
        $cadena="<select class='form-control' id='selcomuna' name='selcomuna'>
          <option value=0 >Selecciona tu Comuna o Ciudad</option>'";
        
           // $sql2="";
        while($row1=mysqli_fetch_row($result)){

            $sql2 ="SELECT idComuna, comunaNombre FROM comuna WHERE provincia_idProvincia = '$row1[0]' ORDER BY comunaNombre";

            $result2 = mysqli_query($conexion, $sql2);


            while($row2=mysqli_fetch_row($result2)){
                $cadena=$cadena.'<option value='.$row2[0].'>'.$row2[1].'</option>';
           
            }
        }
       
        echo $cadena."</select>";


 ?>