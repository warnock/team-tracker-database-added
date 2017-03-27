import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;


public class MemberTest {
  @Before
  public void setUp(){
    DB.sql2o = new Sql2o ("jdbc:postgresql://localhost:5432/team_tracker_test", null, null);
  }
  @After
  public void tearDown(){
    try (Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM members *;";
      con.createQuery(sql).executeUpdate();
    }
  }

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
  public void equals_returnsTrueIfNameAretheSame() {
    Member firstMember = new Member("name");
    Member secondMember = new Member("name");
    assertTrue(firstMember.equals(secondMember));
 }

  

  @Test
  public void save_returnsTrueIfNameAretheSame() {
    Member myMember = new Member ("name");
    myMember.save();
    assertTrue(Member.all().get(0).equals(myMember));
  }

  @Test
  public void all_returnsAllInstancesOfMember_true(){
    Member firstMember = new Member("name");
    firstMember.save();
    Member secondMember = new Member("sam");
    secondMember.save();
    assertEquals(true, Member.all().get(0).equals(firstMember));
    assertEquals(true, Member.all().get(1).equals(secondMember));
  }
  @Test
  public void save_assignsIdToObject() {
    Member myMember = new Member("name");
    myMember.save();
    Member savedMember = Member.all().get(0);
    assertEquals(myMember.getId(), savedMember.getId());
  }

  @Test
  public void clear_emptiesAllMembersFromArrayList_0(){
    Member newMember = new Member("name");
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_MemberInstantiatesWithId_1(){
  Member myMember = new Member("name");
  myMember.save();
  assertTrue(myMember.getId() > 0);
  }

  @Test
  public void find_returnsMembersWithTheSameId_secondMember() {
    Member firstMember = new Member("name");
    firstMember.save();
    Member secondMember = new Member("sam");
    secondMember.save();
    assertEquals(secondMember, Member.find(secondMember.getId()));
  }
}
