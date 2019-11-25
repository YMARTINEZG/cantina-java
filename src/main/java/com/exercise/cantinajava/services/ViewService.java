package com.exercise.cantinajava.services;

import com.exercise.cantinajava.domain.SelectorDto;
import com.exercise.cantinajava.domain.ViewComposite;
import com.exercise.cantinajava.exceptions.BadPayloadException;

import java.util.List;

public interface ViewService {
    void loadJsonPayload(String json) throws BadPayloadException;
    List<SelectorDto> getAttributesCount(String selector);
}
