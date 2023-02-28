package web.controller;

import web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CarsController {
    private CarService cars;

    public CarsController(CarService cars) {
        this.cars = cars;
    }

    @GetMapping("/cars")
    public String listCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("cars", cars.listCars(count));
        return "cars";
    }
}
