package Model;

import Model.Circuit;
import Model.Stop;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-10T18:02:57")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Integer> number;
    public static volatile SingularAttribute<Route, Integer> idRoute;
    public static volatile SingularAttribute<Route, Integer> price;
    public static volatile SingularAttribute<Route, Double> rating;
    public static volatile SingularAttribute<Route, Stop> lastStop;
    public static volatile ListAttribute<Route, Circuit> circuitList;
    public static volatile SingularAttribute<Route, Stop> firstStop;

}