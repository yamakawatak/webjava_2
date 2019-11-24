package jp.co.systena.tigerscave.rpg.model;

public class Job {
  private String name;
  private int hp;
  private String job;

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getHp() {
    return this.hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public String getJob() {
    return job;
  }
  public void setJob(String job) {
    this.job = job;
  }

  public String attack(String name) {
    return name;
  }
}
