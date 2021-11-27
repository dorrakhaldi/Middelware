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
import com.example.kindergarden.entities.Role;
import com.example.kindergarden.entities.User;
import com.example.kindergarden.repositories.NiveauRepository;
import com.example.kindergarden.repositories.UserRepository;


@RestController
@CrossOrigin("http://localhost:8080")
public class UserController implements java.io.Serializable {
  @Autowired
  UserRepository userRepository;
  @Autowired
  NiveauRepository niveauRepository;
  @GetMapping("/parents")
  public List<User> getAllParents (){
    return  userRepository.findByRole(Role.parent);
  }

  @PostMapping("/add-Parent/")
  @ResponseBody
  public User addParent(@RequestBody  User p) throws Exception {
   p.setRole(Role.parent);
    return  userRepository.save(p);
}

  @PutMapping("/UpdateParent/{id}")
  public ResponseEntity<User> updateProd(
      @PathVariable(value = "id") Long id,
      @RequestBody User parent) throws Exception {
    User p = userRepository.findById(id)
        .orElseThrow(() -> new Exception("User not found on :: "+ id));

    p.setFirstName(parent.getFirstName());
    p.setDateNaissance(parent.getDateNaissance());
    p.setLastName(parent.getLastName());
    p.setAdresse(parent.getAdresse());
    p.setEmail(parent.getEmail());
    p.setChildren(parent.getChildren());
    final User updatedprod = userRepository.save(p);
    return ResponseEntity.ok(updatedprod);
  }
  @DeleteMapping("/deleteuser/{id}")
  public void deleteuser(@PathVariable("id") long id){
    userRepository.deleteById(id);

  }
  @GetMapping("/teachers")
  public List<User> getAllteachers (){
    return  userRepository.findByRole(Role.teacher);
  }
  @PostMapping("/add-Teacher/{id}")
  @ResponseBody
  public User addTeacher(@RequestBody User teacher,@PathVariable("id") Long id) {
    Niveau niveau= niveauRepository.findById(id).get();
    teacher.setNiveau(niveau);
    teacher.setRole(Role.teacher);
    return  userRepository.save(teacher);
  }
  @PutMapping("/Updateteacher/{id}")
  public ResponseEntity<User> updateProf(
      @PathVariable(value = "id") Long id,
      @RequestBody User teacher) throws Exception {
    User p = userRepository.findById(id)
        .orElseThrow(() -> new Exception("User not found on :: "+ id));

    p.setFirstName(teacher.getFirstName());
    p.setDateNaissance(teacher.getDateNaissance());
    p.setLastName(teacher.getLastName());
    p.setAdresse(teacher.getAdresse());
    p.setEmail(teacher.getEmail());
    p.setNiveau(teacher.getNiveau());
    final User updatedteach = userRepository.save(p);
    return ResponseEntity.ok(updatedteach);
  }
}