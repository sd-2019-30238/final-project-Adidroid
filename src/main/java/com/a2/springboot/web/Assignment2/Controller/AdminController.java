package com.a2.springboot.web.Assignment2.Controller;

import com.a2.springboot.web.Assignment2.Model.Data.Reservation;
import com.a2.springboot.web.Assignment2.Model.Data.Table;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.ReservationService;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.TableService;
import com.a2.springboot.web.Assignment2.Model.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/admin")
    public String adminPageGET(ModelMap model) {

        model.put("tables", TableService.getAll());
        return "admin";
    }

    @RequestMapping(value="/admin",method=RequestMethod.POST)
    public  String adminPagePOST(@RequestParam String seats,ModelMap model){
        Table table=new Table(Integer.parseInt(seats));
        TableService.addTable(table);
        model.put("tables", TableService.getAll());

        return "admin";
    }

    @RequestMapping("/adminLogin")
    public String adminLoginGET(ModelMap model){


        return "adminLogin";

    }

    @RequestMapping(value="/adminLogin", method= RequestMethod.POST)
    public String adminLoginPOST(@RequestParam String username,@RequestParam String password, ModelMap model){

        if(!loginService.staffIsValid(username,password)){
            model.put("errorMessage","Invalid Credentials\n");
            return "adminLogin";
        }


        return "redirect:/admin";

    }

    @RequestMapping("/deleteTable")
    public String deleteTable(@RequestParam int id){
        TableService.deleteById(id);
        return "redirect:/admin";
    }

    @RequestMapping(value="/requests", method= RequestMethod.POST)
    public String requests(ModelMap model){
        List<Reservation> reservations=new ArrayList<>();

        for(Reservation reservation:ReservationService.getAll()){
            if(reservation.getStatus()==0)
                reservations.add(reservation);

        }

         model.put("reservations",reservations);

         return "requests";
    }

    @RequestMapping("/approveReservation")
    public String approveReservation(@RequestParam int id){
        Reservation reservation= ReservationService.get(id);
        reservation.setStatus(1);
        ReservationService.update(reservation);

        return "redirect:/admin";

    }

    @RequestMapping("/rejectReservation")
    public String rejecteReservation(@RequestParam int id){

        ReservationService.deleteById(id);

        return "redirect:/admin";

    }
}

