package Archive;

import Archive.Archive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

public class JarArchiving implements Archive {
    @Override
    public void archiving(String fileName) throws IOException {
        JarOutputStream jout=new JarOutputStream(new FileOutputStream("D://file/archive.jar"));
        JarEntry entry=new JarEntry("input.txt");
        jout.putNextEntry(entry);
        FileInputStream fis=new FileInputStream(fileName);
        byte[]buffer=new byte[fis.available()];
        fis.read(buffer);
        jout.write(buffer);
        jout.closeEntry();
        jout.close();
    }


    @Override
    public void deArchiving(String input) {
        try(JarInputStream jar = new JarInputStream(new FileInputStream(input)))
        {

            JarEntry entry;
            String name;
            long size;
            while((entry=  jar.getNextJarEntry())!=null){

                name = entry.getName();
                size=entry.getSize();
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка
                FileOutputStream fout = new FileOutputStream("D://file/JAR" + name);
                for (int c = jar.read(); c != -1; c = jar.read()) {
                    fout.write(c);
                }
                fout.flush();
                jar.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }
}
