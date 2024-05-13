import com.example.familyconnect.model.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAccountTest {

    private UserAccount account;

    @BeforeEach
    void setUp() {
        account = new UserAccount(50,"John Smith", "js");
    }
    @Test
    public void testGetId() {
        account.setId(100);
        assertEquals(100, account.getId());
    }
    @Test
    public void testGetUsername() {
        assertEquals("John Smith", account.getUserName());
    }
    @Test
    public void testSetFirstName() {
        account.setUsername("Jane Smith");
        assertEquals("Jane Smith", account.getUserName());
    }
    @Test
    public void testGetPassword() {
        assertEquals("js", account.getPassword());
    }
    @Test
    public void testSetPassword() {
        account.setPassword("JSmithy");
        assertEquals("JSmithy", account.getPassword());
    }

}
