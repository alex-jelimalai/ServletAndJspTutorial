package com.it_tutorial.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.StoreEntities;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.it_tutorial.model.Tutorial;

/**
 * @author Alexandr Jelimalai
 */
public class TutorialService {

    private final DatastoreService datastore;


    public TutorialService() {
        datastore = DatastoreServiceFactory.getDatastoreService();
    }


    public Collection<Tutorial> getAll() {
        Collection<Tutorial> tutorials = new ArrayList<>();
        Query query = new Query(StoreEntities.TUTORIAL).addSort(Tutorial.NAME, SortDirection.ASCENDING);
        List<Entity> tutorialEntities = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
        for (Entity tutorialEntity : tutorialEntities) {
            tutorials.add(getTutorialFrom(tutorialEntity));
        }
        return tutorials;
    }


    public Tutorial getByName(String name) {
        Query query = new Query(StoreEntities.TUTORIAL).setFilter(new FilterPredicate(Tutorial.NAME, FilterOperator.EQUAL, name));
        Entity tutorialEntity = datastore.prepare(query).asSingleEntity();
        return getTutorialFrom(tutorialEntity);
    }


    private Tutorial getTutorialFrom(Entity tutorialEntity) {
        Tutorial tutorial = new Tutorial();
        tutorial.setName(tutorialEntity.getProperty(Tutorial.NAME).toString());
        tutorial.setDescription(tutorialEntity.getProperty(Tutorial.DESCRIPTION).toString());
        return tutorial;
    }
}
