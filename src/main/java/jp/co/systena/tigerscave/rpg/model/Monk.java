package jp.co.systena.tigerscave.rpg.model;

public class Monk extends Job {
  @Override
  public String attack(String name) {
    return name + "は拳で攻撃した";
  }
  @Override
  public String heal(String name) {
    return name + "は薬草で回復した";
  }

}
