package actions;

import java.time.Duration;

public class EsperarTiempo {
    public void esperar(int segundos) throws InterruptedException {
        long tiempoMiliSegundos = Duration.ofSeconds(segundos).toMillis();
        Thread.sleep(tiempoMiliSegundos);
    }
}
