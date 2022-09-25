package com.mision3.empresa.Controlador;

import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Entidades.Transaccion;
import com.mision3.empresa.Entidades.Usuario;
import com.mision3.empresa.Servicios.Servitransaccion;
import com.mision3.empresa.Servicios.serviempresa;
import com.mision3.empresa.Servicios.serviusuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controlgrafico {
    @Autowired
    private serviempresa se;
    @Autowired
    private Servitransaccion st;
    @Autowired
    private serviusuario su;

    public controlgrafico(serviempresa se,Servitransaccion sertr) {

        this.se = se;
        st = sertr;
    }
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) throws Exception {
        if(principal!=null) {
            Usuario usu = su.usuaut(principal.getClaims());
            model.addAttribute("usua",usu);

        }
        return "index";
    }

    @GetMapping("/nuevous")
    public String segunda(Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return "Empresas";
    }
    @GetMapping("/opciones")
    public String menu(){
        return "opciones";
    }


    @GetMapping("/Empresas")
    public String empresas(Model modelo){
        List<Empresa> emprelista = se.buscaemp();
        modelo.addAttribute("elista",emprelista);
        return "Empresas";
    }
    @GetMapping("/nueva")
    public String nueva(Model modelo) {
        modelo.addAttribute("nuevaempresa",new Empresa());
        return "nueva";
    }
    @PostMapping("/nuevaempresa")
    public String agregar(@ModelAttribute("nuevaempresa") Empresa empnueva){
        se.guardaremp(empnueva);
        return "redirect:/Empresas";

    }
   /* @GetMapping("/nuevaemp")
    public String nuevaemp(@ModelAttribute Empresa empnueva, Model modelo){
        modelo.addAttribute("empnueva",new Empresa());
        se.guardaremp(empnueva);
        return "nuevaempresa";
    }
    */
    //transacciones
   @GetMapping("/transaccion")
   public String transaccion(Model modelo){
       List<Transaccion> listatr = st.buscatrans() ;
       modelo.addAttribute("trlista",listatr);
       return "transaccion";
   }
    @GetMapping("/nuevatran")
    public String nuevat(Model modelo) {
        List<Empresa> emprelista = se.buscaemp();
        modelo.addAttribute("nuevatr",new Transaccion());
        modelo.addAttribute("listaempresa", emprelista);
        return "nuevatran";
    }
    @PostMapping("/guardanueva")
    public String agregartr(@ModelAttribute("guardanueva") Transaccion guardatra){
        st.guardatransac(guardatra);
        return "redirect:/transaccion";

    }
    @GetMapping("/total")
    public String total(Double monto, Model modelo){
        Double resultado = 0.0;
        monto = 500.0;
       for(int i=0;i<= 5;i++) {
           resultado += monto;
       }
       modelo.addAttribute("total",resultado);
       return "transacciones";
    }
    //usuario
    @GetMapping("/nuevousu")
    public String nuevousu(Model modelo) {
        modelo.addAttribute("nuevousu",new Usuario());
        return "nuevousu";

    }
    @PostMapping("/guardausuario")
    public String agregarusu(@ModelAttribute("guardanuevo") Usuario guardausu){
        su.crearusu(guardausu);
        return "redirect:/opciones";

    }
}
