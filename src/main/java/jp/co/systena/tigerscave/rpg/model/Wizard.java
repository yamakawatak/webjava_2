package jp.co.systena.tigerscave.rpg.model;

public class Wizard extends Job{
  @Override
  public String attack(String name) {
    return name + "は魔法で攻撃した";
  }
  @Override
  public String heal(String name) {
    return name + "は魔法で回復した";
  }

}
