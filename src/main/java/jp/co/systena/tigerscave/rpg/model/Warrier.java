package jp.co.systena.tigerscave.rpg.model;

public class Warrier extends Job {
  @Override
  public String attack(String name) {
    return name + "は剣で攻撃した";
  }
  @Override
  public String heal(String name) {
    return name + "は薬草で回復した";
  }


}
