package Model;

import Model.Route;
import Model.Stop;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T00:47:35")
@StaticMetamodel(Circuit.class)
public class Circuit_ { 

    public static volatile SingularAttribute<Circuit, Integer> stopNumber;
    public static volatile SingularAttribute<Circuit, Integer> idCircuit;
    public static volatile SingularAttribute<Circuit, Boolean> tyda;
    public static volatile SingularAttribute<Circuit, Route> idRoute;
    public static volatile SingularAttribute<Circuit, Stop> idStop;

}