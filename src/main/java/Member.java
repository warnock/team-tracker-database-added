import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Member {
  private String name;
  private int id;

  public Member(String name) {
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public static List<Member> all() {
    String sql = "SELECT id, name FROM members";
    try (Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Member.class);
    }

  }
  @Override
  public boolean equals(Object otherMember) {
    if (!(otherMember instanceof Member)) {
      return false;
    } else {
      Member newMember = (Member) otherMember;
      return this.getName().equals(newMember.getName()) && this.getId() == newMember.getId();
    }
  }
  public int getId(){
    return id;
  }

  public static Member find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM members where id=:id";
      Member member = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Member.class);
        return member;
    }

  }

  public void save (){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO members (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name) //"name" needs to match (:name) above.
      .executeUpdate()
      .getKey();
    }
  }
}
