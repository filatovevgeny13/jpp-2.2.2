package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    @RequestMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count, Model model){
        if (count < 5){
            model.addAttribute("carList", CarService.getCarList(count));
        } else {
            model.addAttribute("carList", CarService.getCarList(5));
        }
        return "cars";
    }
}
