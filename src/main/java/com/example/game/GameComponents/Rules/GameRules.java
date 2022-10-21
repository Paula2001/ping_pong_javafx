package com.example.game.GameComponents.Rules;

import com.example.game.GameComponents.Ball.PingPongBall;

public class GameRules {
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;

    private final PingPongBall ball;

    private Players playerScoredGoal = Players.NONE;

    private static final int RIGHT_BOUNDARY = -20;
    private static final int LEFT_BOUNDARY = 600;

    public GameRules(PingPongBall ball){
        this.ball = ball;
    }

    public boolean isGoal(){
        boolean firstPlayerGoal = this.ball.getBall().getLayoutX() < RIGHT_BOUNDARY;
        boolean secondPlayerGoal = this.ball.getBall().getLayoutX() > LEFT_BOUNDARY;

        if (firstPlayerGoal){
            playerScoredGoal = Players.FIRST_PLAYER;
            return true;
        }

        if (secondPlayerGoal){
            playerScoredGoal = Players.SECOND_PLAYER;
            return true;
        }
        return false;
    }

    public void goalActions(){
        this.countGoal();
        this.ball.centerBall();
    }

    private void countGoal(){
        if(isGoalForFirstPlayer()) {
            this.firstPlayerScore += 1;
        }else if (isGoalForSecondPlayer()){
            this.secondPlayerScore += 1;
        }
        playerScoredGoal = Players.NONE;
    }

    public boolean checkGameEnded(){
        return firstPlayerScore >= 10 || secondPlayerScore >= 10;
    }

    public String announceTheWinner(){

        if (firstPlayerScore >= 10){
            return "first player won ! シ";
        }else{
            return "second player won ! シ";
        }

    }

    private boolean isGoalForFirstPlayer(){
        return playerScoredGoal == Players.FIRST_PLAYER;
    }

    private boolean isGoalForSecondPlayer(){
        return playerScoredGoal == Players.SECOND_PLAYER;
    }

    public int getFirstPlayerScore(){
        return this.firstPlayerScore;
    }

    public int getSecondPlayerScore(){
        return this.secondPlayerScore;
    }
}
