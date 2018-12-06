package br.com.unitri.v2.v2ppi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String checkOne;
    private String checkTwo;
    private String checkThree;
    private String checkFour;
    private String checkFive;
    private String checkSix;

    public Score() {
    }

    public Score(String checkOne, String checkTwo, String checkThree, String checkFour, String checkFive, String checkSix) {
        this.checkOne = checkOne;
        this.checkTwo = checkTwo;
        this.checkThree = checkThree;
        this.checkFour = checkFour;
        this.checkFive = checkFive;
        this.checkSix = checkSix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckOne() {
        return checkOne;
    }

    public void setCheckOne(String checkOne) {
        this.checkOne = checkOne;
    }

    public String getCheckTwo() {
        return checkTwo;
    }

    public void setCheckTwo(String checkTwo) {
        this.checkTwo = checkTwo;
    }

    public String getCheckThree() {
        return checkThree;
    }

    public void setCheckThree(String checkThree) {
        this.checkThree = checkThree;
    }

    public String getCheckFour() {
        return checkFour;
    }

    public void setCheckFour(String checkFour) {
        this.checkFour = checkFour;
    }

    public String getCheckFive() {
        return checkFive;
    }

    public void setCheckFive(String checkFive) {
        this.checkFive = checkFive;
    }

    public String getCheckSix() {
        return checkSix;
    }

    public void setCheckSix(String checkSix) {
        this.checkSix = checkSix;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", checkOne='" + checkOne + '\'' +
                ", checkTwo='" + checkTwo + '\'' +
                ", checkThree='" + checkThree + '\'' +
                ", checkFour='" + checkFour + '\'' +
                ", checkFive='" + checkFive + '\'' +
                ", checkSix='" + checkSix + '\'' +
                '}';
    }
}
