//Proiect VVS

package test;

import main.Server_Java;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

public class Server_Test {
     private Server_Java server ;
    @Before
    public void beforeTest(){

        try {
            ServerSocket serverConnect = new ServerSocket(8081);
            server = new Server_Java(serverConnect.accept());
            Thread thread = new Thread(server);
            thread.start();
        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }
    @Test
    public void testDefault(){
        try {
            server.handleDefault();
            Assert.assertEquals(Server_Java.DEFAULT_FILE,server.getFileShown());
        }catch (IOException e) {
        assert false;

        }

    }
    @Test
    public void testMaintenance(){
        try {
            server.handleMaintenance();
            Assert.assertEquals(Server_Java.MAINTENANCE,server.getFileShown());
        }catch (IOException e) {
            assert false;

        }

    }
    @Test
    public void testUnsupported(){
        try {
            server.handleUnsupported();
            Assert.assertEquals(Server_Java.METHOD_NOT_SUPPORTED,server.getFileShown());
        }catch (IOException e) {
            assert false;

        }

    }

}

