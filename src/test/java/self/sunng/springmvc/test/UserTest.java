package self.sunng.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sunxiaodong on 16/7/30.
 */
public class UserTest extends BaseJunit4Test {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        //integrated web enviroment
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        //standalone
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserCtr()).build();
    }

    @Test
    public void createUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .param("name", "sunxiaodong")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users?pageNum=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/users")
                .param("id", "1")
                .param("name", "sunng")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users")
                .param("id", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
