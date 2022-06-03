import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public static void saveGame (String filePath, GameProgress gameProgress) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameProgress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String fileZipPath, List<String> list) {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(fileZipPath))) {
                for (String filePath : list) {
                    try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                        ZipEntry zipEntry = new ZipEntry(filePath);
                        zipOutputStream.putNextEntry(zipEntry);
                        byte[] buffer = new byte[fileInputStream.available()];
                        fileInputStream.read(buffer);
                        zipOutputStream.write(buffer);
                        zipOutputStream.closeEntry();
                        File file = new File(filePath);
                        file.delete();
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}