package week01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

// 自定义一个Classloader，加载一个Hello.xlass文件，执行hello方法，
// 此文件内容是一个Hello.class文件所有字节（x=255-x）处理后的文件。
public class OwnClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            // 调用完ClassLoader后，通过反射调用方法
            Class<?> cls = new OwnClassLoader().findClass("Hello");
            Object obj = cls.newInstance();
            Method method = cls.getDeclaredMethod("hello");
            method.invoke(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 需要读取Hello.xlass文件
        InputStream inputStream = null;
        byte[] bytes = null;
        try {
            // 逐个字节读取，需要用255-该字节，即可还原
            inputStream = new FileInputStream("src/Hello.xlass");
            bytes = new byte[inputStream.available()];
            int tempByte;
            int index = 0;
            while ((tempByte = inputStream.read()) != -1) {
                bytes[index] = (byte) (255-tempByte);
                index += 1;
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
