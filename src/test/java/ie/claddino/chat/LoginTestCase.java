package ie.claddino.chat;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration("src/main/chat")
@ContextConfiguration({     
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	 "file:src/main/webapp/WEB-INF/spring-database.xml",
	 "file:src/main/webapp/WEB-INF/spring-security.xml"})
public class LoginTestCase {

	@Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilter;

    private MockMvc mockMvc;

    private final String SECURED_URI = "/";
   

    private final String LOGIN_PAGE_URL = "http://localhost/login";
    
    private static SecurityContext securityContext = userAuthentication();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                // Enable Spring Security
                .addFilters(springSecurityFilter)
                .alwaysDo(print()).build();
    }
    
    @Test
    public void itShouldDenyAnonymousAccess() throws Exception {
        mockMvc.perform(get(SECURED_URI))
                .andExpect(redirectedUrl(LOGIN_PAGE_URL));
    }

    @Test
    public void itShouldAllowAccessToSecuredPageForPermittedUser() throws Exception {
        SecurityContext securityContext = userAuthentication();

        MockHttpSession session = new MockHttpSession();
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

        mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().isOk()).andExpect(redirectedUrl(LOGIN_PAGE_URL));
    }
    
    @Test
    public void itShouldReturnListOfUserFriends() throws Exception {
      

        MockHttpSession session = new MockHttpSession();
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

        mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().isOk());
        
    }

	protected static SecurityContext userAuthentication() {
		Authentication authentication =
                new UsernamePasswordAuthenticationToken("Rich", "rich");
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
		return securityContext;
	}

}
