package com.example.game.GameComponents.Rules;

import com.example.game.GameComponents.Ball.PingPongBall;

public class GameRules {
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;

    private final PingPongBall ball;

    public GameRules(PingPongBall ball){
        this.ball = ball;
    }

    public boolean isGoal(){
        return this.ball.getLayoutYDir() > 0 || this.ball.getLayoutYDir() < 100; // TODO : change this later
    }

    public void goalActions(){
        this.countGoal();
        this.ball.centerBall();
    }

    private void countGoal(){
        if(isGoalForFirstPlayer(ball)) {
            this.firstPlayerScore += 1;
        }else if (isGoalForSecondPlayer(ball)){
            this.secondPlayerScore += 1;
        }
    }

    public boolean checkGameEnded(){
        return firstPlayerScore > 10 || secondPlayerScore > 10;
    }

    public String announceTheWinner(){

        if (firstPlayerScore > 10){
            return "first player won ! シ";
        }else{
            return "second player won ! シ";
        }

    }

    private boolean isGoalForFirstPlayer(PingPongBall ball){
        return false;
    }

    private boolean isGoalForSecondPlayer(PingPongBall ball){
        return false;
    }
}
