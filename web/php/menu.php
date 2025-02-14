<?php
session_start();
// Bidaia erregistratzen denean, ondo edo txarto sortu bada, _Session -en gorde dugu (bidaia_gorde.php)
if (isset($_SESSION['mensaje'])) {
    // Para poder usar el Javascripten erabili ahal izateko
    $mensaje = $_SESSION['mensaje'];    
    // Borrar el mensaje junto a la sesión
    unset($_SESSION['mensaje']);
} else {
    $mensaje = '';
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>MENU</title>
    <link rel="stylesheet" href="../css/mainStyle.css">
    <link rel="stylesheet" href="../css/menuStyle.css">
        <script>
        // Bidaia ondo erregistratu bada datu basean, berriro kargatzen da orri hau, eta mezu bat agertzen da horrela izan dela adieraziz
        <?php if ($mensaje != ''): ?>
            window.onload = function() {
                alert("<?php echo $mensaje; ?>");
            };
        <?php endif; ?>
    </script>
</head>
<body>
    <header>
        <div class="Enlaces">
            <nav>
                <a href="../php/events.php">Eventos</a>
                <a href="../html/trips.html">Viajes</a>            
            </nav>
            <!-- <h4><?php echo $_SESSION['agencies']; ?></h4> -->
        </div>
        <div class="Perfil">
            <img src="" alt="">
        </div>
    </header>
    
</body>
</html>