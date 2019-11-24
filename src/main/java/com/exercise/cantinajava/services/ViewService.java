package com.exercise.cantinajava.services;

import com.exercise.cantinajava.domain.ViewComposite;
import com.exercise.cantinajava.exceptions.BadPayloadException;

public interface ViewService {
    void loadJsonPayload(String json) throws BadPayloadException;
    Integer getAttributesCount(String selector);
}
