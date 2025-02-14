<?php
// iniciar $_SESSION
session_start();

// Parametros para conectar con BBDD

$servername = "localhost:3307";
$username = "root";
$password = "";
$dbname = "db_reto2_t";

// Conectarse
$conn = new mysqli($servername, $username, $password, $dbname);

// Autentificar conexion
if ($conn->connect_error) {
    die("Fallo en la conexión: " . $conn->connect_error);
}

// Recuperar datos de formulario
$name = $_POST['name'];
$password = $_POST['password'];
$agencyType = $_POST['type'];
$logo = $_POST ['logo'];
$color = $_POST ['color'];
$maxEmp = $_POST['maxEmp'];

// Consulta SQL
$sql = "INSERT INTO agencies ('name', 'password', 'logo', 'color', 'idMaxEmployees','idAgencyType')
        VALUES ('$name', '$password', '$logo', '$color','$maxEmp', '$agencyType')";

// Ejecutar consulta
if ($conn->query($sql) === TRUE) {
    // Mensaje registrado exitosamente en la base de datos
    $_SESSION['mensaje'] = "Se ha registrado";

    header("Location: menu.php");

} else {
    // Si se ha registrado mal en la base de datos
    $_SESSION['mensaje'] = "Ha habido un error: " . $conn->error;
}

// Cerrar conexión
$conn->close();
?>
