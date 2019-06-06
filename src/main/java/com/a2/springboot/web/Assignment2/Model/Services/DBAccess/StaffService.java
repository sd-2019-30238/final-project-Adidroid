package com.a2.springboot.web.Assignment2.Model.Services.DBAccess;


import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.StaffDAO;
import com.a2.springboot.web.Assignment2.Model.Data.Staff;

public class StaffService {

    public static boolean checkStaff(String username,String password) {

        Staff staff = new StaffDAO(SessionUtil.getSessionFactory()).findByUsername(username);
        if (staff == null)
            return false;

        if (!staff.getPassword().equals(password))
            return false;
        return true;
    }

    public static void addStaff(Staff staff){
        new StaffDAO(SessionUtil.getSessionFactory()).save(staff);
    }
}
