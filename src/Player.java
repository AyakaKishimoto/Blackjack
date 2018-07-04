

public class Player {

	private String name;
	private int cardA = (int)(Math.random()*13 + 1);
	private int cardB = (int)(Math.random()*13 + 1);
	private int addCard = 0;
	private int gameContinue = 0;

	Player(String name){
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	public int getCardA() {
		return this.cardA;
	}
	public int getCardB() {
		return this.cardB;
	}
	public int getAddCard() {
		return this.addCard;
	}
	public int getGameContinue() {
		return this.gameContinue;
	}
	public void setGameContinue(int gameContinue) {
		this.gameContinue = gameContinue;
	}
	public void setCardB(int cardB) {
		this.cardB = cardB;
	}

	//ゲーム開始一回目

	public int score() {
		return this.addCard = this.cardA + this.cardB;
	}
	public void game_1() {
		if(spCard()) {
			 massage21();
		}else if(highCard()){
			System.out.println(massageHigh1());
		}else {
			System.out.println(massageAdd1());
		}
	}


	public void game_2() {
		this.addCard += this.cardB;

		if(this.addCard == 21) {
			System.out.println(cardMessage2());
			this.gameContinue = 2;
		}else if(this.addCard>20){
			System.out.println(massageHigh2());
			this.gameContinue = 2;
		}else {
			System.out.println(massageAdd2());
		}
	}

	/*publicstatic void dealer(int addCard) {
		int dealerAddCard =  (int)(Math.random()*24 + 17);
		if(dealerAddCard <= 21 && addCard <= 21) {
			if(addCard > dealerAddCard) {
				score(addCard, dealerAddCard);
				System.out.println("あなたの勝ちです。");
			}else if(addCard == dealerAddCard) {
				score(addCard, dealerAddCard);
				System.out.println("引き分けです。");
			}else {
				score(addCard, dealerAddCard);
				System.out.println("あなたの負けです。");
			}
		}else if(dealerAddCard > 21 && addCard <= 21) {
			System.out.println("あなたは"+addCard+"でした。");
			System.out.println("ディーラーはバーストしました。");
			System.out.println("あなたの勝ちです。");
		}else {
			System.out.println("あなたはバーストしました。");
			System.out.println("ディーラーは"+ dealerAddCard +"でした。");
			System.out.println("あなたの勝ちです。");
		}
	}*/


	public boolean spCard() {
		return (this.cardA == 1 && this.cardB >= 11) || (this.cardA >= 11 && this.cardB == 1) || this.cardA + this.cardB == 21;
	}
	public  boolean highCard() {
		return this.cardA + this.cardB > 20;
	}
	public static void continueMessage() {
		System.out.println("続けてカードを引きますか？");
		System.out.println("1.はい");
		System.out.println("2.いいえ");
	}

	public static void gameFinish() {
		System.out.println("ゲームを終了します。");
	}

 	public String cardMessage() {
		return this.cardA + "と" + this.cardB;
	}

	//一回目の言葉
	public void massage21() {
		System.out.println("合計21なのでブラックジャックになりました。");
	}
	public String massageHigh1() {
		return cardMessage() + "で、合計が21を超えたのでバーストしてしまいました。";
	}
	public String massageAdd1() {
		return cardMessage() + "で、合計が" + score() + "になりました。";
	}

	//二回目以降の言葉
	public String cardMessage2() {
		return "今引いたカードは" + this.cardB + "で、合計21なので、ブラックジャックになりました。";
	}
	public String massageHigh2() {
		return "今引いたカードは" + this.cardB +"で、合計が21を超えたのでバーストしてしまいました。";
	}
	public String massageAdd2() {
		return "今引いたカードは" + this.cardB + "で、合計が" + this.addCard + "になりました。";
	}



}