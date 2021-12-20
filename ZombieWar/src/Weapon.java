public class Weapon {
  private int attack;
  private int accuracy;
  private String name;
  
  private Weapon()
  {
      rollWeapon();
  }  // end constructor

  
  /**
   * Possibly "finds" a Weapon to use in the war. If no weapon is found, returns null
   *   which is why this is used instead of a default constructor.
   * @param probability : chance to receive a weapon. Returns NULL if no weapon found.
   * @return            : Weapon if success, NULL if not.
   */
  public static Weapon getWeapon(int probability)
  {
    if (Math.random() * 100 < probability)
    {
        Weapon weapon = new Weapon();
        return weapon;
    }
    else
        return null;
  }  // end getWeapon(int)

  
  /**
   * Returns the attack value of the weapon. But only if the attack "hits" based
   * on the weapon's accuracy rating.
   * 
   * @return Weapon.attack if success, 0 if fail
   */
  public int addAttack()
  {
      if ((Math.random() * 100) < getAccuracy())
          return getAttack();
      else
          return 0;
  }  // end addAttack()
  
  
  private int getAttack()
  {
      return attack;
  }  // end getAttack()
  
  
  private int getAccuracy()
  {
      return accuracy;
  }  // end getAccuracy()
  
  
  private void setAttack(int attack)
  {
      this.attack = attack;
  }  // end setAttack(int)
  
  
  private void setAccuracy(int accuracy)
  {
      this.accuracy = accuracy;
  }  // end setAccuracy(int)
  
  
  public String getName()
  {
      return name;
  }  // end getName()
  
  
  private void setName(String name)
  {
      this.name = name;
  }  // end setName(String)
  
  
  /**
   * Creates a different type of weapon depending on a random roll 0-100.
   */
    private void rollWeapon()
    {
      int score = (int)(Math.random() * 100);

      if (score < 10)
      {
          name = "handgun";
          attack = 5;
          accuracy = 80;
      }
      else if (score < 20)
      {
          name = "baseball bat";
          attack = 7;
          accuracy = 25;
      }
      else if (score < 30)
      {
          name = "crowbar";
          attack = 14;
          accuracy = 25;
      }
      else if (score < 40)
      {
          name = "shotgun";
          attack = 20;
          accuracy = 50;
      }
      else if (score < 50)
      {
          name = "bow";
          attack = 10;
          accuracy = 90;
      }
      else if (score < 60)
      {
          name = "rifle";
          attack = 17;
          accuracy = 80;
      }
      else if (score < 70)
      {
          name = "machine gun";
          attack = 40;
          accuracy = 40;
      }
      else if (score < 80)
      {
          name = "semi-automatic";
          attack = 30;
          accuracy = 60;
      }
      else if (score < 90)
      {
          name = "frying pan";
          attack = 5;
          accuracy = 15;
      }
      else if (score < 99)
      {
          name = "knife";
          attack = 15;
          accuracy = 25;
      }
      /* Tyler: I play the board game "Dead of Winter" with some friends. There's a character
      named Sparky, a dog. My friend Erin will trick him out with every weapon or loot he finds.
      I created added Spark as an auto-kill weapon as an homage.
      */
      else
      {
          name = "Sparky, the Wonder Dog";
          attack = 500;
          accuracy = 100;
      }
    }  // end rollWeapon()
}