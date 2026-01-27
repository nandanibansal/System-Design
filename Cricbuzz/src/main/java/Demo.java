import Match.Match;
import Match.MatchType;
import Match.T20Match;
import Team.Player.*;
import Team.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Demo {
    public static void main(String[] args) {
        Demo demoObj = new Demo();
        Team teamA = demoObj.addTeam("India");
        Team teamB = demoObj.addTeam("SriLanka");

        MatchType matchType = new T20Match();
        Match match = new Match(teamA, teamB, "SMS STADIUM", null, matchType);
        match.startMatch();
    }

    private Team addTeam(String name) {
        Queue<PlayerDetails> playerDetails = new LinkedList<>();
        PlayerDetails p1 = addPlayer(name + "1", PlayerType.ALL_ROUNDER);
        PlayerDetails p2 = addPlayer(name + "2", PlayerType.ALL_ROUNDER);
        PlayerDetails p3 = addPlayer(name + "3", PlayerType.ALL_ROUNDER);
        PlayerDetails p4 = addPlayer(name + "4", PlayerType.ALL_ROUNDER);
        PlayerDetails p5 = addPlayer(name + "5", PlayerType.ALL_ROUNDER);
        PlayerDetails p6 = addPlayer(name + "6", PlayerType.ALL_ROUNDER);
        PlayerDetails p7 = addPlayer(name + "7", PlayerType.ALL_ROUNDER);
        PlayerDetails p8 = addPlayer(name + "8", PlayerType.ALL_ROUNDER);
        PlayerDetails p9 = addPlayer(name + "9", PlayerType.ALL_ROUNDER);
        PlayerDetails p10 = addPlayer(name + "10", PlayerType.ALL_ROUNDER);
        PlayerDetails p11 = addPlayer(name + "11", PlayerType.ALL_ROUNDER);

        playerDetails.add(p1);
        playerDetails.add(p2);
        playerDetails.add(p3);
        playerDetails.add(p4);
        playerDetails.add(p5);
        playerDetails.add(p6);
        playerDetails.add(p7);
        playerDetails.add(p8);
        playerDetails.add(p9);
        playerDetails.add(p10);
        playerDetails.add(p11);

        List<PlayerDetails> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(name, playerDetails, new ArrayList<>(), bowlers);

        return team;
    }
    private PlayerDetails addPlayer(String name, PlayerType playerType) {
        Person person = new Person();
        person.name = name;
        PlayerDetails playerDetails = new PlayerDetails(person, playerType);
        return playerDetails;
    }
}