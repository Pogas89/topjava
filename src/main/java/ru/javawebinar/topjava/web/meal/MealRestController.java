package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;

@Controller
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);
    private MealService service;

    @Autowired
    public MealRestController(MealService service) {
        this.service = service;
    }

    public Collection<Meal> getAll(){
        int userId= AuthorizedUser.id();
        log.info("getAll for userId:" + userId);
        return service.getAll(userId);
    }

    public Meal get(int id){
        int userId= AuthorizedUser.id();
        log.info("get for userId:" + userId);
        return service.get(id,userId);
    }

    public Meal create(Meal meal){
        log.info("create " + meal);
        return service.save(meal);
    }

    public void update(Meal meal){
        log.info("update");
        service.save(meal);
    }

    public void delete(int id){
        int userId= AuthorizedUser.id();
        log.info("delete for userId:" + userId);
        service.delete(id, userId);
    }
}