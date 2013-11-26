package controllers;

import play.data.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.validation.Constraints.*;

import views.html.*;

public class Application extends Controller {

   /**
     * Describes the hello form.
     */
    public static class Hello {
        @Required @Min(1) @Max(100) public Integer width;
        @Required @Min(1) @Max(100) public Integer height;
        
    } 
    
	/**
     * Describes the hello form.
     */
    public static class Keliling {
        @Required @Min(1) @Max(100) public Integer width;
        @Required @Min(1) @Max(100) public Integer height;
        
    }
	
    // -- Actions
  
    /**
     * Home page
     */
    public static Result index() {
        return ok(
            index.render(form(Hello.class))
        );
    }
  
    /**
     * Handles the form submission.
     */
    public static Result sayHello() {
        Form<Hello> form = form(Hello.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(index.render(form));
        } else {
            Hello data = form.get();
            return ok(
                hello.render(data.width * data.height)
            );
        }
    }
	
	public static Result sayKeliling() {
        Form<Hello> form = form(Hello.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(index.render(form));
        } else {
            Hello data = form.get();
            return ok(
                hello.render(2*(data.width+data.height))
            );
        }
    }

}
