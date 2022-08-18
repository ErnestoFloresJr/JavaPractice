import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Practice1 extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");
        Path thePath = Paths.get("README.md");
        Practice1 obj = new Practice1();
        BasicFileAttributes attributes = Files.readAttributes(thePath, BasicFileAttributes.class);
        obj.visitFile(thePath, attributes);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if(attrs.isRegularFile()){
            System.out.println("The File " + file + " is a regular file.");
            System.out.println("The size is " + attrs.size());
        }else{
            System.out.println("Note a regular file: " + file);
        }
        return FileVisitResult.TERMINATE;
    }
}
