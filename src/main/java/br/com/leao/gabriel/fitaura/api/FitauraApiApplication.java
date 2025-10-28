package br.com.leao.gabriel.fitaura.api;

import br.com.leao.gabriel.fitaura.api.shared.utils.EnvUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitauraApiApplication {

	public static void main(String[] args) {
        System.setProperty("DB_HOST", EnvUtil.getEnv("DB_HOST"));
        System.setProperty("DB_NAME", EnvUtil.getEnv("DB_NAME"));
        System.setProperty("DB_USER", EnvUtil.getEnv("DB_USER"));
        System.setProperty("DB_PASSWORD", EnvUtil.getEnv("DB_PASSWORD"));

        SpringApplication.run(FitauraApiApplication.class, args);
	}
}
