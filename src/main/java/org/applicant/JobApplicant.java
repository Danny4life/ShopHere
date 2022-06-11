package org.applicant;

import org.storeEnum.Gender;
import org.storeEnum.Qualification;

public class JobApplicant {
    final private String name;
    final private String phoneNumber;
    final private Gender gender;
    final private Integer age;
    final private Qualification qualification;
    final private Integer interviewScore;

    public JobApplicant(String name, String phoneNumber, Gender gender, Integer age, Qualification qualification, Integer interviewScore) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.qualification = qualification;
        this.interviewScore = interviewScore;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public Integer getInterviewScore() {
        return interviewScore;
    }

}
