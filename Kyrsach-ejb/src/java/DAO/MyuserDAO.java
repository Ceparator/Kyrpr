/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Myuser;
import Model.MyuserRole;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 *
 * @author Ceparator
 */
@Stateless
public class MyuserDAO implements MyuserDAOInterface {

    @PersistenceContext(unitName = "Kyrsach-ejbPU2")
    private EntityManager em2;

    @Override
    public void addUser(String username, String password, String role, int routeNumber) throws Exception{
        Myuser myuser = new Myuser();
        myuser.setUsername(username);
        MessageDigest md = MessageDigest.getInstance("MD5");
        password = (new HexBinaryAdapter()).marshal(md.digest(password.getBytes(Charset.forName("UTF-8"))));
        myuser.setPassword(password);
        myuser.setRouteNumber(routeNumber);
        MyuserRole myuserRole = new MyuserRole();
        myuserRole.setUsername(myuser);
        myuserRole.setRole(role);
        em2.persist(myuser);
        em2.flush();
        em2.persist(myuserRole);
        em2.flush();
        List<MyuserRole> myuserRoleList = new ArrayList<>();
        myuserRoleList.add(myuserRole);
        myuser.setMyuserRoleList(myuserRoleList);
        em2.merge(myuser);
    }

    @Override
    public List<Myuser> getAllUsers() {
        Query query = em2.createQuery("SELECT u FROM Myuser u", Myuser.class);
        List<Myuser> myuserList = query.getResultList();
        List<Myuser> userList = new ArrayList<>();
        Iterator<Myuser> iter = myuserList.iterator();
        while (iter.hasNext()) {
            Myuser item = iter.next();
            Myuser someMyuser = new Myuser(item.getUsername(), item.getMyuserRoleList().get(0).getRole(), item.getRouteNumber());
            userList.add(someMyuser);
        }
        return userList;
    }
}
