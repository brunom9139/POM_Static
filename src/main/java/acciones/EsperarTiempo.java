package acciones;

import java.time.Duration;

public class EsperarTiempo {
    public EsperarTiempo() {
    }

    public static void esperar(int segundos) throws InterruptedException {
        long tiempoMiliSegundos = Duration.ofSeconds(segundos).toMillis();
        Thread.sleep(tiempoMiliSegundos);
    }
}
