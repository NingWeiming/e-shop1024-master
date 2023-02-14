package cn.nwm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@MapperScan("net.xdclass.mapper")
public class UserApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
