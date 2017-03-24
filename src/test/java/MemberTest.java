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

@Test
public void all_returnsAllInstancesOfMember_true(){
  Member firstMember = new Member("name");
  Member secondMember = new Member("name");
  assertEquals(true, Member.all().contains(firstMember));
  assertEquals(true, Member.all().contains(secondMember));
}
@Test
public void clear_emptiesAllMembersFromArrayList_0(){
  Member newMember = new Member("name");
  Member.clear();
  assertEquals(0, Member.all().size());
}

@Test
public void getId_MemberInstantiatesWithId_1(){
Member.clear();
Member newMember = new Member("name");
assertEquals(1, newMember.getId());
}

@Test
public void find_returnsMembersWithTheSameId_secondMember() {
  Member.clear();
  Member firstMember = new Member("name");
  Member secondMember = new Member("name");
  assertEquals(secondMember, Member.find(secondMember.getId()));
}
}
