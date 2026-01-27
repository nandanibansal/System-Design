package Match;

import Innings.*;
import Team.Team;

public class Match {
    Team teamA;
    Team teamB;
    String venue;
    Team tossWinner;
    InningDetails[] innings;
    MatchType matchType;

    public Match(Team teamA, Team teamB, String venue, Team tossWinner, MatchType matchType){
        this.teamA = teamA;
        this.teamB = teamB;
        this.venue = venue;
        this.tossWinner = tossWinner;
        this.matchType = matchType;
        innings = new InningDetails[2];
    }

    public void startMatch(){
        tossWinner = toss(teamA, teamB);
        for (int inning = 1; inning <= 2; inning++) {
            InningDetails inningDetails;
            Team bowlingTeam;
            Team battingTeam;

            //assuming here that tossWinner batFirst
            boolean isChasing = false;

            if (inning == 1) {
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
                inningDetails.start(-1);
            }
            else {
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
                inningDetails.start(innings[0].getTotalRuns());
                if (bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                    bowlingTeam.isWinner = true;
                }
            }

            innings[inning - 1] = inningDetails;
            System.out.println();
            System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.getTeamName() + "---");
            battingTeam.printBattingScoreCard();
            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.getTeamName() + "---");
            bowlingTeam.printBowlingScoreCard();
        }

        System.out.println();
        if (teamA.isWinner) {
            System.out.println("---WINNER---" + teamA.getTeamName());
        } else {
            System.out.println("---WINNER---" + teamB.getTeamName());
        }
    }

    private Team toss(Team teamA, Team teamB) {
        //random function return value between 0 and 1
        if (Math.random() < 0.5) {
            return teamA;
        } else {
            return teamB;
        }
    }



}
