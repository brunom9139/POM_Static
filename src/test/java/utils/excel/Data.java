package utils.excel;

import factory.Session;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import reader.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.util.List;

public class Data {
    public synchronized static String get(String columnName) throws Exception {
        return ExcelRead.getInstance().getValue(columnName);
    }

    public static  int existSheet(String nameSheet){
        int i=0;
        while (i<Common.listSheet.size()){
            if (SheetData.getSheet().equalsIgnoreCase(nameSheet)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static DataParallel getDataParallel(String sessionId){
        for (int i = 0; i < Common.listParallel.size(); i++) {
            if (Common.listParallel.get(i).getSessionId().equals(sessionId)){
                return Common.listParallel.get(i);
            }
        }
        return null;
    }

    public static int getPositionOutline(String testCaseId,String sessionId){
        int contador=-1;
        for (int i = 0; i < Common.listParallel.size(); i++) {
            if (Common.listParallel.get(i).getTestCaseId().equals(testCaseId)){
                contador ++;
            }
            if (Common.listParallel.get(i).getSessionId().equals(sessionId))break;
        }
        return contador;
    }

    public static void setearTagsExcel(List<String> tags) throws IOException {
        DownloadFileHook();
        DataParallel data = new DataParallel();
        data.setModulo(tags.get(1).replace("@", ""));
        data.setTestCaseId(tags.get(tags.size() - 1));
        SessionId sessionId = ((RemoteWebDriver) Session.getInstance().getWebDriver()).getSessionId();
        data.setSessionId(sessionId.toString());
        GlobalData.setSessionId(sessionId.toString()); // Almacena el sessionId globalmente
        Common.listParallel.add(data);
    }

    public static void DownloadFileHook() throws IOException {
        if (ConfigReader.obtenerBanderaDescargaExcel().trim().equalsIgnoreCase("true")){
            downloadFile();
        }
    }

    public static void downloadFile() throws IOException {
        System.out.println("-------------- Steps For Download Excel --------------");
        File file = File.createTempFile("substances", "tmp");

        URL url = new URL(ConfigReader.obtenerUrlExcel().trim());

        System.out.println("--------------downloading file from " + url);

        try {
            FileUtils.copyURLToFile(url, file);
            Path destinationPath = FileSystems.getDefault().getPath(ConfigReader.obtenerRutaDescarga().trim());
            File destinationFile = new File(destinationPath+"\\" +ConfigReader.obtenerNombreExcel().trim());
            System.out.println("--------------downloading finished--------------");

            Files.move( file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
