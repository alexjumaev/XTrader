package ${corePackageName}.di.scope;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface ActivityScope