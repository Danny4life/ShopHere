package org.storeManager;

import org.applicant.JobApplicant;
import org.models.Products;
import org.models.Staff;
import org.models.Store;
import org.storeEnum.Gender;
import org.storeEnum.Position;
import org.storeEnum.Qualification;

public class Manager extends Staff implements ManagerActivity, UpdateProduct {

    public Manager(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        super(name, phoneNumber, position, emailAddress, gender);
    }

    public boolean applicantStatus (JobApplicant jobApplicant) {
        return (jobApplicant.getQualification() == Qualification.BSC_ACCOUNTING) && (jobApplicant.getInterviewScore() > 70)
                && (jobApplicant.getAge() >= 23 || jobApplicant.getAge() <= 35);
    }

    @Override
    public boolean hireCashier(JobApplicant jobApplicant, Manager manager) {
        if((manager.getPosition().equals(Position.SENIOR_STAFF)) && applicantStatus(jobApplicant)) {
            System.out.print("Hello " + jobApplicant.getName() + ", ");
            System.out.print("You have been successfully employed for the position of a Cashier. Welcome onboard!");
            return true;
        } else if(!manager.getPosition().equals(Position.SENIOR_STAFF)) {
            System.out.println("Only Management is permitted to hire!");
            return false;
        } else {
            System.out.println("Hello " + " " + jobApplicant.getName() + ", " + "we are sorry to inform you that you didn't " +
                    "meet the criteria for this position. Please try again later.");
            return false;
        }

    }



    @Override
    public boolean updateProduct(Products product) {
        Store.items.add(product);
        System.out.println("Products updated successfully.");
        // System.out.println(store);
        return true;
    }


}
