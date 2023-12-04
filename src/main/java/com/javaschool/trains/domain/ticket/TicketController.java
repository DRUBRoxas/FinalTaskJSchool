package com.javaschool.trains.domain.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/ticket")
@CrossOrigin(origins = "http://localhost:4200")

public class TicketController {
}
