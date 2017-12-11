package com.leftwing871;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class useFile {
    public static void main(String[] args) throws IOException {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src/main/java/com/leftwing871", "DateAndTime.java");
        System.out.println(filePath.toString());


        File f = new File("FileEx1.java");
        String fileName = f.getName();
        int pos = fileName.lastIndexOf(".");

        System.out.println("경로를 제외한 파일이름 - " + f.getName());
        System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0, pos));

        System.out.println("확장자 - " + fileName.substring(pos + 1));

        System.out.println("경로를 포함한 파일이름 - " + f.getPath());
        System.out.println("파일의 절대경로 - " + f.getAbsolutePath());
        System.out.println("파일의 정규경로 - " + f.getCanonicalPath());

        System.out.println("");

        System.out.println("File.pathSeparator - " + File.pathSeparator);
        System.out.println("File.separatorChar - " + File.separatorChar);

        System.out.println();

        System.out.println("user.dir=" + System.getProperty("user.dir"));
        System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));

        args = new String[1];

        args[0] = "/Users/eunhaklee";

        if(args.length != 1) {
            System.out.println("USAGE : java FileEx2 DIRECTORY");
            System.exit(0);
        }

        File ff = new File(args[0]);

        if(!ff.exists() || !ff.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리 입니다.");
            System.exit(0);
        }

        File[] files = f.listFiles();

        for(int i=0; i < files.length;i++) {
            String fileNamexx = files[i].getName();
            System.out.println(files[i].isDirectory() ? "[" + fileNamexx + "]" : fileNamexx);
        }
    }
}
