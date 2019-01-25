package com.genesis.utils.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午9:12 2019/1/25
 * @modified by:
 */

public class GFileUtil {
    public static List<String> getImageFilesInDirectory(String dirPath, String prefixURI) {
        File file = new File(dirPath);
        return getImageFiles(file, prefixURI);
    }

    public static List<String> getFilesInDirectory(String dirPath, String suffix) {
        File file = new File(dirPath);
        return getImageFiles(file, suffix);
    }

    private static List<String> getFilesBySuffix(File file, String suffix) {
        List<String> imageFilesInDirectory = new ArrayList<>();

        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }

        for (File lf : listFiles) {
            if (lf.isFile()) {
                if (lf.getName().endsWith("." + suffix)) {
                    String fileName = extractFileName(lf.toString());
                    imageFilesInDirectory.add(fileName);
                }
            } else {
                if (lf.isDirectory()) {
                    getFilesBySuffix(lf, suffix);
                }
            }
        }

        Collections.sort(imageFilesInDirectory);

        return imageFilesInDirectory;
    }

    private static List<String> getImageFiles(File file, String prefixURI) {
        List<String> imageFilesInDirectory = new ArrayList<>();

        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }

        for (File lf : listFiles) {
            if (lf.isFile()) {
                if (lf.getName().endsWith(".png") || lf.getName().endsWith(".jpg") || lf.getName().endsWith(".jpeg")) {
                    String fileName = extractFileName(lf.toString());
                    imageFilesInDirectory.add(prefixURI + fileName);
                }
            } else {
                if (lf.isDirectory()) {
                    getImageFiles(lf, prefixURI);
                }
            }
        }

        Collections.sort(imageFilesInDirectory);

        return imageFilesInDirectory;
    }

    public static String extractFileName(String filePath) {
        return extractFileName(filePath, File.separator);
    }

    public static String extractFileName(String filePath,
                                         String fileSeparator) {
        int nPos = -1;
        if (fileSeparator == null) {
            nPos = filePath.lastIndexOf(File.separatorChar);
            if (nPos < 0) {
                nPos = filePath
                        .lastIndexOf(File.separatorChar == '/' ? '\\' : '/');
            }
        } else {
            nPos = filePath.lastIndexOf(fileSeparator);
        }

        if (nPos < 0) {
            return filePath;
        }

        return filePath.substring(nPos + 1);
    }
}
