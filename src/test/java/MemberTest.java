import org.junit.*;
import static org.junit.Assert.*;


public class MemberTest {

@Test
public void Member_instantiatesCorrectly_true() {
  Member newMember = new Member("name");
  assertEquals(true, newMember instanceof Member);
}

@Test
public void getName_getsNameValue_name() {
  Member newMember = new Member("name");
  assertEquals("name", newMember.getName());
}


}
