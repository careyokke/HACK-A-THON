import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

  public class App {
  public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

      get("/members/view/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Member member = Member.find(Integer.parseInt(request.params(":id")));
        model.put("member", member);
        model.put("template", "templates/member.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/teams/view/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Team team = Team.find(Integer.parseInt(request.params(":id")));
        model.put("team", team);
        model.put("template", "templates/team.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/members", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("members", Member.all());
        model.put("template", "templates/members.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/members", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Team team = Team.find(Integer.parseInt(request.queryParams("teamId")));
        String memberName = request.queryParams("memberName");
        Member newMember = new Member(memberName);
        newMember.setTeam(team);
        team.addMember(newMember);
        model.put("teams", Team.all());
        model.put("template", "templates/teams.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      //model.put("members", request.session().attribute("members"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

      get("teams/:id/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

      get("teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String teamName = request.queryParams("teamName");
      Team newTeam = new Team(teamName);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
