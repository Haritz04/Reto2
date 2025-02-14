<?php
session_start();

$host = "10.5.6.169"; 
$servername = "localhost";
$username = "root";        
$password = "";         
$dbname = "db_turismo";    

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


// Crea los dos objetos de
$startDate = date_create('start');
$endDate = date_create('end');

// Calcula la diferencia de tiempo entre los dos objetos
$duration = date_diff($startDate, $endDate);

// Muestra el resultado
echo $duration->format('Difference between two dates: %R%a days');

// Datos del formulario
$name = $_POST['name'];
$idTravelType = $_POST['descriptionType'];
$startDate = $_POST['start'];
$endDate = $_POST['end'];
$duration = $_POST['duration'];
$description = $_POST['description'];
$notIncdescServiceNotIncludedluded = $_POST['descServiceNotIncluded'];

$sql = "INSERT INTO travels ('name', 'idTravelType', 'travelDate', 'travelDate', 'duration', 'description', 'notIncdescServiceNotIncludedluded')
        VALUES ('$name', '$idTravelType', '$startDate', '$duartion','$description', '$descServiceNotIncluded')";

// Ejecutar consulta
if ($conn->query($sql) === TRUE) {
    // Mensaje registrado exitosamente en la base de datos
    $_SESSION['mensaje'] = "Se ha registrado bien el viaje";
} else {
    // Si se ha registrado mal en la base de datos
    $_SESSION['mensaje'] = "Ha habido un error: " . $conn->error;
}

// Cerrar conexion
$conn->close();

// Devolver mensaje al menu.php (Aunque se haya hecho bien o mal. ¿O tal vez si sale mal nos quedamos en la misma página?)
header("Location: menu.php");
exit();
?>

