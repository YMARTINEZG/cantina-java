package com.exercise.cantinajava.services;

import com.exercise.cantinajava.domain.SelectorDto;
import com.exercise.cantinajava.domain.View;
import com.exercise.cantinajava.domain.ViewComposite;
import com.exercise.cantinajava.exceptions.BadPayloadException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ViewServiceImpl implements ViewService{

    private ViewComposite parentView;
    private ObjectMapper mapper;
    @Autowired
    public ViewServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/testJsonPayload.json")));
            loadJsonPayload(jsonString);
        }catch(Exception e){
            this.parentView = null;
        }
    }

    @Override
    public void loadJsonPayload(String json) throws BadPayloadException{
        try {
            JsonNode node = mapper.readTree(json);
            this.parentView = new ViewComposite("Main", null, node.get("identifier").toString());
            JsonNode viewNode = node.get("subviews");
            findViews(viewNode, parentView);
        }catch(Exception e){
            throw new BadPayloadException(json);
        }
    }
    @Override
    public List<SelectorDto> getAttributesCount(String selector){
        List<SelectorDto> result = new ArrayList<>();
        try {
            final List<SelectorDto> selectors = mapper.readValue(selector, new TypeReference<List<SelectorDto>>() {
            });
            SelectorDto dto = selectors.get(0);
            List<View> sublist = processSelectorRequest(dto.getSelectorType(), dto.getSelectorValue(), parentView);
            if(sublist.size() > 0){
                dto.setSelectorResult((sublist.size()));
                result.add(dto);
                for(int i=1; i< selectors.size();i++){
                    List<View> temporal = new ArrayList<>();
                    SelectorDto subdto = selectors.get(i);
                    for(View v: sublist){
                        if(v.getClassNames().contains(subdto.getSelectorValue())){
                            temporal.add(v);
                        }
                    }
                    if(temporal.size() > 0){
                        subdto.setSelectorResult((temporal.size()));
                        result.add(subdto);
                    }
                    sublist = temporal;
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
    private Integer countBySelectorValue(ViewComposite root, String selector){
        return root.count(selector);
    }

    private List<View> processSelectorRequest(String typeSelector, String selectorvalue, ViewComposite root){
        List<View> selectorViews = new ArrayList<>();
        root.ls(selectorViews, typeSelector, selectorvalue);
        return selectorViews;
    }
    private void findViews(JsonNode treeNode , ViewComposite parentView) {
        Iterator<JsonNode> elements = treeNode.iterator();
        while (elements.hasNext()) {
            JsonNode element = elements.next();
            JsonNodeType nodeType = element.getNodeType();
            if (nodeType == JsonNodeType.OBJECT) {
                ViewComposite childView = new ViewComposite();
                Iterator<Map.Entry<String,JsonNode>> iterEle  = element.fields();
                while(iterEle.hasNext()){
                    Map.Entry<String,JsonNode> obj = iterEle.next();
                    if(obj.getKey().equals("subviews")){
                        parentView.add(childView);
                        findViews(obj.getValue(), childView);
                    } else if(obj.getKey().equals("contentView")){
                        Iterator<JsonNode> fields = obj.getValue().get("subviews").iterator();
                        while (fields.hasNext()) {
                            JsonNode eleobj = fields.next();
                            parseContentView(eleobj, parentView);
                        }
                    } else {
                        parseView(obj, childView);
                    }
                }
            }
        }
    }
    private void parseView(Map.Entry<String,JsonNode> entry, View view) {
        if(entry.getValue() instanceof TextNode){
            view.setClassView(entry.getValue().asText());
        } else {
            Iterator<JsonNode> fields = entry.getValue().iterator();
            while (fields.hasNext()) {
                view.addClassName(fields.next().asText());
            }
        }
    }
    private void parseContentView(JsonNode node, ViewComposite parent) {
        Iterator<Map.Entry<String,JsonNode>> fields  = node.fields();
        while (fields.hasNext()) {
            Map.Entry<String,JsonNode> field = fields.next();
            if(field.getValue() instanceof TextNode && field.getValue().asText().equals("Input")){
                parent.add(new View(field.getValue().asText()));
            }
            if(field.getValue() instanceof Object && field.getKey().equals("control")){
                View eleView = new View();
                eleView.setClassView(field.getValue().get("class").asText());
                if(field.getValue().get("identifier") != null){
                    eleView.setIdentifier(field.getValue().get("identifier").asText());
                }
                parent.add(eleView);
            }
        }
    }
}
