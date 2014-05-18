package com.it_tutorial.service;

import com.StoreEntities;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.it_tutorial.model.Course;
import com.it_tutorial.model.Subject;
import com.util.TagUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Alexandr Jelimalai
 */
public class SubjectService {

    private final DatastoreService datastore;


    public SubjectService() {
        datastore = DatastoreServiceFactory.getDatastoreService();
    }


    public Collection<Subject> getByCourse(String courseName) {
        List<Subject> subjects = new ArrayList<>();
        Query query = new Query(StoreEntities.COURSE).setFilter(new FilterPredicate(Course.NAME, FilterOperator.EQUAL, courseName));
        Entity course = datastore.prepare(query).asSingleEntity();
        Query querySubjects = new Query(StoreEntities.SUBJECT).setAncestor(course.getKey()).addSort(Subject.DATE);
        List<Entity> subjectEntities = datastore.prepare(querySubjects).asList(FetchOptions.Builder.withDefaults());
        for (Entity entity : subjectEntities) {
            Subject subject = new Subject();
            subject.setName(entity.getProperty(Subject.NAME).toString());
            String description = ((Text) entity.getProperty(Subject.DESCRIPTION)).getValue();
            String escapedText = TagUtil.escapeCodeXml(description);
            subject.setDescription(escapedText);
            subjects.add(subject);
        }
        return subjects;
    }

}
