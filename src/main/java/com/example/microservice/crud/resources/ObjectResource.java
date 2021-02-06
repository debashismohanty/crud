package com.example.microservice.crud.resources;


import com.example.microservice.crud.model.GenericObject;
import com.example.microservice.crud.services.ObjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud/objects")
@Api(value = "Object Resource REST Endpoint", description = "Object management CRUD operations")
@Slf4j
public class ObjectResource {

    @Autowired
    private ObjectService objectService;

    @ApiOperation(value = "Deletes the object by ID")
    @DeleteMapping("/id")
    public void deleteObject(@PathVariable("id") final Long id) {
        log.info("Deleting object by id => {}", id);
        objectService.deleteObject(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns Object By Id")
    public ResponseEntity<GenericObject> getObject(@PathVariable("id") final Long id)
    {
        log.info("Getting Object with id => {}", id);
        GenericObject genericObject = objectService.getObject(id);

        if(genericObject != null) {
            return new ResponseEntity(genericObject, HttpStatus.OK);
        } else {
            return new ResponseEntity("Object not found with id", HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Add an Object")
    @PostMapping
    public ResponseEntity<GenericObject> addObject(@RequestBody GenericObject genericObject) {
        log.info("Object => {} <= added", genericObject);
        return new ResponseEntity(objectService.addObject(genericObject), HttpStatus.OK);
    }

    @ApiOperation(value = "Add an Object")
    @PutMapping("/{id}")
    public ResponseEntity<GenericObject> updateObject(@PathVariable("id") final Long id, @RequestBody GenericObject genericObject) {
        log.info("Object with id => {} <= getting updated => {} <= ", id, genericObject);

        genericObject = objectService.updateObject(id, genericObject);
        if(genericObject != null) {
            return new ResponseEntity(genericObject, HttpStatus.OK);
        } else {
            return new ResponseEntity("Object not found with id", HttpStatus.NOT_FOUND);
        }
    }
}
