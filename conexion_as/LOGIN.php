<?php 
$conn=mysqli_connect('localhost','root','','mydb');


      //Meto los valores que nos ha dado en el campo de iniciar sesión.
      $rut = $_REQUEST['userRut'];
      $pass = $_REQUEST['password'];
      mysqli_set_charset($conn,"utf8");
      //$passHash = password_hash($pass, PASSWORD_BCRYPT);
      //echo $rut;
      //echo $pass;
      //Verificamos si existe un usuario con ese nombre
      $datos = Array();
      $datos2 = Array();
      //$result = mysqli_query($conn, "SELECT * FROM users WHERE userRut = '$rut'");
      $result = mysqli_query($conn, "select * from users where userRut = '$rut'");

     
      if($result->num_rows > 0) {
       // echo "existe ese nombre de usuario <br>";

        $row = $result->fetch_array(MYSQLI_ASSOC);
      }
      //$datos2["success"] = false;
      
  if (password_verify($pass, $row['password'])) {
          $_SESSION['loggedin'] = true;
          $_SESSION['userRut'] = $rut;
          $_SESSION['start'] = time();
          $result2 = mysqli_query($conn, "select * from users where userRut = '$rut'");
          $datos2["success"] = true;
          while($row1=mysqli_fetch_assoc($result2)){
        
            //$datos = $row1;
           // $datos2["success"] = true;
            echo "true";
        }
        
        }else{
          echo "false";
        }
     
   
     

        //Cogemos la contraseña de la BD
/*
 if($result->num_rows > 0) {
        echo "existe ese nombre de usuario <br>";

        $row = $result->fetch_array(MYSQLI_ASSOC);
      }
  if (password_verify($pass, $row['password'])) {
          $_SESSION['loggedin'] = true;
          $_SESSION['userRut'] = $rut;
          $_SESSION['start'] = time();

           echo "Sesión iniciada" . $_SESSION['userRut'];
        }
*/
      
       
        mysqli_close($conn);




 ?>