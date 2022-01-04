/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ti.umy.tugas.kasir;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hawe
 */
@Controller
public class projectController {
    
    @RequestMapping("/kasir")
    public String market(HttpServletRequest data, Model laci){
        String nama = data.getParameter("var_nama");
        Double price = Double.valueOf(data.getParameter("var_price"));
        Double quantity = Double.valueOf(data.getParameter("var_quantity"));
        Double payment = Double.valueOf(data.getParameter("var_payment"));
        
        services obj = new services();
        
        laci.addAttribute("namasayur", nama);
        laci.addAttribute("hargasayur","Rp."+ price);
        laci.addAttribute("totalbrg",quantity);
        laci.addAttribute("beforeprice",obj.broto(price,quantity));
        laci.addAttribute("discnumber",obj.disc(obj.broto(price,quantity))+ "%");
        laci.addAttribute("discquantity",obj.discount(price,quantity));
        laci.addAttribute("afterprice","Rp." + obj.netto(price,quantity));
        laci.addAttribute("bayar", payment);
        
        return "Viewer";
    }
}
