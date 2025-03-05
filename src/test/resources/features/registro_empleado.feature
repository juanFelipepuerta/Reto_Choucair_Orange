#Autor: Juan Felipe Puerta
#language:en

Feature: Registro y validacion de empleado en OrangeHRM

  Como usuario del sistema OrangeHRM
  Quiero iniciar sesion, registrar un nuevo empleado y verificar su existencia
  Para asegurarme de que el registro fue exitoso

  @RegistroExitoso
  Scenario Outline: Registro y validacion de un nuevo empleado en OrangeHRM
    Given el actor ingresa a la pagina de OrangeHRM
      | url   |
      | <url> |
    When el actor se autentica con la siguiente informacion
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And el actor accede a PIM y agrega un empleado
      | nombre     | segundoNombre   | apellido    | idEmpleado |
      | <nombre>   | <segundoNombre> | <apellido>  | <idEmpleado> |
    And el actor selecciona create login details para terminar de diligenciar el formulario
      | nombreUsuario     | contrasenaRegistro   |
      | <nombreUsuario>   | <contrasenaRegistro> |

    Then se presenta el mensaje se ha creado el registro manera exitosa
      | mensajeExitoso   |
      | <mensajeExitoso> |
    And  el actor accede a PIM y realiza una busqueda del empleado creado anteriormente
    And  se muestra el empleado en los resultados de la búsqueda

    Examples:
      | url                       | usuario       | contrasena   | nombre | segundoNombre | apellido | idEmpleado |nombreUsuario|contrasenaRegistro |mensajeExitoso|

      ##@externaldata@src/test/resources/datadriven/data.xlsx@usuarios
   |https://opensource-demo.orangehrmlive.com/web/index.php/auth/login   |Admin   |admin123   |Juan   |Felipe   |Perez   |1890   |JuanPuerta   |JuanPu3rta**   |Successfully Saved|

#se agrega comentario