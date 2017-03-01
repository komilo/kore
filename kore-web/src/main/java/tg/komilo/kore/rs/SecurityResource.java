/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.rs;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tg.komilo.kore.service.UserServiceBeanRemote;

/**
 *
 * @author komilo
 */
@Stateless
@Path("security")
public class SecurityResource implements Serializable {

//    @EJB
//    private RestSecurityServiceRemote securityService;
    
    @EJB
    private UserServiceBeanRemote userService;

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("username") String username, 
            @FormParam("password") String password) {
        if (this.userService.login(username, password)) {
            return this.getNoCacheResponseBuilder(Response.Status.OK).build();
        } else {
            return this.getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("logout")
    public Response logout(@Context HttpHeaders httpHeaders) {
        this.userService.logout();
        return this.getNoCacheResponseBuilder(Response.Status.NO_CONTENT).build();
    }
    
    private Response.ResponseBuilder getNoCacheResponseBuilder(Response.Status status) {
        CacheControl cc = new CacheControl();
        cc.setNoCache(true);
        cc.setMaxAge(-1);
        cc.setMustRevalidate(true);
        
        return Response.status(status).cacheControl(cc);
    }
}
