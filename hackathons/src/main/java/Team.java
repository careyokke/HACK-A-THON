import java.util.List;
import java.util.ArrayList;

public class Team {
  private int mteamId;
  private String mTeamName;

  private static List<Team> instances = new ArrayList<Team>();
  private List<Member> mMembers;

  public Team(String teamName) {
      instances.add(this);
      mteamId =  instances.size();
      mTeamName = teamName;
      mMembers = new ArrayList<Member>();
    }
    public List<Member> getAllMembers(){
      return mMembers;
    }
    public void addMember(Member member) {
      mMembers.add(member);
    }
    public String getTeamName() {
    return mTeamName;
    }

    public static List<Team> all() {
      return instances;
    }

    public static void clear() {
      instances.clear();
    }

    public int getId() {
      return mteamId;
    }

    public static Team find(int id) {
      return instances.get(id -1);
    }

    public List<Member> getMembers() {
      return mMembers;
    }
  }
