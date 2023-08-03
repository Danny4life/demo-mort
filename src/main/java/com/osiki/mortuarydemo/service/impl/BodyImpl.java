package com.osiki.mortuarydemo.service.impl;

import com.osiki.mortuarydemo.model.Body;
import com.osiki.mortuarydemo.repository.BodyRepository;
import com.osiki.mortuarydemo.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyImpl implements BodyService {

    @Autowired
    private BodyRepository bodyRepository;

    public BodyImpl(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    @Override
    public List<Body> getAllBodies() {
        return bodyRepository.findAll();
    }

    @Override
    public Body saveBody(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public Body getBodyById(Long id) {
        return bodyRepository.findById(id).get();
    }
}
