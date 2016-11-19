package me.mushen.athena.springmvc.spittr.web;

import me.mushen.athena.springmvc.spittr.data.ISpittleRepository;
import me.mushen.athena.springmvc.spittr.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-30
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String LONG_MAX_AS_STRING = "0x7fffffffffffffff";

    @Autowired
    private ISpittleRepository spittleRepository;

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model){
//        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//
//        return "spittles";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = LONG_MAX_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count){
        return spittleRepository.findSpittles(max, count);
    }

//    @RequestMapping(value = "/show", method = RequestMethod.GET)
//    public String showSpittle(@RequestParam("spittleId") long spittleId,
//                              Model model){
//        model.addAttribute(spittleRepository.findOne(spittleId));
//
//        return "spittle";
//    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId,
                          Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));

        return "spittle";
    }

}
