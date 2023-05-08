/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa09.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author btoarriola
 */
@RestController
@RequestMapping("/api")
public class EmpleadoController {
    
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    
    @GetMapping("/msg")
    public String holamundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/empleados/{id}")
    public DTOEmpleado obtenerEmpleado(@PathVariable("id") long id){
        DTOEmpleado emp=null;
        if (id == 10){
            emp = new DTOEmpleado();
            emp.setClave(1);
            emp.setNombre("beto");
            emp.setDireccion("av primica");
            emp.setTelefono("1234");
        }
        return emp;
    }
    
    @GetMapping("/empleados")
    public List<DTOEmpleado> obtenerTodosLosEmpleado(){
        List<DTOEmpleado> lstEmpleados=new ArrayList<>();
        DTOEmpleado emp1= new  DTOEmpleado();
        emp1.setClave(2);
        emp1.setNombre("beto");
        emp1.setDireccion("av primica");
        emp1.setTelefono("1234");
        
        lstEmpleados.add(emp1);
        DTOEmpleado emp2= new DTOEmpleado();
        emp2.setClave(3);
        emp2.setNombre("otro");
        emp2.setDireccion("Otra dieccion");
        emp2.setTelefono("123456");
        lstEmpleados.add(emp2);
        
        return lstEmpleados;
    }
    //guardarregistro
    @PostMapping("/empleados")
    public DTOEmpleado  createEmpleado(@RequestBody DTOEmpleado empleadoDTO){
        Empleado empleadopojo= new Empleado();
        empleadopojo.setNombre(empleadoDTO.getNombre());
        empleadopojo.setDireccion(empleadoDTO.getDireccion());
        empleadopojo.setTelefono(empleadoDTO.getTelefono());
        
        Empleado empleadopojoNew=repositoryEmpleado.save(empleadopojo);
        
        DTOEmpleado empleadoDTONew=new DTOEmpleado();
        empleadoDTONew.setClave(empleadopojoNew.getId());
        empleadoDTONew.setNombre(empleadopojoNew.getNombre());
        empleadoDTONew.setDireccion(empleadopojoNew.getDireccion());
        empleadoDTONew.setTelefono(empleadopojoNew.getTelefono());
        return empleadoDTONew;
  }
    //update
    @PutMapping("/empleados/{id}")
  public DTOEmpleado modificarEmpleado(@PathVariable("id")Long id,
          @RequestBody DTOEmpleado empleado){
      
      return empleado;
      
  }
    //delete
    @DeleteMapping("/empleados/{id}")
  public void borrarEmpleado(@PathVariable("id") Long id){
        //aqui code smell "return;"
  }
    
}
