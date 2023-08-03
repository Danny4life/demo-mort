package com.osiki.mortuarydemo.service;


import com.osiki.mortuarydemo.model.Body;

import java.util.List;

public interface BodyService {

    List<Body> getAllBodies();

    Body saveBody(Body body);

    Body getBodyById(Long id);
}
