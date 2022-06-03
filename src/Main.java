import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String filePath = "/Users/sergey/Desktop/Работа/Учеба/GitHW/HomeWork/HomeWork3_6/savegames/";
    private final static String fileZipPath = "/Users/sergey/Desktop/Работа/Учеба/GitHW/HomeWork/HomeWork3_6/savegames/zip.zip";
    private final static List<String> fileList = new ArrayList<>();
    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(1 , 2, 1, 100.2);
        GameProgress gameProgress2 = new GameProgress(1 , 2, 1, 200.2);
        GameProgress gameProgress3 = new GameProgress(1 , 2, 1, 300.2);
        GameProgress.saveGame(filePath + "gameProgress1", gameProgress1);
        fileList.add(filePath + "gameProgress1");
        GameProgress.saveGame(filePath + "gameProgress2", gameProgress2);
        fileList.add(filePath + "gameProgress2");
        GameProgress.saveGame(filePath + "gameProgress3", gameProgress3);
        fileList.add(filePath + "gameProgress3");
        GameProgress.zipFiles(fileZipPath, fileList);
    }
}
