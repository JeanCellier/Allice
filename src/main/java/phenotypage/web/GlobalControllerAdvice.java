package phenotypage.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 19:51
 * Project: appPhenotypage
 */

@ControllerAdvice
public class GlobalControllerAdvice {


    /**
     * Handles exception and prints them in the error page
     *
     * @param req servlet request to get the failed URL
     * @param e   exception
     * @return model and view
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
