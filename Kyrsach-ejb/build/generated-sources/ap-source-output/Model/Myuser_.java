package Model;

import Model.MyuserRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T00:47:35")
@StaticMetamodel(Myuser.class)
public class Myuser_ { 

    public static volatile SingularAttribute<Myuser, String> password;
    public static volatile SingularAttribute<Myuser, Integer> routeNumber;
    public static volatile ListAttribute<Myuser, MyuserRole> myuserRoleList;
    public static volatile SingularAttribute<Myuser, String> username;

}