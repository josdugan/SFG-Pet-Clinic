package guru.springframework.sfgpetclinic.web.controllers;

import guru.springframework.sfgpetclinic.data.model.Vet;
import guru.springframework.sfgpetclinic.data.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/list", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/list";
    }

    @RequestMapping("/api/vets")
    public  @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
