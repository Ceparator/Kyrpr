package Model;

import Model.Circuit;
import Model.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-05T20:34:28")
@StaticMetamodel(Stop.class)
public class Stop_ { 

    public static volatile SingularAttribute<Stop, Double> coordX;
    public static volatile SingularAttribute<Stop, Double> coordY;
    public static volatile SingularAttribute<Stop, Integer> idStop;
    public static volatile SingularAttribute<Stop, String> name;
    public static volatile ListAttribute<Stop, Circuit> circuitList;
    public static volatile ListAttribute<Stop, Route> routeList1;
    public static volatile ListAttribute<Stop, Route> routeList;

}