package com.ivan.ppois.task_07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task01Test {

    @Test
    void shouldEncryptSingleWordWithCipherAtTheEnd() { // Должен корректно заменять биграмму на самом конце слова
        // Arrange
        String input = "Рыжик";
        String expected = "Рыжж";
        // Act
        String result = Task01.encryptString(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldWriteAndReadStringUsingTempFile(@TempDir Path tempDir) throws IOException {
        // Arrange
        // 1.1 Сформированная строка
        String originalString = "Маленький кот Рыжик прыгал под старым сараем.";
        // Создаем путь к файлу внутри временной папки Maven-проекта
        Path tempFile = tempDir.resolve("test_output.txt");

        // Act
        // 1.2 Записываем строку в файл (создаст файл автоматически)
        Files.writeString(tempFile, originalString);
        // 2. Читаем строку из файла и выводим в консоль
        String readString = Files.readString(tempFile);
        System.out.println("String from file: " + readString);
        // 3.1 Шифруем строку
        String encryptedString = Task01.encryptString(readString);
        // 3.2 Записываем зашифрованную строку в файл
        Files.writeString(tempFile, encryptedString);
        // Читаем строку из файла и выводим в консоль
        encryptedString = Files.readString(tempFile);
        System.out.println("Encrypted String from file: " + encryptedString);

        // Assert
        assertEquals(originalString, readString);
        assertEquals(encryptedString, "Маюнький кот Рыжж прыгал под старым щраем.");
        // Файл удалится автоматически силами JUnit 5 сразу после выхода из метода
    }
}
