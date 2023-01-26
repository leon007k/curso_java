package temasvistos;

import java.util.Random;

public class Incremento {
	public int lives;
	public int score;
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void MarioGame() {
		Random rand = new Random();
		
		while(this.getLives() > 0) {
			int n  = rand.nextInt(2);
			System.out.println(n);
			if(n == 1) {
				this.lives--;
			}else {
				this.score++;
			}
		}
		
		System.out.println("Perdiste todas las vidas y tus puntos fueron: " + this.getScore());
	}
}
