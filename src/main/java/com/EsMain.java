package com;

import com.domain.User;
import com.repository.UserRepository;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class EsMain {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ElasticsearchTemplate template;

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext("elasticsearch-server.xml");
        EsMain app = (EsMain)ctx.getBean("main");
        Settings s= app.template.getClient().settings();
        Iterable<User> users = app.listAllUsers();
        System.out.print("Done"+ users.spliterator().getExactSizeIfKnown());
    }

    public Iterable<User> listAllUsers(){
        return repository.findAll();
    }

}
