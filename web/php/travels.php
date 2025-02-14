<?php
session_start();
?>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="XXXXXXX">
    <link rel="stylesheet" href="../css/servicesStyle.css">

    <title>Menu</title>
    <script>
        XXXXXXX
        </script>
  </head>
<body>
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
        <form action="./save_events.php">
    <h1>Vuelo</h1>
        <table>

                <tr>
                <td><label for="idTravelType">: </label></td>
                    <td><select id="idTravelType" name="idTravelType" required>
                        <option value="idTraveltype">--Elegir--</option>
                        <?php
                        //Desde la BASE DE DATOS
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT aid FROM travelTypes";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['aid'] . "'>" . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                    </select></td>
                </tr>
                <tr>
                    <td><label for="idAgency">Agencia: </label></td>
                    <td><select id="idAgency" name="idAgency" required>
                        <option value="idAirline">--Elegir--</option>
                        <?php
                        //Desde la BASE DE DATOS
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT aid, name FROM agencies";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['aid'] . "'>" . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                    </select></td>
                </tr>
                <tr>
                    <td><label for="name">Nombre: : </label></td>
                    <td><input id="name" type="text" name="name" /></td>
                </tr>
                <tr>
                    <td><label for="description">Descripción: </label></td>
                    <td><textarea name="description" id="description" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td><label for="travelDate">Inicio: </label></td>
                    <td><input id="travelDate" type="date" name="travelDate" /></td>
                </tr>
                <tr>
                    <td><label for="duration">Duración: </label></td>
                    <td><input id="duration" type="number" name="duration" /></td>
                </tr>
                <tr>
                    <td><label for="descServiceNotIncluded">Servicios no incluidos: </label></td>
                    <td><textarea name="descServiceNotIncluded" id="descServiceNotIncluded" rows="5"></textarea></td>
                </tr>
        </table>
    <script src="newTrip.js"></script>
</body>
</html>