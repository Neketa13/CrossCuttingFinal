package Archive;

import Archive.Archive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchiving implements Archive {
    @Override
    public void archiving(String fileName) throws IOException {
        ZipOutputStream zout=new ZipOutputStream(new FileOutputStream("D://Java_laba/Cross-CuttingTask/archive.zip"));
        ZipEntry entry=new ZipEntry("output.txt");
        zout.putNextEntry(entry);
        FileInputStream fis=new FileInputStream(fileName);
        byte[]buffer=new byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();
        zout.close();
    }

    @Override
    public void deArchiving(String input) {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(input)))
        {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName();
                size=entry.getSize();
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                FileOutputStream fout = new FileOutputStream("D://Java_laba/Cross-CuttingTask/ZIP" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
