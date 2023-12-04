package com.javaschool.trains.domain.seat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/seat")
@CrossOrigin(origins = "http://localhost:4200")
public class SeatController {
}
