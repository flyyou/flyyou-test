package cassandra.exam.basic;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.Column;
import org.apache.cassandra.thrift.ColumnParent;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.NotFoundException;
import org.apache.cassandra.thrift.TimedOutException;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


/**
 * <pre>
 * 컬럼 입력하기
 * 
 * http://examples.oreilly.com/0636920010852/
 * 사이트의 소스를 활용하여 작성하였음을 밝힘
 * 
 * </pre>
 * @author 조한중[hanjoongcho@gmail.com]
 * @since 2012년 09월 08일
 */
public class WriteMain {

    /**
     * 인코딩
     */
    private static final String UTF8 = "UTF8";
    
    /**
     * IP
     */
    private static final String HOST = "70.4.82.99";
    
    /**
     * PORT
     */
    private static final int PORT = 9160;
    
    /**
     * 키스페이스
     */
    private static final String KEY_SPACE = "MyKeyspace";

    /**
     * 컬럼페밀리
     */
    private static final String COLUMN_FAMILY = "User";
    
    private static final ConsistencyLevel CL = ConsistencyLevel.ONE;
    
    public static void main(String[] args) throws InvalidRequestException, TException, 


    UnsupportedEncodingException, NotFoundException, UnavailableException, TimedOutException {
        
        
        TTransport transport = new TSocket(HOST, PORT);
        TFramedTransport framedTransport = new TFramedTransport(transport);
        TProtocol protocol = new TBinaryProtocol(framedTransport);
        Cassandra.Client client = new Cassandra.Client(protocol);
        framedTransport.open();
        client.set_keyspace(KEY_SPACE);
        ColumnParent columnParent = new ColumnParent(COLUMN_FAMILY);
        
        Column gender = new Column();

        // 성별입력
        gender.setName("name".getBytes(UTF8));
        gender.setValue("안석식".getBytes(UTF8));
        gender.setTimestamp(System.currentTimeMillis());
        client.insert(ByteBuffer.wrap("ahn1".getBytes(UTF8)), columnParent, gender, CL);
        
        // 나이입력
        gender.setName("email".getBytes(UTF8));
        gender.setValue("flyyou@gmail.com".getBytes(UTF8));
        gender.setTimestamp(System.currentTimeMillis());
        client.insert(ByteBuffer.wrap("ahn1".getBytes(UTF8)), columnParent, gender, CL);
        
        // 전화번호 입력
        gender.setName("tel".getBytes(UTF8));
        gender.setValue("010-3111-2222".getBytes(UTF8));
        gender.setTimestamp(System.currentTimeMillis());
        client.insert(ByteBuffer.wrap("ahn1".getBytes(UTF8)), columnParent, gender, CL);
        
        
        framedTransport.close();
    }
}