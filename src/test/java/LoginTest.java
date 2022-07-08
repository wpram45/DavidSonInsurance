import database.PostgreSQLJDBC;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    static  String[] usernames;
    static  String[] passwords;

    PostgreSQLJDBC postgreSQLJDBC=new PostgreSQLJDBC();

    static  boolean[] expectedOutcomes;

    boolean expected;

    static  int index=0;
    static  String username;
    static  String password;


    @BeforeAll
    static void setUp(){
        usernames = new String[] {"Alice","Alice","Alice","","user","admin"};
        passwords = new String[] {"12345678","123","password12345","12345678","123456789","*123admin*"};
        expectedOutcomes = new boolean[]{false,false,false,false,false,true};
    }

    @BeforeEach

    void createUser(){
        username = usernames[index];
        password = DigestUtils.md5Hex(String.valueOf(passwords[index]));
        expected = expectedOutcomes[index];
    }

    @AfterEach

    void incrementIndex(){
        index++;
    }


    @RepeatedTest(value = 6,name="gege")

    void isLoginValid(){

        assertEquals(expected, postgreSQLJDBC.loginOperation(username,password));
    }

}
