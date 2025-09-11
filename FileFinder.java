import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

class FileFinder {
    //example path & file name from my PC
//    public static void main(String[] args) {
//        FileFinder finder = new FileFinder();
//
//        File rootDir = new File("C:\\Users\\hi\\code_creators_git");
//        String fileName = "Back around.txt";
//
//        File foundFile = finder.findFileByName(rootDir, fileName);
//
//        if (foundFile != null) {
//            System.out.println("File found at: " + foundFile.getAbsolutePath());
//        } else {
//            System.out.println("File not found.");
//        }
//    }
    /**
     * TO-DO: Change this method to be recursive.
     \*
     * This method searches for a file with a specific name within a directory
     * and its subdirectories. The current implementation uses a Queue for an
     * iterative, breadth-first search.
     \*
     * @param rootDir The directory to start the search from.
     * @param fileName The name of the file to find.
     * @return The File object if found, otherwise null.
     */
    public File findFileByName(File rootDir, String fileName) {
        if (!rootDir.isDirectory()) {
            return null;
        }
//        Queue<File> queue = new LinkedList<>();
//        queue.offer(rootDir);

//        while (!queue.isEmpty()) {
//            File current = queue.poll();
//            File[] files = current.listFiles();
//            if (files != null) {
//                for (File file : files) {
//                    if (file.isDirectory()) {
//                        queue.offer(file);
//                    } else if (file.getName().equals(fileName)) {
//                        return file;
//                    }
//                }
//            }
//        }
        File[] files = rootDir.listFiles();//Gets all files and directories directly inside rootDir directly
        if (files != null) {
            for (File file : files) {
                // Check if the file matches
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