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

// Consulta SQL
$sql = "SELECT * FROM agencies WHERE name = '$name' AND password = '$password'";

// Ejecutar consulta
$result = $conn->query($sql);

// Asegurar que exista usuario
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $_SESSION['agency'] = $row['name']; // Guardamos el nombre de la agencia para mostrar en el cabecero
    }
    // En caso de encotrar registro, logeamos y ejecutamos:la hoja menu.php
    header("Location: menu.php");
    exit();
} else {
    // Si no existe mandamos mensaje de error (A través de un URL)
    header("Location: ../html/login.html?error=1");
    exit();
}

// Cerrar conexión
$conn->close();
?>
