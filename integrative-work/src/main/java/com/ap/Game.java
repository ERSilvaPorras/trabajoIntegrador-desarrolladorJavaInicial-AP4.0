package com.ap;

enum ResultEnum {
    WINNER,
    TIE,
    LOSER
}

public class Game {
    private Team team1;
    private Team team2;
    private int team1Goals;
    private int team2Goals;

    Game(Team team1, Team team2, int team1Goals, int team2Goals) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
    }

    public Team getTeam1() {
        return team1;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    
    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }

    public ResultEnum result(Team team) throws Exception{
        int teamGoals;
        int otherTeamGoals;
        if(team.equals(team1)) {
            teamGoals = team1Goals;
            otherTeamGoals = team2Goals;
        } else if(team.equals(team2)) {
            teamGoals = team2Goals;
            otherTeamGoals = team1Goals;
        } else {
            throw new Exception("El equipo ingresado no corresponde a este partido.");
        }
        if(teamGoals > otherTeamGoals)
            return ResultEnum.WINNER;
        else if(teamGoals == otherTeamGoals)
            return ResultEnum.TIE;
        else
            return ResultEnum.LOSER;
    }

    @Override
    public String toString() {
        return this.team1.getName() + " " + this.team1Goals + " - " + this.team2Goals + " " + this.team2.getName();
    }
}
