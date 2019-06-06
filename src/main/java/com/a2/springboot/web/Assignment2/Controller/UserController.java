package com.a2.springboot.web.Assignment2.Controller;


import com.a2.springboot.web.Assignment2.Model.Data.Reservation;
import com.a2.springboot.web.Assignment2.Model.Data.Table;
import com.a2.springboot.web.Assignment2.Model.Data.User;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.ReservationService;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.TableService;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"name","tableId"})


public class UserController {

    @RequestMapping("/user")
    public String userPage(ModelMap model){
        model.put("tables", TableService.getAll());

        List<Reservation> reservations=new ArrayList<>();

        for(Reservation reservation:UserService.getUserReservationsByUsername((String)model.get("name"))){
            if(reservation.getStatus()==1)
                reservations.add(reservation);
        }


        model.put("myReservations",reservations);
        return "user";
    }

    @RequestMapping("/makeReservation")
    public String makeReservation(@RequestParam int id,ModelMap model){

        Table table = TableService.get(id);

        User user= UserService.get((String)model.get("name"));
        Reservation reservation=new Reservation(2,3,user,table);
        ReservationService.addReservation(reservation);




        return "redirect:/user";

    }

    @RequestMapping("/cancelReservation")
    public String cancelReservation(@RequestParam int id){

        Reservation reservation=ReservationService.get(id);
        ReservationService.deleteById(reservation.getId());

       // table.setUser(null);
        //TableService.update(table);

        return "redirect:/user";

    }

    @RequestMapping("/tableDetails")
    public String tableDetails(@RequestParam int id,ModelMap model){
     model.put("reservations",ReservationService.getTableReservations(id));
     model.put("tableId",id);

        return "tableDetails";
    }

    @RequestMapping(value="/tableDetails", method= RequestMethod.POST)
    public String tableDetailsPost(@RequestParam int startHour,@RequestParam int endHour,ModelMap model){
        int id=(int)model.get("tableId");
        User user= UserService.get((String)model.get("name"));
        Table table = TableService.get(id);
        Reservation reservation=new Reservation(startHour,endHour,user,table);

        ReservationService.addReservation(reservation);

        return "redirect:/user";
    }
}
