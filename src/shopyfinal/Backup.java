/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Suthar
 */
public class Backup {

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                return deleteDir(new File(dir, children[i]));
            }
        }

        return dir.delete();
    }

    public static void copyDir(Path src, Path dest) throws IOException {
        Files.walk(src)
                .forEach(source -> {
                    try {
                        Files.copy(source, dest.resolve(src.relativize(source)),
                                StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void main(String strfrom, String strto) {

        Runnable r = new Runnable() {
            public void run() {
                File from = new File(strfrom);
                File to = new File(strto);
                int cout = 0;
                while (to.exists()) {
                    deleteDir(to);
                    cout++;
                }
                deleteDir(to);
                to.delete();
                System.out.println(cout + "  Times");

                try {
                    copyDir(from.toPath(), to.toPath());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                MessageOnTimeOfSuccess.mainn("Backup saved Successfully");
                System.exit(1);
            }

        };

        new Thread(r).start();
        new GIF("BACKUP").setVisible(true);

    }

}
