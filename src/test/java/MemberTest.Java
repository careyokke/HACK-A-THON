import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Before
  public void tearDown() {
    Member.clear();
  }