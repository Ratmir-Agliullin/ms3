//package main.Test;
//
//import main.models.DAO.UsersDAO;
//import main.models.pojo.Users;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by admin on 26.04.2017.
// */
//public class UserDAOTest {
//    private static Users users;
//   private static  UsersDAO usersDAO;
//
//    @BeforeClass
//    public static void init(){
//        Users users = new Users();
//        UsersDAO usersDAO= new UsersDAO();
//    }
//
//    @AfterClass
//    public static void clearAll(){
//        users = new Users();
//        usersDAO= new UsersDAO();
//            }
//
//    @Test
//    public void TestUsersDAO(){
//users.setPassName("wccdcdcdc");
//users.setUserName("TheGoodUser");
//users.setId(1);
//     usersDAO.InsertUserTable(users);
//        List<Users> usersList = usersDAO.SelectUserTable();
//        for (Users user1:usersList
//             ) { assertTrue(users.getUserName().equals(user1.getUserName())) ;
//            System.out.println("Совпадение нашли");
//
//
//        }
//
//
//    }
//    @Test
//    public void TestProductDAO(){
//        users.setPassName("wccdcdcdc");
//        users.setUserName("TheGoodUser");
//        users.setId(1);
//        usersDAO.InsertUserTable(users);
//        List<Users> usersList = usersDAO.SelectUserTable();
//        for (Users user1:usersList
//                ) { assertTrue(users.getUserName().equals(user1.getUserName())) ;
//            System.out.println("Совпадение нашли");
//
//
//        }
//
//
//    }
//}
