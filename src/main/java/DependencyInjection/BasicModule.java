package DependencyInjection;

import Driver.DriverClass;
import Traversals.BFS;
import Traversals.DFS;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BFS.class)
                .annotatedWith(Names.named("BFS"))
                .to(BFS.class);

        bind(DFS.class)
                .annotatedWith(Names.named("DFS"))
                .to(DFS.class);
        bind(DriverClass.class)
                .annotatedWith(Names.named("Driver"))
                .to(DriverClass.class);
    }
}
