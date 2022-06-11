import java.io.File;
import java.io.FilenameFilter;

public class FileNumberFilter implements FilenameFilter {

    private final int maxFileNumber;
    private int fileCount; //记录文件数

    public FileNumberFilter(int maxFileNumber) {
        this.maxFileNumber = maxFileNumber;
    }

    @Override
    public boolean accept(File dir, String name) {
        if (fileCount >= maxFileNumber)
            return false;
        else
            fileCount++;
        return true;
    }
}
