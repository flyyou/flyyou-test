package cassandra.exam.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class CommonUtil {

    /**
     * 리턴된 ByteBuffer 객체에서 문자열 추출
     * @param buffer
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String byteBufferToString(ByteBuffer buffer) throws 


    UnsupportedEncodingException{
        byte[] bytes = new byte[buffer.limit() - buffer.position()];
        buffer.get(bytes);
        String re = new String(bytes, "UTF-8");
        return re; 
    }
}