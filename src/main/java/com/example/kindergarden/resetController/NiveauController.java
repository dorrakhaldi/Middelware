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

import com.example.kindergarden.entities.Niveau;
import com.example.kindergarden.repositories.NiveauRepository;

@RestController
@CrossOrigin("http://localhost:8080")
public class NiveauController implements java.io.Serializable{
  @Autowired
  com.example.kindergarden.repositories.UserRepository UserRepository;
  @Autowired
  NiveauRepository niveauRepository;
  @GetMapping("/niveaux")
  public List<Niveau> getAllniveau (){
    return  niveauRepository.findAll();
  }
  @PostMapping("/add-niveau")
  @ResponseBody
  public Niveau addNiveau(@RequestBody Niveau niveau) {
    return  niveauRepository.save(niveau);
  }
  @PutMapping("/UpdateNiveau/")
  public ResponseEntity<Niveau> updateNiv(
      @PathVariable(value = "id") Long id,
      @RequestBody Niveau niveau) throws Exception {
    Niveau p = niveauRepository.findById(id)
        .orElseThrow(() -> new Exception("User not found on :: "+ id));

    p.setLabel(niveau.getLabel());
    final Niveau updatedniv = niveauRepository.save(p);
    return ResponseEntity.ok(updatedniv);
  }
  @DeleteMapping("/deleteniv/{id}")
  public void deleteniv(@PathVariable("id") long id){
    niveauRepository.deleteById(id);

  }
}
