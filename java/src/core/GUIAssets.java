package core;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GUIAssets {

    public void selectPanel(ArrayList<JPanel> panels, int index) {

        for (JPanel panel: panels) {
            panel.setVisible(false);
        }

        panels.get(index).setVisible(true);
    }
    
    public boolean checkValidHexColor(String hexColor) {
    	
    	if (null == hexColor) {
    		return false;
    	}
    	
    	if (hexColor.length() != 7) {
    		return false;
    	}
    
    	for (int i = 0; i < hexColor.length(); i++) {
    		if ("#0123456789ABCDEF".indexOf(String.valueOf(hexColor.charAt(i)).toUpperCase()) == -1) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public int[] hexToIntArray(String hexColor) {
    	int[] ret = new int[3];
    	
    	ret[0] = Integer.parseInt(hexColor.substring(1, 3), 16);
    	ret[1] = Integer.parseInt(hexColor.substring(3, 5), 16);
    	ret[2] = Integer.parseInt(hexColor.substring(5, 7), 16);
    	
    	return ret;
    }
    
    public boolean urlImgValida(String ruta) {
        try {
            if (!ruta.toLowerCase().matches(".*\\.(jpg|jpeg|png|gif|bmp)$")) {
                return false; // No es una imagen por la extensión
            }

            // URI: identifica de manera unica e inequivoca un recurso en la red (definicion
            // de internet)
            URI uri = URI.create(ruta);
            URL url = uri.toURL(); // Convertir URI a URL

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD"); // Usamos "HEAD" para solo obtener los headers
            connection.setConnectTimeout(5000); // 5 segundos de espera
            connection.setReadTimeout(5000);

            // Obtener el tipo de contenido de la URL
            String contentType = connection.getContentType();

            // Verificar si el tipo de contenido es una imagen
            return contentType != null && contentType.startsWith("image/");
        } catch (Exception e) {
            return false; // no es una url valida
        }

    }
    
    public boolean isNumeric(String value) {
    	try {
    		Double.valueOf(value);
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
    
    public boolean isInt(String value) {
    	try {
    		Integer.valueOf(value);
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
}