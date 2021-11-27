package com.example.kindergarden.resetController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kindergarden.entities.Child;
import com.example.kindergarden.entities.User;
import com.example.kindergarden.repositories.ChildRepository;
import com.example.kindergarden.repositories.NiveauRepository;
import com.example.kindergarden.repositories.UserRepository;

@RestController
@CrossOrigin("http://localhost:8080")
public class ChildController implements java.io.Serializable{
  @Autowired
  UserRepository userRepository;
  @Autowired
  NiveauRepository Niveaurepository;
  @Autowired
  ChildRepository Childrepository;
  @GetMapping("/parent/{id}")
  public List<Child> getAllChildrenByparent  (@PathVariable("id") Long id){
    return  Childrepository.findByParent(userRepository.findById(id).orElse(null));
  }
  @GetMapping("/Parentchildren/{id}/")
  public User getParent(@PathVariable("id") Long id){
    return  userRepository.findById(id).get();

  }
  @GetMapping("/niveauchildren/{id}/")
  public List<Child> getAllChildrenByNiveau (@PathVariable("id") Long id){
    return  Childrepository.join(Niveaurepository.findById(id).orElse(null));

  }
  @PostMapping("/addchild/{id}")
  @ResponseBody
  public Child addChild(@RequestBody Child child,@PathVariable Long id) throws Exception {
   User c= userRepository.findById(id).orElseThrow(() -> new Exception("User not found on :: "+ id));
    child.setParent(c);
    return  Childrepository.save(child);
  }

  @PutMapping("/UpdateChild/{id}")
  public ResponseEntity<Child> updateChild(
      @PathVariable(value = "id") Long id,
      @RequestBody Child child) throws Exception {
    Child p = Childrepository.findById(id)
        .orElseThrow(() -> new Exception("User not found on :: "+ id));

    p.setFirstName(child.getFirstName());
    p.setDateNaissance(child.getDateNaissance());
    p.setLastName(child.getLastName());
    p.setNiveau(child.getNiveau());
    p.setParent(child.getParent());
    final Child updatedprod = Childrepository.save(p);
    return ResponseEntity.ok(updatedprod);
  }
  @DeleteMapping("/deletechild/{id}")
  public void deletechild(@PathVariable("id") long id){
    Childrepository.deleteById(id);

  }
}
