package com.example.frequency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  * Класс для конфигурации контекста и запуска Spring приложения
 */
@SpringBootApplication(scanBasePackages = {"com.example.controller","com.example.service"})
public class FrequencyApplication {
	/**
	 * метод запускает Spring приложение
	 * @param args параметры не используются в приложении
	 */
	public static void main(String[] args) {
		SpringApplication.run(FrequencyApplication.class, args);
	}
}
