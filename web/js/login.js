// Detecta si hay un error en la URL y muestra un mensaje
window.onload = function() {   
    // Obtiene los parámetros de la URL (lo que aparece después del '?')
    const parametrosUrl = new URLSearchParams(window.location.search);

    // Comprobar si está escrito 'errorea' y si su valor es '1'    
    if (parametrosUrl.has('error') && parametrosUrl.get('error') === '1') {   

        // Si la condición es verdadera, mostramos el mensaje de error (cambiar su estilo para hacerlo visible)
        document.getElementById('error1').style.display = 'block';
        
    } else {
        // Si no se cumple la condición, ocultar el mensaje de error (asegurando que esté invisible)
        document.getElementById('error1').style.display = 'none';
    }
};
