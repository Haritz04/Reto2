<?php
session_start();

$servername = "localhost";
$username = "root";        
$password = "";         
$dbname = "db_turismo";    

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

function saveFlight(){
    // Datos de formulario
    $airportStart = $_POST ['airportStart'];
    $airportEnd = $_POST ['airportEnd'];
    $airline = $_POST ['airline'];
    $code = $_POST['code'];
    $price = $_POST['price'];
    $start = $_POST ['start'];
    $duration = $_POST ['duration'];
    


    $sql = "INSERT INTO flights ('idAirportStart', 'idAirportEnd', 'idAirline', 'code', 'price', 'startMoment', 'duration')
            VALUES ('$airportStart', '$airportEnd', '$airline', '$code', '$price', '$start','$duration')";

    // Ejecutar consulta
    if ($conn->query($sql) === TRUE) {
        // Mezua baldin eta ondo erregistratu den datu basean
        $_SESSION['mensaje'] = "Bidaia ondo erregistratu da";
    } else {
        // Mezua baldin eta txarto erregistratu den datu basean
        $_SESSION['mensaje'] = "Errorea suertatu da: " . $conn->error;
    }
}
function saveAccomodation(){
    // Datos de formulario
    $idTrvel = $_POST ['idTravel'];
    $idCity = $_POST ['idCity'];
    $idRoomType = $_POST ['idRoomType'];
    $name = $_POST['name'];
    $price = $_POST['price'];
    $start = $_POST ['start'];
    $exit = $_POST ['exit'];
    


    $sql = "INSERT INTO flights ('idAirportStart', 'idAirportEnd', 'idAirline', 'code', 'price', 'startMoment', 'duration')
            VALUES ('$airportStart', '$airportEnd', '$airline', '$code', '$price', '$start','$duration')";

    // Ejecutar consulta
    if ($conn->query($sql) === TRUE) {
        // Mezua baldin eta ondo erregistratu den datu basean
        $_SESSION['mensaje'] = "Bidaia ondo erregistratu da";
    } else {
        // Mezua baldin eta txarto erregistratu den datu basean
        $_SESSION['mensaje'] = "Errorea suertatu da: " . $conn->error;
    }
}

function saveOther(){
    // Datos de formulario
    $idTrvel = $_POST ['idTravel'];
    $name = $_POST['name'];
    $start = $_POST ['start'];
    $description = $_POST ['description'];
    $price = $_POST['price'];   


    $sql = "INSERT INTO flights ('idAirportStart', 'idAirportEnd', 'idAirline', 'code', 'price', 'startMoment', 'duration')
            VALUES ('$airportStart', '$airportEnd', '$airline', '$code', '$price', '$start','$duration')";

    // Ejecutar consulta
    if ($conn->query($sql) === TRUE) {
        // Mezua baldin eta ondo erregistratu den datu basean
        $_SESSION['mensaje'] = "Bidaia ondo erregistratu da";
    } else {
        // Mezua baldin eta txarto erregistratu den datu basean
        $_SESSION['mensaje'] = "Errorea suertatu da: " . $conn->error;
    }
}


// KOnexioa itxi
$conn->close();

// Menua.php-ra itzuli (bai ondo ala txarto egin den erregistroa.. edo agian txarto egiten bada mantentzen gara orri berean?)
header("Location: menua.php");
exit();
?>
?>
