import java.util.ArrayList;
import java.util.List;

// Represents a file with a name
class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Represents a directory that can contain files and other directories
class Directory {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Directory> subDirectories = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void addDirectory(Directory directory) {
        this.subDirectories.add(directory);
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }
}

public class Archivist {
    public List<File> findFilesByExtension(Directory directory, String fileExtension) {
        List<File> listOfJavaExtension = new ArrayList<>();

        for (File file : directory.getFiles()){
            if(file.getName().endsWith(fileExtension)) {
                listOfJavaExtension.add(file);
            }
        }

        //to check sub-directory
        for (Directory subDirectory : directory.getSubDirectories()){
            listOfJavaExtension.addAll(findFilesByExtension(subDirectory, fileExtension));
        }
        return listOfJavaExtension;
    }

    public static void main(String[] args) {
        // Create a sample directory structure
        Directory root = new Directory("root");
        Directory src = new Directory("src");
        Directory lib = new Directory("lib");

        root.addDirectory(src);
        root.addDirectory(lib);

        src.addFile(new File("Main.java"));
        src.addFile(new File("Utils.java"));
        lib.addFile(new File("library.jar"));

        Directory test = new Directory("test");
        src.addDirectory(test);
        test.addFile(new File("MainTest.java"));

        Archivist archivist = new Archivist();
        List<File> javaFiles = archivist.findFilesByExtension(root, ".java");

        System.out.println("Java files found:");
        for (File file : javaFiles) {
            System.out.println(file.getName());
        }
    }
}