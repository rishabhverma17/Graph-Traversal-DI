import DependencyInjection.BasicModule;
import Driver.DriverClass;
import Traversals.BFS;
import Traversals.DFS;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApplicationMain {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new BasicModule());
        BFS BreadthFirstSearch = injector.getInstance(BFS.class);
        DFS DepthFirstSearch = injector.getInstance(DFS.class);
        DriverClass driverClass = injector.getInstance(DriverClass.class);

        driverClass.run();
    }
}
