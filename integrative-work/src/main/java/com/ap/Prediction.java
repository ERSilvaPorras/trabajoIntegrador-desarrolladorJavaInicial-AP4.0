package com.ap;

public class Prediction {
    private Game game;
    private Team team;
    private ResultEnum result;

    Prediction(Game game, Team team, ResultEnum result) {
        this.game = game;
        this.team = team;
        this.result = result;
    }

    public Game getGame() {
        return game;
    }

    public Team getTeam() {
        return team;
    }

    public ResultEnum getResult() {
        return result;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public int points() throws Exception {
        if(this.game.result(this.team) == this.result) {
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return this.result + "."; // esto debemos cambiarlo
    }

}
