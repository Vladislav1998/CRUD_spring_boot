package com.javapointers.controller;

import com.javapointers.model.Artist;
import com.javapointers.model.CD;
import com.javapointers.model.Organization;
import com.javapointers.repositories.ArtistRepository;
import com.javapointers.repositories.CDRepositories;
import com.javapointers.repositories.OrganizationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private CDRepositories cdRepositories;
    @Autowired
    private OrganizationRepositories organizationRepositories;

    @RequestMapping("/MainMenu")
        public String viewHome() {
            return "MainMenu";
        }

    //Работа с таблицей CD
    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String selectCD(Model model){
        List<CD> cdList = cdRepositories.findAll();
        model.addAttribute("cdList",cdList);
        List<Organization> organizationList = organizationRepositories.findAll();
        List<Artist> artistList = artistRepository.findAll();
        model.addAttribute("organizationList",organizationList);
        model.addAttribute("artistList",artistList);
        return "start";
    }
    @RequestMapping (value = "deleteCD",method = RequestMethod.POST)
    public String deleteCD(@RequestParam int hiden_CD){
        cdRepositories.deleteById(hiden_CD);
        return "redirect:/start";
    }
    @RequestMapping(value ="updateCD",method=RequestMethod.POST)
    public String updateCD(@RequestParam int hiden_CD,@RequestParam String album,@RequestParam String  genre,@RequestParam int artistID,@RequestParam int orgID ){
        CD cd= cdRepositories.getOne(hiden_CD);
        cd.setAlbum(album);
        cd.setGanre(genre);
        cd.setArtist(artistRepository.getOne(artistID));
        cd.setOrganization(organizationRepositories.getOne(orgID));
        cdRepositories.save(cd);
        return "redirect:/start";
    }
    @RequestMapping(value = "insertCD",method = RequestMethod.POST)
    public String insertCD(@RequestParam String album,@RequestParam String genre,@RequestParam int artistID,@RequestParam int orgID){
        Artist artist = artistRepository.getOne(artistID);
        Organization organization = organizationRepositories.getOne(orgID);
        cdRepositories.save(new CD(album,genre,artist,organization));
        return  "redirect:/start";
    }
//    @PostMapping(value = "/{id}", params = "updateCD")
//    public String updateSupply(@RequestParam int hiden_CD,@RequestParam String album,@RequestParam String  genre,@RequestParam int artistID,@RequestParam int orgID, Model model ){
//        CD cd = cdRepositories.findById(hiden_CD).get();
//        cd.setAlbum(album);
//        cd.setGanre(genre);
//        cd.setArtist(artistRepository.findById(artistID).get());
//        cd.setOrganization(organizationRepositories.findById(orgID).get());
//        cdRepositories.save(cd);
//        model.addAttribute("artist",artistRepository.findAll());
//        model.addAttribute("organization",organizationRepositories.findAll());
//        return "redirect:/start";
//    }

    //Работа с таблицей artist
    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public String artistPage(Model model) {
        List<Artist> artistList=artistRepository.findAll();
        model.addAttribute("artistList", artistList);
        return "artist";
    }
    @RequestMapping (value = "deleteArtist",method = RequestMethod.POST)
     public String deleteArtist(@RequestParam int hiden_Artist){
        artistRepository.deleteById(hiden_Artist);
        return "redirect:/artist";
        }

        @RequestMapping(value ="updateArtist",method=RequestMethod.POST)
    public String updateArtist(@RequestParam int hiden_Artist,@RequestParam String name,@RequestParam int Number_of_albums ){
        Artist artist= artistRepository.getOne(hiden_Artist);
        artist.setName(name);
        artist.setNumber_of_albums(Number_of_albums);
        artistRepository.save(artist);
        return "redirect:/artist";
        }
        @RequestMapping(value = "insertArtist",method = RequestMethod.POST)
    public String saveArist(@RequestParam String name,@RequestParam int Number_of_albums){
        artistRepository.save(new Artist(name,Number_of_albums));

        return "redirect:/artist";
        }

    //Работа с таблицей organization
    @RequestMapping(value = "/organization", method = RequestMethod.GET)
    public String organizationPage(Model model) {
        List<Organization> organizationList=organizationRepositories.findAll();
        model.addAttribute("organizationList",organizationList);
        return "organization";
    }
    @RequestMapping (value = "deleteOrganization",method = RequestMethod.POST)
    public String deleteOrg(@RequestParam int hiden_Org){
        organizationRepositories.deleteById(hiden_Org);
        return "redirect:/organization";
    }
    @RequestMapping(value ="updateOrganization",method=RequestMethod.POST)
    public String updateOrg(@RequestParam int hiden_Org, @RequestParam String name_of_organization,@RequestParam String phone,@RequestParam String e_mail){
        Organization organization= organizationRepositories.getOne(hiden_Org);
        organization.setName_of_organization(name_of_organization);
        organization.setE_mail(e_mail);
        organization.setPhone(phone);
        organizationRepositories.save(organization);
        return "redirect:/organization";
    }
    @RequestMapping(value = "insertOrg",method = RequestMethod.POST)
    public String saveOrg( @RequestParam String name_of_organization,@RequestParam String phone,@RequestParam String e_mail){
        organizationRepositories.save(new Organization(name_of_organization,phone,e_mail));
        return "redirect:/organization";
    }

    //Переход по кнопкам
@RequestMapping(value = "start", method = RequestMethod.POST)
public String goToCD(){
        return "redirect:/start";
    }

    @RequestMapping(value = "organization", method = RequestMethod.POST)
    public String goToOrganization(){
    return "redirect:/organization";
    }

    @RequestMapping(value = "artist", method = RequestMethod.POST)
     public String goToArtist(){
        return "redirect:/artist";
        }
}
