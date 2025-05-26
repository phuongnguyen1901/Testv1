package Common;

import org.apache.commons.lang.RandomStringUtils;

import java.util.UUID;

public class RandomName {
    public static String generateValue () {
        String randomUUID = RandomStringUtils.randomAlphabetic(20);
        return randomUUID;
    }

    public static String pathImg (String className) {
        return Constans.folderImgReport + "Img_" + className + "_" + UUID.randomUUID() + ".jpg";
    }

    public static String pathVideoAvi (String className) {
        return Constans.folderVideoReport + className + ".avi";
    }

    public static String VideoAvi (String className) {
        return "Video_Avi_" + className + "_" + UUID.randomUUID();
    }

    public static String pathVideoMp4 (String className) {
        return Constans.folderVideoReport + "Video_Mp4_" + className + "_" + UUID.randomUUID() + ".mp4";
    }

    public static String pathImgEvidence () {
        return Constans.folderImgReport + UUID.randomUUID() + ".jpg";

    }
    public static String pathVideoEvidence () {
        return Constans.folderVideoReport + UUID.randomUUID() + ".avi";
    }
}
