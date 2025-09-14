import java.io.File;

class FileFinder {
    public File findFileByName(File rootDir, String fileName) {
        if (!rootDir.isDirectory()) {
            return null;
        }

        File[] files = rootDir.listFiles();//Gets all files and directories directly inside rootDir directly
        if (files != null) {
            for (File file : files) {
                //check if the file matches my search
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file;
                }

                // If it's a directory, check the function again till find the file target
                if (file.isDirectory()) {
                    File fileFoundInSecondDic = findFileByName(file, fileName);
                    if (fileFoundInSecondDic != null) {
                        return fileFoundInSecondDic; // Found the file in subdirectory
                    }
                }
            }
        }
        return null;
    }
}