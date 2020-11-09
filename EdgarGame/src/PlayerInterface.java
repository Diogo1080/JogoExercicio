public interface PlayerInterface {
        void getHitted(double hit); //the player is hit and loses health points

        int rechargeHealth(int health);  //returns player life after recharge and updates healthRechargeCounter

        int normalAttack();  //returns normalAttack

        int specialAttack(); // return specialAttack and updates specialAttackCounter
}

