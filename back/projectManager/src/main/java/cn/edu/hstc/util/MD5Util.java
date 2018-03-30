package cn.edu.hstc.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;

/**
 * 用户密码加密工具
 * @author:yifang
 * 原理：
 * 1.根据已有的密码字符串去生成一个密码+盐字符串,可以将盐的加密字符串也存放在数据库(看需求),
 * 2.验证时将提交的密码字符串进行同样的加密，再从数据库中取得已有的盐，进行组合密码+盐的字符串，和已有的进行验证
 * 3.目前我把盐password.salt放在resources/project-manager.properties文件中
 */
public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 返回大写MD5
     *
     * @param origin 待加密字符串
     * @param charsetname 编码格式
     * @return
     */
    private static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString.toUpperCase();
    }

    /**
     * salt 加密
     * @param origin
     * @return
     */
    public static String MD5EncodeUtf8(String origin) {
        origin = origin + PropertiesUtil.getProperty("password.salt", "");
        return MD5Encode(origin, "utf-8");
    }


    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

}
