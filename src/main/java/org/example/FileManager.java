package org.example;

import java.io.*;

public class FileManager {
    // метод для чтения содержимого файла
    public String read (String filePath) throws FileNotFoundException, IOException{
        if(filePath.contains(null)){
            throw new FileNotFoundException("filePath contains nothing please put correct file path");
        }
        // обьект для чтения файлов
        FileReader fileReader = new FileReader(filePath);
        // создаем буффер для чтения данныхиз файла
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // строка для хранения содержимого
        String content = "";

        try {
            //считываем содержимое
            String line;
            while ((line = bufferedReader.readLine()) != null){
                content += line + "n";
            }
        } finally {
            // закрываем файловые потоки
            bufferedReader.close();
            fileReader.close();
        }
        return  content;
    }// метод для записи данных в файл
    public void write (String content,  String filePath) throws IOException{
        //обьект для записи в файл
        FileWriter fileWriter = new FileWriter(filePath);

        try {
            fileWriter.write(content);
        }finally {
            fileWriter.close();
        }
    }
    // меод для копирования файла
    public void copy (String sourceFilePath,String destinationFilepath) throws  IOException{
        // обьекты для записи и чтения файлов
        FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFilepath);

        // буффер для чтения записи данных
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            // постипенно считываем и записоваем содержимое пока не дойдем до конца файла
            while ((bytesRead = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            fileOutputStream.close();
        }fileInputStream.close();
    }
}
