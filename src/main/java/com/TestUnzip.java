import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestUnzip {


    public static void main(String[] args) throws IOException {
        File tarFile = new File("C:\\Users\\6620\\Desktop\\存證測試用資料夾\\PNVAN-2-5C-202107123000.zip");
        File directory = new File("D:\\憑證暫存區");
        unZip(tarFile,directory);

    }

    public static List<String> unZip(File tarFile, File directory) throws IOException {

        if (directory == null) {
            directory = new File(".");
        }

        List<String> result = new ArrayList<String>();
        InputStream inputStream = new FileInputStream(tarFile);
        ZipArchiveInputStream in = new ZipArchiveInputStream(inputStream);
        ZipArchiveEntry entry = in.getNextZipEntry();
        while (entry != null) {
            if (entry.isDirectory()) {
                entry = in.getNextZipEntry();
                continue;
            }
            String entryName = new String(entry.getRawName(), "MS950");
            System.out.println("unziping " + entryName);
            File curfile = new File(directory, entryName);
            File parent = curfile.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            OutputStream out = new FileOutputStream(curfile);
            IOUtils.copy(in, out);
            out.close();
            result.add(entryName);
            entry = in.getNextZipEntry();
        }
        in.close();
        return result;
    }





}


