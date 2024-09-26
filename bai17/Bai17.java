/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai17;
       import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Bai17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 
//public //<editor-fold defaultstate="collapsed" desc="comment">
class
//</editor-fold>
 Main {

    // Khóa tệp (File lock)
    private static FileLock lock;
    private static FileChannel channel;
    private static final String LOCK_FILE_PATH = "app.lock";  // Đường dẫn tệp khóa

    // Thể hiện duy nhất (Singleton instance)
    private static Main instance;

    // Constructor riêng tư để ngăn tạo nhiều thể hiện
    private Main() {}

    // Phương thức tĩnh để lấy thể hiện duy nhất của Main
    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    // Kiểm tra xem chương trình đã chạy hay chưa
    private static boolean isAppRunning() {
        try {
            File lockFile = new File(LOCK_FILE_PATH);
            if (!lockFile.exists()) {
                lockFile.createNewFile();
            }

            // Mở kênh tệp
            channel = new RandomAccessFile(lockFile, "rw").getChannel();
            lock = channel.tryLock();
            
            // Trả về true nếu không thể khóa (tức là đã có chương trình khác đang chạy)
            return lock == null;
        } catch (IOException e) {
            return true;
        }
    }

    // Giải phóng khóa khi chương trình kết thúc
    private static void releaseLock() {
        try {
            if (lock != null) {
                lock.release();
            }
            if (channel != null) {
                channel.close();
            }
        } catch (IOException e) {
        }
    }

    public void run() {
        // Tạo danh sách sinh viên
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mai", 22));
        students.add(new Student("Dung", 20));
        students.add(new Student("Lan", 23));

        // Sắp xếp sinh viên theo tuổi sử dụng lambda (lập trình hàm)
        Collections.sort(students, (s1, s2) -> s1.compareTo(s2));

        // Hiển thị danh sách sinh viên đã sắp xếp
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        // Kiểm tra nếu có một thể hiện khác của chương trình đang chạy
        if (isAppRunning()) {
            System.out.println("Chương trình đã được chạy ở một thể hiện khác.");
            return;  // Thoát nếu một thể hiện khác đang chạy
        }

        // Lấy thể hiện duy nhất và chạy chương trình
        Main.getInstance().run();

        // Giải phóng khóa khi chương trình kết thúc
        Runtime.getRuntime().addShutdownHook(new Thread(Main::releaseLock));
    }
}

    }
    
}
