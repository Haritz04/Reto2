<?php
session_start();

$servername = "localhost:3307";
$username = "root";
$password = "";
$dbname = "db_reto2_t";
?>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>EVENTOS</title>
    <link rel="stylesheet" href="../css/mainStyle.css">
    <link rel="stylesheet" href="../css/eventsStyle.css">
    <link rel="stylesheet" href="../css/menuStyle.css">
</head>
<main>
<body onload="buttonLoad()">
    <header>
        <div class="Enlaces">
            <nav>
                <a href="../php/menu.php">Atrás</a>
            </nav>
        </div>
        <div class="Perfil">
            <!-- <h4><?php echo $_SESSION['agency']; ?></h4> -->
            <img src="" alt="">
        </div>
    </header>
    <div class="tipos">            
        <input type="radio" id="flightsBtn" name="events" value="Flights" onchange="showFlights()">
        <label for="html">Flights</label>
        
        <input type="radio" id="accommodationBtn" name="events" value="Accommodation" onchange="showAcommodation()">
        <label for="html">Accommodation</label>
        
        <input type="radio" id="otherBtn" name="events" value="Other" onchange="showOthers()">
        <label for="html">Other</label>        
    </div>

    <div id="flightDiv">
    <form action="./save_events.php">
    <h1>Vuelo</h1>
    <table>
            <tr>
                <td><label for="airportStart">Aeropuerto de inicio: </label></td>
                <td><select id="airportStart" name="airportStart" required>
                    <option value="idAirportStart">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT aid, name FROM airports";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            <tr>
            <td><label for="airportEnd">Aeropuerto de llegada: </label></td>
                <td><select id="airportEnd" name="airportEnd" required>
                    <option value="idAirportEnd">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT aid, name FROM airports";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            <tr>
                <td><label for="airline">Aerolinea: </label></td>
                <td><select id="airline" name="airline" required>
                    <option value="idAirline">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT aid, name FROM airlines";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            <tr>
                <td><label for="code">Código: </label></td>
                <td><input id="code" type="text" name="code" /></td>
            </tr>
            <tr>
                <td><label for="price">Precio: </label></td>
                <td><input id="price" type="number" name="price" /></td>
            </tr>
            <tr>
                <td><label for="start">Inicio: </label></td>
                <td><input id="start" type="date" name="start" /></td>
            </tr>
            <tr>
                <td><label for="duration">Duración: </label></td>
                <td><input id="duration" type="number" name="duration" /></td>
            </tr>
    </table>
    </form>
    </div>

    <div id="accommodationDiv">
    <form action="./save_events.php">
    <h1>Vuelo</h1>
    <table>
            <tr>
                <td><label for="idTravel">Vuelo: </label></td>
                <td><select id="idTravel" name="idTravel" required>
                    <option value="idTravel">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT name FROM travels";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            <tr>
            <td><label for="idCity">Ciudad: </label></td>
                <td><select id="idCity" name="idCity" required>
                    <option value="name">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT name FROM cities";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            <tr>
                <td><label for="idRoomType">Tipo de habitación: </label></td>
                <td><select id="idRoomType" name="idRoomType" required>
                    <option value="idAirline">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT aid, name FROM roomtypes";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            <tr>
                <td><label for="name">Nombre: </label></td>
                <td><input id="name" type="text" name="name" /></td>
            </tr>
            <tr>
                <td><label for="price">Precio: </label></td>
                <td><input id="price" type="number" name="price" /></td>
            </tr>
            <tr>
                <td><label for="start">Entrada: </label></td>
                <td><input id="start" type="date" name="start" /></td>
            </tr>
            <tr>
                <td><label for="exit">Salida: </label></td>
                <td><input id="exit" type="date" name="exit" /></td>
            </tr>
    </table>
    </form>
    </div>

    <div id="otherDiv">
    <form action="./save_events.php">
    <h1>Vuelo</h1>
    <table>
            <tr>
                <td><label for="idTravel">Vuelo: </label></td>
                <td><select id="idTravel" name="idTravel" required>
                    <option value="idTravel">--Elegir--</option>
                    <?php
                    //Desde la BASE DE DATOS
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT name FROM travels";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['aid'] . "'>" . $row['name'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
                </select></td>
            </tr>
            
            <tr>
                <td><label for="name">Nombre: </label></td>
                <td><input id="name" type="text" name="name" /></td>
            </tr>
            <tr>
                <td><label for="date">Fecha de evento: </label></td>
                <td><input id="date" type="date" name="date" /></td>
            </tr>
            <tr>
                <td><label for="description">Descripción: </label></td>
                <td><Textarea id="description" rows="5"></Textarea></td>
            </tr>
            <tr>
                <td><label for="price">Precio: </label></td>
                <td><input id="price" type="number" name="price" /></td>
            </tr>
    </table>
    </form>
    </div>
    
          
    
    <footer>
        <a href="">Sobre nosotros</a>
        <a href="">Contactanos</a>
    </footer>
<script src="../js/main.js"></script>
<script src="../js/events.js"></script>
</body>
</html>