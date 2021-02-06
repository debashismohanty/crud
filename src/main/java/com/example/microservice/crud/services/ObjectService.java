package com.example.microservice.crud.services;

import com.example.microservice.crud.domain.GenericObjectDomain;
import com.example.microservice.crud.model.GenericObject;
import com.example.microservice.crud.repository.ObjectRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    public GenericObject addObject(GenericObject genericObject) {
        log.info("Saving Object => {}", genericObject);
        GenericObjectDomain genericObjectDomain = new GenericObjectDomain();
        genericObjectDomain.setId(genericObject.getId());

        Gson gson = new Gson();
        String bson = gson.toJson(genericObject.getObject());
        genericObjectDomain.setObject(bson);

        genericObjectDomain = objectRepository.save(genericObjectDomain);
        return genericObject;
    }

    public GenericObject getObject(long id) {
        log.info("Getting Object by ID => {}", id);
        Optional<GenericObjectDomain> genericObjectDomain = objectRepository.findById(id);
        GenericObject genericObject = null;
        if(genericObjectDomain.isPresent()) {
            genericObject = new GenericObject();
            genericObject.setId(genericObjectDomain.get().getId());

            Gson gson = new Gson();
            Map<String, Object> bson = gson.fromJson(genericObjectDomain.get().getObject(),  new TypeToken<Map<String, Object>>() {}.getType());

            genericObject.setObject(bson);
        }

        return genericObject;
    }

    public GenericObject updateObject(long id, GenericObject genericObject) {
        log.info("Getting Object by ID => {}", id);
        Optional<GenericObjectDomain> genericObjectDomainOptional = objectRepository.findById(id);

        if(genericObjectDomainOptional.isPresent()) {
            GenericObjectDomain genericObjectDomain  = genericObjectDomainOptional.get();
            Gson gson = new Gson();
            String bson = gson.toJson(genericObject.getObject());
            genericObjectDomain.setObject(bson);

            objectRepository.save(genericObjectDomain);

            return genericObject;
        }

        return null;
    }

    public void deleteObject(long id) {
        log.info("Deleting Object by ID => {}", id);
        objectRepository.deleteById(id);
    }
}
